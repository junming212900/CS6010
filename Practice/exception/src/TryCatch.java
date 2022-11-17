import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your favor number");
            try {
                int a = scan.nextInt();
                System.out.println(a);
            } catch (Exception e) { // 报错弹出，也可以有躯体的报错type
                System.out.println("Hello world!");
            }
        }
    }
}