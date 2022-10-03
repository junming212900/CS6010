import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;


class FractionTest {

    @Test
    void plus() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        Fraction f3 = f1.plus(f2);

        Fraction f4 = new Fraction(1, -2);
        Fraction f5 = new Fraction(1, 3);
        Fraction f6 = f4.plus(f5);

        Assertions.assertEquals(f3.to_String(), "5/6");// 经过test 如果faction 的没有问题。预估的答案应该是5/6 , f3 这里已经是string 化了的。assertions.assertEquals(跟其他的faction， 预估的结果）

    }

    @Test
    void minus() {
        Fraction f7 = new Fraction(1, 2);// 通过fraction 得出 1/2
        Fraction f8 = new Fraction(1, 3);
        Fraction f9 = f7.minus(f8);

        Fraction f10 = new Fraction(1, -2);
        Fraction f11 = new Fraction(1, 3);
        Fraction f12 = f10.minus(f11);

        Assertions.assertEquals(f9.to_String(), "1/6");
    }

    @Test
    void times() {
        Fraction f13 = new Fraction(1, 2);
        Fraction f14 = new Fraction(1, 3);
        Fraction f15 = f13.times(f14);

        Fraction f16 = new Fraction(-1, -2);
        Fraction f17 = new Fraction(1, 3);
        Fraction f18 = f16.times(f17);

        Fraction f19 = new Fraction(-1, -2);
        Fraction f20 = new Fraction(-1, 3);
        Fraction f21 = f19.times(f20);

        Assertions.assertEquals(f15.to_String(), "1/6");
//        Assertions.assertEquals(f18.to_String(), "1/6");

    }

    @Test
    void dividedBy() {
        Fraction f22 = new Fraction(1, 2);
        Fraction f23 = new Fraction(1, 3);
        Fraction f24 = f22.dividedBy(f23);

        Fraction f25 = new Fraction(1, -2);
        Fraction f26 = new Fraction(1, 3);
        Fraction f27 = f25.dividedBy(f26);

        Assertions.assertEquals(f24.to_String(), "3/2");
//        Assertions.assertEquals(f27.to_String(), "-3/2");
    }

    @Test
    void reciprocal() {
        Fraction f28 = new Fraction(3, 4);
        Fraction f29 = f28.reciprocal();
        Assertions.assertEquals(f29.to_String(), "4/3");

        Fraction f30 = new Fraction(-3, 5);
        Fraction f31 = f30.reciprocal();
        Assertions.assertEquals(f31.to_String(), "-5/3");
    }
    @Test
    public void testDenominatorIsZero() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    Fraction test = new Fraction(1,0);
                }
        );
        assertEquals("the denominator must not be zero!", exception.getMessage());
    }
    @Test
    public void testSort() {
        Fraction f34 = new Fraction(1, 4);
        Fraction f35 = new Fraction(1, 3);
        Fraction f36 = new Fraction(1, 2);
        ArrayList<Fraction> fractions = new ArrayList<>();
        fractions.add(f35);
        fractions.add(f36);
        fractions.add(f34);
        Collections.sort(fractions);
        Assertions.assertEquals(fractions.get(0).to_String(), "1/4");
    }
}

