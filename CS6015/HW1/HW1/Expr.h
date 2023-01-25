//
// Created by junming jin on 1/24/23.
//

#include <stdio.h>
#include <string>

using namespace std;

#ifndef HW1_EXPR_H
#define HW1_EXPR_H

#endif //HW1_EXPR_H
class Expr {
public:
    virtual bool equals(Expr *e) = 0;
};

class Num : public Expr {
public:
    int val;
    Num(int val);
    bool equals(Expr* e);
};



class Add : public Expr{
public:
    Expr*lhs;
    Expr*rhs;
    Add(Expr *lhs, Expr *rhs);
    bool equals(Expr* e);
};
class Mult : public Expr {
public:
    Expr *lhs;
    Expr *rhs;
    Mult(Expr *lhs, Expr *rhs);
    bool equals(Expr* e);
};

class VAR : public Expr {
public:
    char var;
    VAR( char var);
    bool equals(Expr* e);
};