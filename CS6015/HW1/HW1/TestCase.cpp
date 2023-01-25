//
// Created by junming jin on 1/24/23.
//
#include "Expr.h"
#include "catch.h"

TEST_CASE("equals"){


CHECK( (new Num(1))->equals(NULL)== false );
CHECK( (new Num(1))->equals(new Num(1)) == true );
CHECK( (new VAR('x'))->equals(new VAR('y')) == false );
CHECK( (new Add(new Num(2),new Num(3)))->equals(new Add(new Num(2),new Num(3)))==true );
CHECK( (new Add(new Num(2),new Num(3)))->equals(new Add(new Num(3),new Num(2)))==false );
CHECK( (new Mult(new Num(2),new Num(2)))->equals(new Add(new Num(1),new Num(2)))==false );

CHECK( (new Num(8))->equals(new Num(6)) == false );
CHECK( (new VAR('z'))->equals(new VAR('z')) == false );
CHECK( (new Add(new Num(5),new Num(6)))->equals(new Add(new Num(6),new Num(5)))==false );
CHECK( (new Add(new Num(8),new Num(6)))->equals(new Add(new Num(8),new Num(6)))==true );
CHECK( (new Mult(new Num(2),new Num(2)))->equals(new Add(new Num(1),new Num(2)))==false );
CHECK( (new Mult(new Num(5),new Num(5)))->equals(new Add(new Num(5),new Num(5)))==true );
CHECK( (new Mult(new Num(6),new Num(8)))->equals(new Add(new Num(8),new Num(8)))==false );
}