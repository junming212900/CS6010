/**
* \file expression.h
* \brief expression class
*
* declare expr function, variables, and other constructs that can be used in this program.
*/

#include <memory>
#include <string>
#include <iostream>
#include <stdexcept>
#include "pointer.h"
class VAL;
class Env;

using namespace std;

#ifndef HW1_EXPR_H
#define HW1_EXPR_H

#endif //HW1_EXPR_H

typedef enum {
    prec_none,      // = 0
    prec_add,       // = 1
    prec_mult,      // = 2
    prec_let,
} precedence_t;

CLASS(Expr) {
public:
    virtual bool equals(PTR(Expr) e) = 0;
    virtual PTR(VAL) interp(PTR(Env) env) = 0;
//    virtual PTR(Expr) subst(string sub, PTR(Expr) e) = 0;
//    virtual bool has_variable() = 0;
    virtual void print(std::ostream &ot) = 0;
    virtual std::string to_string();
    std::string pretty_print_at_to_string();
    virtual void pretty_print_at(std::ostream&, precedence_t, std::streampos pos, bool letParenth) = 0;
    void pretty_print(std::ostream &ot);
};

class Num : public Expr {
public:
    int val;
    Num(int val);
    bool equals(PTR(Expr) e);
    PTR(VAL) interp(PTR(Env) env); ;
//    PTR(Expr) subst(string sub ,PTR(Expr)e);
//    bool has_variable();
    void print(std::ostream &ot);
//    int eval();
    void pretty_print_at(std::ostream&,precedence_t, std::streampos pos, bool letParenth );


};



class Add : public Expr{
public:
    PTR(Expr)lhs;
    PTR(Expr)rhs;
    Add(PTR(Expr)lhs, PTR(Expr)rhs);
    bool equals(PTR(Expr) e);
    PTR(VAL) interp(PTR(Env) env) ;
//    PTR(Expr) subst(string sub ,PTR(Expr)e) ;
//    bool has_variable();
    void print(std::ostream &ot);
//    int eval();
    void pretty_print_at(std::ostream&,precedence_t , std::streampos pos, bool letParenth);

};
class Mult : public Expr {
public:
    PTR(Expr)lhs;
    PTR(Expr)rhs;
    Mult(PTR(Expr)lhs, PTR(Expr)rhs);
    bool equals(PTR(Expr) e);
    PTR(VAL) interp(PTR(Env) env);
//    PTR(Expr) subst(string sub ,PTR(Expr)e) ;
//    bool has_variable();
    void print(std::ostream &ot);
//    int eval();
    void pretty_print_at(std::ostream&,precedence_t , std::streampos pos, bool letParenth);
};

class VAR : public Expr {
public:
    std::string var;
    VAR( std::string var);
    bool equals(PTR(Expr) e);
    PTR(VAL) interp(PTR(Env) env);
//    PTR(Expr) subst(string sub ,PTR(Expr)e);
//    bool has_variable();
    void print(std::ostream &ot);
//    int eval();
    void pretty_print_at(std::ostream&,precedence_t, std::streampos pos, bool letParenth );
};

class Let : public Expr {
public:
    PTR(VAR) var;
    PTR(Expr)rhs;
    PTR(Expr)body;
    Let(PTR(VAR) var, PTR(Expr)rhs, PTR(Expr)body);
    bool equals(PTR(Expr) e);
    PTR(VAL) interp(PTR(Env) env) ;
//    PTR(Expr) subst(string sub ,PTR(Expr)e);
//    bool has_variable();
    void print(std::ostream &ot);
//    int eval();
    void pretty_print_at(std::ostream&,precedence_t , std::streampos pos, bool letParenth);
};

class NumExpr : public Expr {
public:
    int val;
    NumExpr(int val);
    bool equals(PTR(Expr)e);
    PTR(VAL)interp(PTR(Env) env);
//    PTR(Expr)subst(string sub, PTR(Expr)e);
//    bool has_variable();
    void print(std::ostream &ot);
//    int eval();
    std::string to_string();
    void pretty_print_at(std::ostream &out, precedence_t prec, std::streampos pos, bool letParenth);
};
class BoolExpr : public Expr {
public:
    bool value;
    BoolExpr(bool value);

    bool equals(PTR(Expr)e) ;
    PTR(VAL) interp(PTR(Env) env) ;
//    PTR(Expr) subst(string sub, PTR(Expr)e) ;
//    bool has_variable() ;
    void print(std::ostream &ot) ;
//    int eval() ;
    void pretty_print_at(std::ostream&, precedence_t, std::streampos pos, bool letParenth) ;


};

class IfExpr : public Expr {
public:
    PTR(Expr)condition;
    PTR(Expr)thenBranch;
    PTR(Expr)elseBranch;
    IfExpr(PTR(Expr)condition, PTR(Expr)thenBranch, PTR(Expr)elseBranch)
            : condition(condition), thenBranch(thenBranch), elseBranch(elseBranch) {}

    bool equals(PTR(Expr)e) ;
    PTR(VAL) interp(PTR(Env) env) ;
//    PTR(Expr) subst(string sub, PTR(Expr)e) ;
//    bool has_variable() ;
    void print(std::ostream &ot) ;
//    int eval() ;
    void pretty_print_at(std::ostream&, precedence_t, std::streampos pos, bool letParenth) ;
};

class EqExpr : public Expr {
public:
    PTR(Expr)left;
    PTR(Expr)right;
    EqExpr(PTR(Expr)left, PTR(Expr)right);

    bool equals(PTR(Expr)e) ;
    PTR(VAL) interp(PTR(Env) env) ;
//    PTR(Expr) subst(string sub, PTR(Expr)e) ;
//    bool has_variable() ;
    void print(std::ostream &ot) ;
//    int eval() ;
    void pretty_print_at(std::ostream&, precedence_t, std::streampos pos, bool letParenth) ;


};
class FunExpr : public Expr {
public:
    std::string formal_arg;
    PTR(Expr)body;
    FunExpr(std::string formal_arg, PTR(Expr)body){
        this->formal_arg = formal_arg;
        this->body = body;
    }
//    FunExpr(const std::string &formal_arg, PTR(Expr)body)
//            : formal_arg(formal_arg), body(body) {}

    bool equals(PTR(Expr)e) ;
    PTR(VAL) interp(PTR(Env) env) ;
//    PTR(Expr) subst(std::string sub, PTR(Expr)e) ;
//    bool has_variable() ;
    void print(std::ostream &ot) ;
    void pretty_print_at(std::ostream &os, precedence_t precedence, std::streampos pos, bool letParenth) ;
};

class CallExpr : public Expr {
public:
    PTR(Expr)to_be_called;
    PTR(Expr)actual_arg;
    CallExpr(PTR(Expr)to_be_called, PTR(Expr)actual_arg)
            : to_be_called(to_be_called), actual_arg(actual_arg) {}

    bool equals(PTR(Expr)e) ;
    PTR(VAL) interp(PTR(Env) env) ;
//    PTR(Expr) subst(std::string sub, PTR(Expr)e) ;
//    bool has_variable() ;
    void print(std::ostream &ot) ;
    void pretty_print_at(std::ostream &os, precedence_t precedence, std::streampos pos, bool letParenth) ;
};
//#endif //PROJECT1_EXPR_H