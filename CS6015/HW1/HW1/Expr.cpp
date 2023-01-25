//
// Created by junming jin on 1/24/23.
//

#include "Expr.h"

Num::Num(int val) {
    this->val = val;
};
VAR::VAR(char var) {
    this->var = var;
};
Add::Add(Expr *lhs, Expr *rhs) {
    this->lhs = lhs;
    this->rhs = rhs;
};
Mult ::Mult(Expr *lhs, Expr *rhs) {
    this->lhs = lhs;
    this->rhs = rhs;
};


bool Num::equals(Expr *e) {
    Num* num1 = dynamic_cast<Num*>(e);
    if (num1 == NULL) {
        return false;
    }
    if (num1->val == this->val)
    { return true;}
    else return false;


}
bool VAR::equals(Expr *e) {
    VAR* var1 = dynamic_cast<VAR*> (e);
    // e cast to VAR
    if (var1 = NULL){
        return false;}
    else (var1->var == this->var){
        return true;}



}
bool Add::equals(Expr *e) {
    Add* add1 = dynamic_cast<Add*> (e);
    if (add1 = NULL){ return false;}
    if( add1->lhs->equals(this->lhs) && add1->rhs->equals(this->rhs)){
     return true;
    }else {
        return false;
}

}
bool Mult::equals(Expr *e) {
    Mult* mult1= dynamic_cast<Mult*> (e);
    if (mult1 = NULL) {return false;}

    if(mult1->lhs->equals(this->lhs) && mult1->rhs->equals(this->rhs)){
        return true;
    }else {
        return false;
    }

}
