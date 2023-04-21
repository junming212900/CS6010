//
// Created by junming jin on 4/7/23.
//
#ifndef PROJECT1_ENV_H
#define PROJECT1_ENV_H
#include "pointer.h"
#include <string>


class VAL;

class Env {
public:
    virtual PTR(VAL) lookup(std::string find_name) = 0;
    static PTR(Env) empty;
};

class EmptyEnv : public Env {
public:
    PTR(VAL) lookup(std::string find_name);
};

class ExtendedEnv : public Env {
public:
    std::string name;
    PTR(VAL) val;
    PTR(Env) rest;

    ExtendedEnv(std::string name, PTR(VAL) val, PTR(Env) rest);

    PTR(VAL) lookup(std::string find_name);
};


#endif //PROJECT1_ENV_H
