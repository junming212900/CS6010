//
// Created by junming jin on 3/4/23.
//

#include "pointer.h"
#include "VAL.h"
#include "Expr.h"
#include "Env.h"

bool NumVal::equals(PTR(VAL) v) {
    PTR(NumVal) num = CAST(NumVal)(v);
    return num && num->val == val;
}

PTR(VAL) NumVal::add_to(PTR(VAL) other) {
    PTR(NumVal) num = CAST(NumVal)(other);
    if (num == nullptr){
        throw std::runtime_error("add of non-number");
    }

    return NEW(NumVal)(val + num->val);
}

PTR(VAL) NumVal::mult_with(PTR(VAL) other) {
    PTR(NumVal) num = CAST(NumVal)(other);
    if (num != nullptr) {
        return NEW(NumVal)(val * num->val);
    }
    else{
        throw std::runtime_error("mult of non-number");
    }
}

std::string NumVal::to_string() {
    return std::to_string(val);
}

PTR(Expr) NumVal::to_expr() {
    return NEW(NumExpr)(val);
}

bool NumVal::is_true() {
    return val != 0;
}

PTR(VAL) NumVal::call(PTR(VAL) actual_arg) {
    throw std::runtime_error("NumVal objects are not callable.");
}


// boolVal class methods
bool boolVal::equals(PTR(VAL) v) {
    PTR(boolVal) bv = CAST(boolVal)(v);
    return bv && bv->val == val;
}

PTR(VAL) boolVal::add_to(PTR(VAL) other) {
    throw std::runtime_error("add of non-number");
}

PTR(VAL) boolVal::mult_with(PTR(VAL) other) {
    throw std::runtime_error("mult of non-number");
}

std::string boolVal::to_string() {
    return val ? "true" : "false";
}

PTR(Expr) boolVal::to_expr() {
    return NEW(BoolExpr)(val);
}

bool boolVal::is_true() {
    return val;
}

PTR(VAL) boolVal::call(PTR(VAL) actual_arg) {
    throw std::runtime_error("boolVal objects are not callable.");
}

FunVal::FunVal(std::string formal_arg, PTR(Expr) body, PTR(Env) env) {
    this->formal_arg = formal_arg;
    this->body = body;
    this->env = env;

}

bool FunVal::equals(PTR(VAL) v) {
    if (PTR(FunVal) other_funval = CAST(FunVal)(v)) {
        return (formal_arg == other_funval->formal_arg) && (body->equals(other_funval->body));
    }
    return false;
}

PTR(VAL) FunVal::add_to(PTR(VAL) other) {
    throw std::runtime_error("Function addition is not supported.");
}

PTR(VAL) FunVal::mult_with(PTR(VAL) other) {
    throw std::runtime_error("Function multiplication is not supported.");
}

std::string FunVal::to_string() {
    return "FunVal(" + formal_arg + ", " + body->to_string() + ")";
}

PTR(Expr) FunVal::to_expr() {
    return NEW(FunExpr)(formal_arg, body);
}

bool FunVal::is_true() {
    throw std::runtime_error("Function truthiness is not well-defined.");
}

PTR(VAL) FunVal::call(PTR(VAL) actual_arg){
    return body->interp(NEW(ExtendedEnv)(formal_arg, actual_arg, env));
}
