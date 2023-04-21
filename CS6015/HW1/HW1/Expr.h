//
// Created by junming jin on 1/24/23.
//

#include <stdio.h>
#include <string>
#include <stdexcept>

using namespace std;

#ifndef HW1_EXPR_H
#define HW1_EXPR_H

#endif //HW1_EXPR_H
class Expr {
public:
    virtual bool equals(Expr *e) = 0;
    virtual int interp() = 0;
    virtual Expr* subst(string sub ,Expr *e) = 0;
    virtual bool has_variable()= 0;
};

class Num : public Expr {
public:
    int val;
    Num(int val);
    bool equals(Expr* e);
    int interp() ;
    Expr* subst(string sub ,Expr *e);
    bool has_variable();
};



class Add : public Expr{
public:
    Expr*lhs;
    Expr*rhs;
    Add(Expr *lhs, Expr *rhs);
    bool equals(Expr* e);
    int interp() ;
    Expr* subst(string sub ,Expr *e) ;
    bool has_variable();
};
class Mult : public Expr {
public:
    Expr *lhs;
    Expr *rhs;
    Mult(Expr *lhs, Expr *rhs);
    bool equals(Expr* e);
    int interp();
    Expr* subst(string sub ,Expr *e) ;
    bool has_variable();
};

class VAR : public Expr {
public:
    std::string var;
    VAR( std::string var);
    bool equals(Expr* e);
    int interp();
    Expr* subst(string sub ,Expr *e);
    bool has_variable();
};