//
// Created by junming jin on 2/21/23.
//

#include "pointer.h"
#include "parse.h"
#include "Expr.h"
#include <sstream>

PTR(Expr) parse_num(std::istream &in) {
    int n = 0;
    bool negative = false;
    if (in.peek() == '-') {
        negative = true;
        consume(in, '-');
    }

    while (1) {
        int c = in.peek();
        if (isdigit(c)) {
            consume(in, c);
            n = n*10 + (c - '0');
        } else
            break;
    }
    if (negative)
        n = -n;
    return NEW(Num)(n);
}

std::string parse_var(std::istream &in) {
    std::string name;
    int c = in.peek();
    while (isalpha(c)) {
        name += in.get();
        c = in.peek();
    }
    return name;
}

void skip_whitespace(std::istream &in) {
    while (1) {
        int c = in.peek();
        if (!isspace(c))
            break;
        consume(in, c);
    }
}

void consume(std::istream &in,int expected){
    char c = in.get();
    if(c!=expected){
        throw std::runtime_error("error with consume: '" + to_string(c) + "'");
    }
}

static std::string parse_keyWord(std::istream &in){
    consume(in, '_');
    std::string temp ="";
    char c = in.peek();
    while (isalpha(c)) {
        temp += c;
        consume(in, c);
        c = in.peek();
    }
    return temp;
}

PTR(Expr) parse_let(std::istream &in) {
    skip_whitespace(in);
    PTR(VAR) var;
    PTR(Expr) rhs;
    PTR(Expr) body;

    var = NEW(VAR)(parse_var(in));
    skip_whitespace(in);
    consume(in, '=');
    skip_whitespace(in);
    rhs = parse_expr(in);
    skip_whitespace(in);

    std::string keyword = parse_keyWord(in);
    if (keyword != "in") {
        throw std::runtime_error("invalid keyword: expected _in, found " + keyword);
    }

    skip_whitespace(in);
    body = parse_expr(in);
    return NEW(Let)(var, rhs, body);
}

PTR(Expr) parse_if(std::istream& in) {
    skip_whitespace(in);
    PTR(Expr) e1 = parse_expr(in);
    skip_whitespace(in);
    std::string keyword = parse_keyWord(in);
    if (keyword != "then")
        throw std::runtime_error("missing _then keyword");
    PTR(Expr) e2 = parse_expr(in);
    skip_whitespace(in);
    keyword = parse_keyWord(in);
    if (keyword != "else")
        throw std::runtime_error("missing _else keyword");
    PTR(Expr) e3 = parse_expr(in);
    return NEW(IfExpr)(e1, e2, e3);
}

PTR(Expr) parse_fun(std::istream& in) {
    skip_whitespace(in);
    consume(in, '(');
    skip_whitespace(in);

    std::string var = parse_var(in);
    skip_whitespace(in);

    consume(in, ')');
    skip_whitespace(in);

    PTR(Expr) e = parse_expr(in);
    return NEW(FunExpr)(var, e);
}

PTR(Expr) parse_expr(std::istream &in) {
    skip_whitespace(in);

    PTR(Expr) e = parse_comparg(in);
    skip_whitespace(in);
    int c = in.peek();
    if (c == '=') {
        consume(in, '=');
        c = in.peek();
        if (c == '=') {
            consume(in, '=');
            PTR(Expr) rhs = parse_expr(in);
            e = NEW(EqExpr)(e, rhs);
        }
    }

    return e;
}

PTR(Expr) parse_comparg(std::istream &in) {
    skip_whitespace(in);
    PTR(Expr) e = parse_addend(in);

    skip_whitespace(in);
    int c = in.peek();
    while (c == '+') {
        consume(in, '+');
        PTR(Expr) rhs = parse_comparg(in);
        e = NEW(Add)(e, rhs);
        skip_whitespace(in);
        c = in.peek();
    }

    return e;
}

PTR(Expr) parse_addend(std::istream &in) {
    skip_whitespace(in);
    PTR(Expr) e = parse_multicand(in);

    skip_whitespace(in);
    int c = in.peek();
    while (c == '*') {
        consume(in, '*');
        PTR(Expr) rhs = parse_addend(in);
        e = NEW(Mult)(e, rhs);
        skip_whitespace(in);
        c = in.peek();
    }

    return e;
}

PTR(Expr) parse_multicand(std::istream &in) {
    PTR(Expr) e = parse_inner(in);
    skip_whitespace(in);
    int c = in.peek();
    while (c == '(') {
        consume(in, '(');
        PTR(Expr) e2 = parse_expr(in);
        e = NEW(CallExpr)(e, e2);
        skip_whitespace(in);
        c = in.get();
        if (c != ')')
            throw std::runtime_error("missing close parenthesis");
        skip_whitespace(in);
        c = in.peek();
    }
    return e;
}

PTR(Expr) parse_inner(std::istream &in) {
    skip_whitespace(in);
    int c = in.peek();
    if ((c == '-') || isdigit(c)) {
        return parse_num(in);
    } else if (isalpha(c)) {
        return NEW(VAR)(parse_var(in));
    } else if (c == '(') {
        consume(in, '(');
        PTR(Expr) e = parse_expr(in);
        skip_whitespace(in);
        c = in.get();
        if (c != ')')
            throw std::runtime_error("missing close parenthesis");
        return e;
    } else if (c == '_') {std::string keyword = parse_keyWord(in);
        if (keyword == "let") {
            return parse_let(in);

        } else if (keyword == "true") {
            return NEW(BoolExpr)(true);
        } else if (keyword == "false") {
            return NEW(BoolExpr)(false);
        } else if (keyword == "if") {
            return parse_if(in);

        } else if (keyword == "fun") {
            return parse_fun(in);

        } else {
            throw std::runtime_error("invalid keyword: '" + keyword + "'");
        }
    } else {
        consume(in, c);
        throw std::runtime_error("invalid input");
    }
}

PTR(Expr) parse_str(std::string s) {
    std::stringstream in(s);
    return parse_expr(in);
}


