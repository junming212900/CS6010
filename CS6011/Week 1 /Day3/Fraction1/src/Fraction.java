public class Fraction implements Comparable<Fraction>  {
    private long numerator;
    private long denominator;
    private long GCD() {
        long gcd = this.numerator;// this 指的是这个class 里面的变量， "gcd 对于啥面的numerator"
        long remainder = this.denominator;
        while (remainder != 0) {// 如果分母不等于0
            long temp = remainder; // 让temp 等于余数
            remainder = gcd % remainder; // 余数= 最大公约数除以余数
            gcd = temp;// 最大公约数= temp
        }
        return gcd;
    }
    private void reduce() {// 约分
        this.numerator /= this.GCD();// 分子除以最大公约数
        this.denominator /= this.GCD();//分母除以最大公约数
    }
    public Fraction() {// fraction start with 0/1
        this.numerator = 0;
        this.denominator = 1;
    }
    public Fraction(long n, long d) {
        if (d < 0 && n > 0) {
            d = d * (-1);
            n = n * (-1);
        }
        if (d == 0) {
            throw new IllegalArgumentException("the denominator must not be zero!");
        }
        this.numerator = n;
        this.denominator = d;
    }

    public Fraction plus(Fraction rhs) {// 定义了一个fraction 相加的faction。 faction 的名字是plus ，用法是 外面的fraction 1 加 里面的 fraction 2
        long newDenominator = this.denominator * rhs.denominator;
        long newNumerator = this.numerator * rhs.denominator + rhs.numerator * this.denominator;
        Fraction unReduced = new Fraction(newNumerator, newDenominator);
        unReduced.reduce();
        return unReduced;
    }
    public Fraction minus(Fraction rhs) {
        long newDenominator = this.denominator * rhs.denominator;
        long newNumerator = this.numerator * rhs.denominator - rhs.numerator * this.denominator;
        Fraction unReduced = new Fraction(newNumerator, newDenominator);
        unReduced.reduce();
        return unReduced;
    }
    public Fraction times(Fraction rhs) {
        Fraction unReduced = new Fraction(this.numerator * rhs.numerator, this.denominator * rhs.denominator);
        unReduced.reduce();
        return unReduced;
    }
    public Fraction reciprocal() {
        return new Fraction(this.denominator, this.numerator);
    }//分数倒数， 输出new 的fraction 将这个大class的 this 分子，分母调换位置
    public Fraction dividedBy(Fraction rhs) {
        return this.times(rhs.reciprocal());
    }// f1 dividedby frhs = f1 乘以 frhs 的倒数。
    public String to_String() {
        reduce();// 首先约分
        if (denominator < 0 && numerator > 0) { // 如果分母小于0，分子大于0，同事乘以-1 ，并等于这个值
            denominator *= -1;
            numerator *= -1;
        }
        String new_denominator = Long.toString(denominator);// 新的分子分母转变为string
        String new_numerator = Long.toString(numerator);
        return numerator + "/" + denominator;
    }
    public double toDouble() {
        return (double) this.numerator / this.denominator;
    }

    public int compareTo(Fraction rhs){
        return Double.compare(this.toDouble(), rhs.toDouble());
    }
}

