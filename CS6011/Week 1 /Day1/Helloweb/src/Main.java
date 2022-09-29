import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] ints = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int anint : ints) {
            System.out.println(anint);
        }
        int sum = 0;
        for (int anint : ints) {
            sum += anint;
        }
        System.out.println(sum);

        Scanner s = new Scanner(System.in);
        System.out.println("Enter your Age :");
        int age = s.nextInt();

        if (age > 18) {
            System.out.println("You can vote !");
        }
        if (age > 30) {
            System.out.println("You can run Senate!");
        }

        if (age > 80) {
            System.out.println(" You are a greatest generation");
        } else if (age > 60) {
            System.out.println("You are a baby boomer");

        } else if (age > 40) {
            System.out.println("You are a generation X");

        } else if (age > 20) {
            System.out.println("You are a millennial X");
        } else if (age < 20) {
            System.out.println("You are a iKid");
        }
    }
}