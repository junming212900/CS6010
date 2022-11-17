public class returnstatment {

    public static void main(String[] args) {// void 适用于任何类型
        int sum = add(1, 2);
        System.out.println(sum);
        String shouting = caps(" why ");
        System.out.println(shouting);
    }

    public static int add(int a, int b) {
        int c = a + b;
        return c;
    }

    public static String caps(String s) {
        return s.toUpperCase();
    }
}