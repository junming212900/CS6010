#ifndef PROJECT1_VAL_H
#define PROJECT1_VAL_H

#include <string>
#include "pointer.h"

class Expr;
class Env;
CLASS(VAL) {
public:
    virtual ~VAL() {}
    virtual bool equals(PTR(VAL) v) = 0;
    virtual PTR(VAL) add_to(PTR(VAL) other) = 0;
    virtual PTR(VAL) mult_with(PTR(VAL) other) = 0;
    virtual std::string to_string() = 0;
    virtual PTR(Expr) to_expr() = 0;
    virtual bool is_true() = 0;
    virtual PTR(VAL) call(PTR(VAL) actual_arg) = 0;
};

class NumVal : public VAL {
    int val;
public:
    NumVal(int v) : val(v) {}
    bool equals(PTR(VAL) v);
    PTR(VAL) add_to(PTR(VAL) other) ;
    PTR(VAL) mult_with(PTR(VAL) other) ;
    std::string to_string();
    PTR(Expr) to_expr() ;
    bool is_true() ;
    PTR(VAL) call(PTR(VAL) actual_arg) ;

};

class boolVal : public VAL {
    bool val;
public:
    boolVal(bool v) : val(v) {}
    bool equals(PTR(VAL) v) ;
    PTR(VAL) add_to(PTR(VAL) other) ;
    PTR(VAL) mult_with(PTR(VAL) other) ;
    std::string to_string() ;
    PTR(Expr) to_expr() ;
    bool is_true() ;
    PTR(VAL) call(PTR(VAL) actual_arg) ;

};
class FunVal : public VAL {
public:
    std::string formal_arg;
    PTR(Expr)body;
    PTR(Env) env;
    FunVal(std::string formal_arg, PTR(Expr) body, PTR(Env) env);
//    FunVal(const std::string& formal_arg, PTR(Expr) body) : formal_arg(formal_arg), body(body) {}
    bool equals(PTR(VAL) v) ;
    PTR(VAL) add_to(PTR(VAL) other) ;
    PTR(VAL) mult_with(PTR(VAL) other) ;
    std::string to_string() ;
    PTR(Expr) to_expr() ;
    bool is_true() ;
    PTR(VAL) call(PTR(VAL) actual_arg) ;
};

#endif //PROJECT1_VAL_H

