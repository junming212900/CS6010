// Created by junming jin on 4/7/23.
//
#include "Env.h"
#include "VAL.h"

PTR(Env) Env::empty = NEW(EmptyEnv)();
// EmptyEnv class methods
PTR(VAL) EmptyEnv::lookup(std::string find_name) {
    throw std::runtime_error("free variable: " + find_name);
}

// ExtendedEnv class methods
//ExtendedEnv::ExtendedEnv(std::string name, PTR(VAL) val, PTR(Env) rest)
//        : name(name), val(val), rest(rest) {}

ExtendedEnv::ExtendedEnv(std::string name, PTR(VAL) val, PTR(Env) rest) {
    this->name = name;
    this->val = val;
    this->rest = rest;
}

PTR(VAL) ExtendedEnv::lookup(std::string find_name) {
    if (find_name == name) {
        return val;
    } else {
        return rest->lookup(find_name);
    }
}