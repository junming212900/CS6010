public  class Fraction{
        long numerator;
        long denominator;

        public Fraction(long num, long denom) {
            long numerator = num;
            long denominator = denom;
        }
        public Fraction(){
            numerator = 0;
            denominator =1;
        }
        public Fraction( long number ){
        numerator = number;
        denominator =1;
        }


        Fraction(){
        public long getNumerator() {
            return numerator;
        }
        public long getDenominator() {
            return denominator;
        }

        public void setNumerator(long numerator) {
        this.numerator = numerator;
         }

        public void setDenominator(long denominator) {
        this.denominator = denominator;
        }

            public int calculateGCD(int numerator, int denominator) {
                if (numerator % denominator == 0) {
                    return denominator;
                }
                return calculateGCD(denominator, numerator % denominator);
            }

            void reduce() {
                int gcd = calculateGCD(numerator, denominator);
                numerator /= gcd;
                denominator /= gcd;
            }


        public Fraction plus(Fraction rhs){
            long num = numerator* rhs.getDenominator() + denominator*rhs.getNumerator();
            long denom = denominator* rhs.getDenominator();
            return new Fraction( num,denom);
        }
        public Fraction minus(Fraction rhs){
            long num = numerator* rhs.getDenominator() - denominator*rhs.getNumerator();
            long denom = denominator* rhs.getDenominator();
            return new Fraction( num,denom);
        }
        public Fraction times( Fraction rhs){
            long num = numerator* rhs.getNumerator() ;
            long denom = denominator* rhs.getDenominator();
            return new Fraction( num,denom);
        }
        public Fraction divideby(Fraction rhs) {
        int num = numerator * rhs.denominator;
        int denom = denominator * rhs.numerator;
        return new Fraction( num,denom);
        }
        public String toString() {
                return this.numerator + "/" + this.denominator;
        }

}

    public static void main(String[] args) {
        Fraction f1 = new Fraction(25, 35);
        System.out.println(f1.toString());
        Fraction f2 = new Fraction(2, 7);
        Fraction f3 = f1.plus(f2);
        System.out.println("Result of addition of "
                + f1 + " and " + f2 + " is : " + f3);
        f3 = f1.minus(f2);
        System.out.println("Result of subtraction of "
                + f1 + " and " + f2 + " is : " + f3);
        f3 = f1.divideby(f2);
        System.out.println("Result of division of "
                + f1 + " and " + f2 + " is : " + f3);
        f3 = f1.times(f2);
        System.out.println("Result of multiplication of "
                + f1 + " and " + f2 + " is : " + f3);
    }
