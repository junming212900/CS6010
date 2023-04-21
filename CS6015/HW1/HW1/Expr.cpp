//
// Created by junming jin on 1/24/23.
//

#include "Expr.h"
#include "string"
#include <stdexcept>
Num::Num(int val) {
    this->val = val;
};
VAR::VAR(std::string var) {
    this->var = var;
};
Add::Add(Expr *lhs, Expr *rhs) {
    this->lhs = lhs;
    this->rhs = rhs;
};
Mult::Mult(Expr *lhs, Expr *rhs) {
    this->lhs = lhs;
    this->rhs = rhs;
};


bool Num::equals(Expr *e) {
    Num* num1 = dynamic_cast<Num*>(e);
    if (num1 == NULL) {
        return false;
    }
    return num1->val == this->val;
//    { return true;}
//    else return false;


}
bool VAR::equals(Expr *e) {
    VAR* var1 = dynamic_cast<VAR*> (e);
    // e cast to VAR
    if (var1 == NULL){
        return false;
    }
    return var1->var == this->var;
//        return true;
//    }
//    return false;
}

bool Add::equals(Expr *e) {
    Add* add1 = dynamic_cast<Add*> (e);
    if (add1 == NULL){ return false;}
    return add1->lhs->equals(this->lhs) && add1->rhs->equals(this->rhs);
//     return true;
//    }else {
//        return false;
}


bool Mult::equals(Expr *e) {
    Mult* mult1= dynamic_cast<Mult*> (e);
    if (mult1 == NULL) {return false;}

    return mult1->lhs->equals(this->lhs) && mult1->rhs->equals(this->rhs);
//        return true;
//    }else {
//        return false;
//    }

}

int Num::interp() {
    return val;
}
Expr* Num::subst(string sub ,Expr *e) {
    return this;
}
bool Num::has_variable() {
    return false;
}
int VAR::interp() {
    throw std::runtime_error("no value for variable");

}
Expr* VAR::subst(string sub ,Expr *e) {
    if (this->var == sub ){
        return e;
    }
    else return  this ;
}
bool VAR::has_variable() {
    return true ;

}
int Add::interp() {

    return this->rhs->interp() + this->lhs->interp();

}
Expr* Add::subst(string sub ,Expr *e) {

return new Add(lhs->subst(sub,e),rhs->subst(sub,e));
}
bool Add::has_variable() {
    // does LHS have a variable?
    // does RHS have a variable?
    return this->lhs->has_variable() || this->rhs->has_variable();

}
int Mult::interp() {
    return this->rhs->interp() * this->lhs->interp();
}
Expr* Mult::subst(string sub ,Expr *e) {
    return new Mult(lhs->subst(sub,e),rhs->subst(sub,e));

}
bool Mult::has_variable() {
    return this->lhs->has_variable() || this->rhs->has_variable();
}

