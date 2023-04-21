//
// Created by junming jin on 1/24/23.
//
#include "Expr.h"
#include "catch.h"

TEST_CASE("numequals"){
CHECK( (new Num(1))->equals(NULL)== false );
CHECK( (new Num(1))->equals(new Num(1)) == true );
CHECK( (new Num(8))->equals(new Num(6)) == false );
CHECK( (new Num(9))->equals(new VAR("z")) == false );
}
TEST_CASE("var equals"){

    CHECK( (new VAR("z"))->equals(NULL)== false );
CHECK( (new VAR("x"))->equals(new VAR("y")) == false );
CHECK( (new VAR("z"))->equals(new VAR("z")) == true );
CHECK( (new VAR("f"))->equals(new VAR("z")) == false );
CHECK( (new VAR("a"))->equals(new Num(6)) == false );

}
TEST_CASE("add equals"){

    CHECK( (new Add(new Num(2),new Num(3)))->equals(NULL)==false );
CHECK( (new Add(new Num(2),new Num(3)))->equals(new Add(new Num(2),new Num(3)))==true );
CHECK( (new Add(new Num(2),new Num(3)))->equals(new Add(new Num(3),new Num(2)))==false );
CHECK( (new Add(new Num(5),new Num(6)))->equals(new Add(new Num(6),new Num(5)))==false );
CHECK( (new Add(new Num(8),new Num(6)))->equals(new Add(new Num(8),new Num(6)))==true );
CHECK( (new Add(new Num(5),new Num(6)))->equals(new Mult(new Num(5),new Num(6)))==false );
CHECK( (new Add(new Num(7),new Num(6)))->equals(new Add(new Num(7),new Num(6)))==true );
}

TEST_CASE("mult equals"){
    CHECK( (new Mult(new Num(2),new Num(3)))->equals(NULL)==false );
    CHECK( (new Mult(new Num(2),new Num(2)))->equals(new Add(new Num(1),new Num(2)))==false );
CHECK( (new Mult(new Num(5),new Num(5)))->equals(new Mult(new Num(5),new Num(5)))== true );
CHECK( (new Mult(new Num(6),new Num(8)))->equals(new Add(new Num(8),new Num(8)))==false );
CHECK( (new Mult(new Num(2),new Num(2)))->equals(new Add(new Num(1),new Num(2)))==false );
}


TEST_CASE("Interpret"){
    CHECK((new Num(3))->interp()==3);
    CHECK_THROWS_WITH( (new VAR("x"))->interp(), "no value for variable" );
    CHECK( (new Mult(new Num(3), new Num(2)))->interp()==6 );
    CHECK( (new Mult(new Num(3), new Num(5)))->interp()==15 );
    CHECK( (new Add(new Add(new Num(10), new Num(15)),new Add(new Num(20),new Num(20))))->interp()==65);
    CHECK( (new Add(new Add(new Num(10), new Num(20)),new Add(new Num(30),new Num(40))))->interp()==100);

}
TEST_CASE("behas_variable"){
    CHECK((new Num(3))->has_variable()==false);
    CHECK((new VAR("x"))->has_variable()== true);
    CHECK( (new Mult(new Num(3), new Num(2)))->has_variable()== false );
    CHECK( (new Add(new Num(3), new Num(2)))->has_variable()== false );
    CHECK( (new Mult(new VAR("x"), new Num(2)))->has_variable()== true );
    CHECK( (new Add(new Num(3), new VAR("x")))->has_variable()== true );
    CHECK( (new Mult(new VAR("x"), new VAR("z")))->has_variable()== true);
    CHECK( (new Add(new VAR("x"), new VAR("z")))->has_variable()== true);
}
TEST_CASE("substution"){
    CHECK( (new Add(new Num(5), new Num(7)))->subst("x", new VAR("y"))->equals(new Add(new VAR("y"), new Num(7)))== false );
    CHECK( (new Add(new VAR("x"), new Num(7)))->subst("z", new VAR("y"))->equals(new Add(new VAR("y"), new Num(7)))== false );
    CHECK( (new VAR("x"))->subst("x", new Add(new VAR("y"),new Num(7)))->equals(new Add(new VAR("y"),new Num(7)))==true );
    CHECK( (new Add(new VAR("x"), new Num(7)))->subst("x", new VAR("y"))->equals(new Add(new VAR("y"), new Num(7)))== true );
}
