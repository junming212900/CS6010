//
// Created by junming jin on 2/21/23.
//
#ifndef PROJECT1_PARSE_H
#define PROJECT1_PARSE_H

#include "pointer.h"
#include <iostream>
#include <string>

class Expr;

extern PTR(Expr) parse_expr(std::istream&);
extern PTR(Expr) parse_addend(std::istream&);
extern PTR(Expr) parse_multicand(std::istream&);
extern PTR(Expr) parese_num(std::istream&);
extern std::string parse_var(std::istream&);
extern PTR(Expr) parse_let(std::istream&);
extern PTR(Expr) parse_comparg(std::istream&);
extern PTR(Expr) parse_inner(std::istream&);
extern PTR(Expr) parse_if(std::istream&);
extern PTR(Expr) parse_fun(std::istream&);
extern void skip_whitespace(std::istream&);
static void consume(std::istream &in,int expected);
extern PTR(Expr) parse_str(std::string s);

#endif //PROJECT1_PARSE_H
// (9 + 5)