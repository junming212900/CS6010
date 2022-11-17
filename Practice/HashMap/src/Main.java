import java.util.HashMap;

public class Main {
    public static void main(String[] args) {// Hasmay does not really have a order.
        HashMap<String,Integer> hard = new HashMap<String,Integer>();
        hard.put("a", 99);
        hard.put("b",88);
        hard.put("c",77);

        System.out.println(hard.get("c"));

        HashMap<String,String> fun = new HashMap<String,String>();
        fun.put("howard","dsada");
        fun.put("janny","dada");
        fun.put("john","adaad");
        System.out.println(fun);
        System.out.println(fun.containsValue("addad"));


        System.out.println("Hello world!");
    }
}