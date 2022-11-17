public class Main {

    public static void main(String[] args) {
        countBackwards(13);
    }

    public static void countBackwards(int n) {
        if (n == 0) {
            System.out.println("done");
        } else {
            System.out.println(n);
            n--;
            countBackwards( n );// for recursive we need add the meth inside itself to get it repeat.
        }
    }
}