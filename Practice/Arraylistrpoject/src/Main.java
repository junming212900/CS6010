import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] fruit = new String[4];
        fruit[1] = "apple";
        fruit[2] = "banana";
        fruit[3] = "watermelon";
        fruit[0] = "peach";

        System.out.println(fruit[3]);

        ArrayList Fruitlist = new ArrayList();
        Fruitlist.add("Apple");
        Fruitlist.add("Mango");
        Fruitlist.add("Banana");
        Fruitlist.add("Peach");
        Fruitlist.remove("Peach");
        System.out.println(Fruitlist.contains("Apple"));
        System.out.println(Fruitlist);
    }
}