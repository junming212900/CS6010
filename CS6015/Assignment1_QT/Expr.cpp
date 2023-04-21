/**
* \file expression.cpp
* \brief contains expression class
definition
*
*
* expression.cpp has contain all expr methods under 4 major Expr
* \author Junming Jin
*/

#include "Expr.h"
#include <string>
#include <stdexcept>
#include <sstream>
#include "VAL.h"
#include <memory>
#include "Env.h"


std::string Expr::to_string() {
    std::stringstream st("");
    this->print(st);
    return st.str();
}

std::string Expr::pretty_print_at_to_string() {
    std::ostringstream oss;
    pretty_print(oss);
    return oss.str();
}

void Expr::pretty_print(std::ostream &ot) {
    pretty_print_at(ot, prec_none, 0, false);
}

Num::Num(int val) {
    this->val = val;
};

VAR::VAR(std::string var) {
    this->var = var;
};

Add::Add(PTR(Expr) lhs, PTR(Expr) rhs) {
    this->lhs = lhs;
    this->rhs = rhs;
};

Mult::Mult(PTR(Expr) lhs, PTR(Expr) rhs) {
    this->lhs = lhs;
    this->rhs = rhs;
};

Let::Let(PTR(VAR) var, PTR(Expr) rhs, PTR(Expr) body) {
    this->var = var;
    this->rhs = rhs;
    this->body = body;
};

NumExpr::NumExpr(int val) : val(val) {};

BoolExpr::BoolExpr(bool value) : value(value) {};

EqExpr::EqExpr(PTR(Expr) left, PTR(Expr) right) : left(left), right(right) {};


/**
* \brief Determine if two numbers are equal
* \param True if the numbers entered determine the same number
* \param False if the entered numbers determine that the numbers are not the same or enter Null
* \return true or false these number either equal to each-other
*/

bool Num::equals(PTR(Expr)e) {
    PTR(Num) num1 = CAST(Num)(e);
    if (num1 == NULL) {
        return false;
    }
    return num1->val == this->val;
}

//bool NumVal::equals(PTR(VAL) v) {
//    PTR(NumVal) num = CAST(NumVal)(v);
//    return num && num->val == val;
//}
/**
* \brief Determine if two variable are equal
* \param True if the variable entered determine the same number
* \param False if the entered variable determine that the numbers are not the same or enter Null
* \return true or false these variable either equal to each-other
*/
bool VAR::equals(PTR(Expr)e) {
    PTR(VAR) var1 = CAST(VAR) (e);
    // e cast to VAR
    if (var1 == NULL){
        return false;
    }
    return var1->var == this->var;
//        return true;
//    }
//    return false;
}
/**
* \brief Determine if two adding function are equal
* \param True if the two numbers being added and their positions in the equation are the same
* \param False If the two numbers added or their positions in the equation are not the same, it is judged as false or enter Null
* \return true or false these variable either equal to each-other
*/
bool Add::equals(PTR(Expr)e) {
    PTR(Add) add1 = CAST(Add) (e);
    if (add1 == NULL){ return false;}
    return add1->lhs->equals(this->lhs) && add1->rhs->equals(this->rhs);
//     return true;
//    }else {
//        return false;
}
/**
* \brief Determine if two multiplied function are equal
* \param True if the two numbers being multiplied and their positions in the equation are the same
* \param False If the two numbers multiplied or their positions in the equation are not the same, it is judged as false or enter Null
* \return true or false these variable either equal to each-other
*/

bool Mult::equals(PTR(Expr)e) {
    PTR(Mult) mult1= CAST(Mult) (e);
    if (mult1 == NULL) {return false;}

    return mult1->lhs->equals(this->lhs) && mult1->rhs->equals(this->rhs);
}


bool Let::equals(PTR(Expr) e) {
    PTR(Let) let = CAST(Let)(e);
    if (let == NULL) {
        return false;
    }
    return (let->var->equals(this->var) && let->rhs->equals( this->rhs) && let->body ->equals( this->body));
}

//bool Let::has_variable() {
//    return body->has_variable() || rhs->has_variable();
//}

PTR(VAL) Let ::interp(PTR(Env) env) {
    // interp the rhs
    PTR(VAL) rhs_val = rhs->interp(env);
    PTR(Env) new_env = NEW(ExtendedEnv)(var->to_string(), rhs_val, env);
    // call interp on the substExpr
    return body->interp(new_env);

//    delete substExpr; // free the memory allocated by substExpr
//    return result;

}
//PTR(Expr) Let::subst(string sub ,PTR(Expr)e) {
//    PTR(Expr) substRHS = rhs->subst(sub, e);
//    // always call subst on the RHS
//    PTR(Expr)substBody = body->subst(sub, e);
//    if( this->var->to_string() == sub ) {
//
//        // if var == sub, call subst on body
//
//        return NEW(Let)(var, substRHS, substBody);
//    }
//    return NEW(Let) ( var, substRHS,body );
//}

void Let::print(std::ostream &ot) {
    ot << "(_let ";
    var->print(ot);
    ot << " = ";
    rhs->print(ot);
    ot << " _in ";
    body->print(ot);
    ot << ")";
}

void Let::pretty_print_at(std::ostream &ot,precedence_t prec, std::streampos pos, bool letParenth){
// check if you need parentheses
//    bool needParenth = (prec > prec_let) || (prec == prec_let && letParenth);

    if (letParenth) {// write opening parentheses if needed
        ot << "(";
    }
    // use tellp() to get your current position in the stream
    std::streampos curPos = ot.tellp();
    // the difference between your current position and pos is how far you need to indent
    int indent = curPos - pos;

    // print variable declaration
    ot << "_let ";
    this->var->pretty_print_at(ot, prec_none, curPos, false);
//    ot << this->var->var;
    ot << " = ";
    rhs->pretty_print_at(ot, prec_none, curPos, true);
    ot << "\n";
    // after the line break use tellp() to set your current position to pos
    pos = ot.tellp();
    // indent
    for (int i = 0; i < indent; i++) {
        ot << " ";
    }
    // print body
    ot << " _in ";
    body->pretty_print_at(ot, prec_none, curPos, true);

//    // write the rest of the second line
//    ot << "_let " << var << " = ";
//    rhs->pretty_print_at(ot, prec_let, curPos, false);
//    ot << " _in ";
//    body->pretty_print_at(ot, prec_let, curPos, false);
    // write closing parentheses if you wrote open parentheses
    if (letParenth) {
        // write closing parentheses if needed
        ot << ")";
    }
}



/**
* \brief Check if the value is a number
* \return return original value
*/
PTR(VAL) Num::interp(PTR(Env) env) {
    return NEW(NumVal)(val);
}
/**
* \brief Replace the original numeric value with the value of expr
* \return return original value
*/
//PTR(Expr) Num::subst(string sub ,PTR(Expr)e) {
//    return THIS;
//}
/**
* \brief Check if the value has_variabl
* \return return false
*/
//bool Num::has_variable() {
//    return false;
//}

void Num::print(std::ostream &ot) {

    ot << std::to_string(val);

}
void Num::pretty_print_at(std::ostream &ot,precedence_t, std::streampos pos, bool letParenth ){
    ot << val;
}
/**
* \brief Check if the value is a number
* \return throw a error information
*/
PTR(VAL) VAR::interp(PTR(Env) env) {
    throw std::runtime_error("no value for variable");

}
/**
* \brief Replace the original numeric value with the value of expr
* \return return replace original with substitution
*/
//PTR(Expr) VAR::subst(string sub ,PTR(Expr)e) {
//    if (this->var == sub ){
//        return e;
//    }
//    else return  THIS ;
//}
/**
* \brief Check if the variable has_variable
* \return return true
*/
//bool VAR::has_variable() {
//    return true ;
//
//}

void VAR ::print(std::ostream &ot) {

    ot<< this->to_string();


}
void VAR::pretty_print_at(std::ostream &ot,precedence_t, std::streampos pos, bool letParenth ){
    ot << this->to_string();
}

/**
* \brief Check if rhs or lhs is a number in adding function
* \return Returns the value after verification by the interp method
*/
PTR(VAL) Add::interp(PTR(Env) env) {

    return lhs->interp(env)->add_to(rhs->interp(env));

}

/**
* \brief Check if rhs or lhs satisfies the replaceable variable
* \return replace this varable with expr
*/
//PTR(Expr) Add::subst(string sub ,PTR(Expr)e) {
//
//    return NEW(Add)(lhs->subst(sub,e),rhs->subst(sub,e));
//}
/**
* \brief Check whether rhs or lhs has string variable
* \return true
*/
//bool Add::has_variable() {
//    // does LHS have a variable?
//    // does RHS have a variable?
//    return this->lhs->has_variable() || this->rhs->has_variable();
//
//}

void Add::print(std::ostream &ot) {

    ot << '(';
    lhs->print(ot);
    ot << '+';
    rhs->print(ot);
    ot << ')';

}
void Add::pretty_print_at(std::ostream &ot,precedence_t prec, std::streampos pos, bool letParenth){
    if (prec >= prec_add) ot << "(";
    lhs->pretty_print_at(ot, prec_add,pos,letParenth);
    ot << " + ";
    rhs->pretty_print_at(ot, prec_none,pos,letParenth);
    if (prec >= prec_add) ot << ")";

}

/**
* \brief Check if rhs or lhs is a number in  multiplie function
* \return Returns the value after verification by the interp method
*/
PTR(VAL) Mult::interp(PTR(Env) env) {
    return this->rhs->interp(env)->mult_with(this->lhs->interp(env)) ;
}

/**
* \brief Check if rhs or lhs satisfies the replaceable variable
* \return replace this varable with expr
*/
//PTR(Expr) Mult::subst(string sub ,PTR(Expr)e) {
//    return NEW(Mult)(lhs->subst(sub,e),rhs->subst(sub,e));
//
//}

/**
* \brief Check whether rhs or lhs has string variable
* \return true
*/
//bool Mult::has_variable() {
//    return this->lhs->has_variable() || this->rhs->has_variable();
//}
void Mult::print(std::ostream &ot) {
    ot << '(';
    lhs->print(ot);
    ot << '*';
    rhs->print(ot);
    ot << ')';


}
void Mult::pretty_print_at(std::ostream &ot,precedence_t prec,std::streampos pos, bool letParenth){
    if (prec == prec_mult) ot << "(";
    lhs->pretty_print_at(ot, prec_mult,pos,letParenth);
    ot << " * ";
    rhs->pretty_print_at(ot, prec_add,pos, letParenth);
    if (prec == prec_mult) ot << ")";
}



bool NumExpr::equals(PTR(Expr)e) {
    PTR(NumExpr)numExpr = CAST(NumExpr)(e);
    return numExpr && val == numExpr->val;
}

PTR(VAL)NumExpr::interp(PTR(Env) env)  {
    return NEW(NumVal)(val);
}

//PTR(Expr)NumExpr::subst(string sub, PTR(Expr)e) {
//    return THIS;
//}

//bool NumExpr::has_variable() {
//    return false;
//}

void NumExpr::print(std::ostream &ot) {
    ot << val;
}

//int NumExpr::eval() {
//    return val;
//}

std::string NumExpr::to_string() {
    return std::to_string(val);
}

void NumExpr::pretty_print_at(std::ostream &out, precedence_t prec, std::streampos pos, bool letParenth) {
    out << val;
}

bool BoolExpr::equals(PTR(Expr)e) {
    PTR(BoolExpr)boolExpr = CAST(BoolExpr)(e);
    return boolExpr && value == boolExpr->value;
}

PTR(VAL) BoolExpr::interp(PTR(Env) env) {
    return NEW(boolVal)(this->value);
}

//PTR(Expr)BoolExpr::subst(string sub, PTR(Expr)e) {
//    return THIS;
//}

//bool BoolExpr::has_variable() {
//    return false;
//}

void BoolExpr::print(std::ostream &ot) {
    ot << (value ? "true" : "false");
}

//int BoolExpr::eval() {
//    return value ? 1 : 0;
//}

void BoolExpr::pretty_print_at(std::ostream &out, precedence_t prec, std::streampos pos, bool letParenth) {
    out << (value ? "true" : "false");
}

bool IfExpr::equals(PTR(Expr)e) {
    PTR(IfExpr)ifExpr = CAST(IfExpr)(e);
    return ifExpr && condition->equals(ifExpr->condition) && thenBranch->equals(ifExpr->thenBranch) && elseBranch->equals(ifExpr->elseBranch);
}

PTR(VAL) IfExpr::interp(PTR(Env) env) {
    return condition->interp(env)->is_true() ? thenBranch->interp(env) : elseBranch->interp(env);
}

//PTR(Expr)IfExpr::subst(string sub, PTR(Expr)e) {
//    return NEW(IfExpr)(condition->subst(sub, e), thenBranch->subst(sub, e), elseBranch->subst(sub, e));
//}

//bool IfExpr::has_variable() {
//    return condition->has_variable() || thenBranch->has_variable() || elseBranch->has_variable();
//}

void IfExpr::print(std::ostream &ot) {
    ot << "if (" << condition->to_string() << ") " << thenBranch->to_string() << " else " << elseBranch->to_string();
}

//VAL* IfExpr::eval() {
//    return interp();
//}

void IfExpr::pretty_print_at(std::ostream &out, precedence_t prec, std::streampos pos, bool letParenth) {
    out << "if (" << condition->to_string() << ") " << thenBranch->to_string() << " else " << elseBranch->to_string();
}

// EqExpr implementation
bool EqExpr::equals(PTR(Expr)e) {
    PTR(EqExpr)eqExpr = CAST(EqExpr)(e);
    return eqExpr && left->equals(eqExpr->left) && right->equals(eqExpr->right);
}

PTR(VAL) EqExpr::interp(PTR(Env) env) {
    if (left->interp(env)->to_string() == right->interp(env)->to_string()){
        return NEW(boolVal)(true);
    }
    else {
        return NEW(boolVal)(false);
    }
}

//PTR(Expr)EqExpr::subst(string sub, PTR(Expr)e) {
//    return NEW(EqExpr)(left->subst(sub, e), right->subst(sub, e));
//}

//bool EqExpr::has_variable() {
//    return left->has_variable() || right->has_variable();
//}

void EqExpr::print(std::ostream &ot) {
    ot << "(" << left->to_string() << " == " << right->to_string() << ")";
}
//
//int EqExpr::eval() {
//    return interp();
//}

void EqExpr::pretty_print_at(std::ostream &out, precedence_t prec, std::streampos pos, bool letParenth) {
    out << "(" << left->to_string() << " == " << right->to_string() << ")";
}

bool FunExpr::equals(PTR(Expr)e) {
    PTR(FunExpr)other = CAST(FunExpr)(e);
    if (!other) return false;
    return formal_arg == other->formal_arg && body->equals(other->body);
}

PTR(VAL) FunExpr::interp(PTR(Env) env) {
    return NEW(FunVal)(formal_arg, body, env);
}

//PTR(Expr) FunExpr::subst(std::string sub, PTR(Expr)e) {
//    if (sub == formal_arg) {
//        return THIS;
//    } else {
//        return NEW(FunExpr)(formal_arg, body->subst(sub, e));
//    }
//}

//bool FunExpr::has_variable() {
//    return body->has_variable();
//}

void FunExpr::print(std::ostream &ot) {
    ot << "(_fun (" << formal_arg << ") ";
    body->print(ot);
    ot << ")";
}

void FunExpr::pretty_print_at(std::ostream &os, precedence_t precedence, std::streampos pos, bool letParenth) {
    os << "(_fun (" << formal_arg << ")\n";
    std::streamoff offset = pos - os.tellp(); // Calculate the offset
    body->pretty_print_at(os, prec_none, pos + (offset + 2), false);
    os << ")";
}

// CallExpr implementation
bool CallExpr::equals(PTR(Expr)e) {
    PTR(CallExpr)other = CAST(CallExpr)(e);
    if (!other) return false;
    return to_be_called->equals(other->to_be_called) && actual_arg->equals(other->actual_arg);
}

PTR(VAL) CallExpr::interp(PTR(Env) env) {
    // Evaluate the function and argument
    PTR(FunVal) fun_val = CAST(FunVal)(to_be_called->interp(env));
    PTR(VAL) arg_val = actual_arg->interp(env);

    return fun_val->call(arg_val);

}

//PTR(Expr) CallExpr::subst(std::string sub, PTR(Expr)e) {
//    return NEW(CallExpr)(to_be_called->subst(sub, e), actual_arg->subst(sub, e));
//}

//bool CallExpr::has_variable() {
//    return to_be_called->has_variable() || actual_arg->has_variable();
//}

void CallExpr::print(std::ostream &ot) {
    to_be_called->print(ot);
    ot << "(";
    actual_arg->print(ot);
    ot << ")";
}

void CallExpr::pretty_print_at(std::ostream &os, precedence_t precedence, std::streampos pos, bool letParenth) {
    to_be_called->pretty_print_at(os, prec_none, pos, false);
    os << "(";
    actual_arg->pretty_print_at(os, prec_none, 0, false);
    os << ")";
}


