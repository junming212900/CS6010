public class Main {
    public static void main(String[] args) {

        shirt s = new shirt();
        s.puton();
        s.SetColor("White");
        s.SetSize('M');
        System.out.println(s.color);
        System.out.println(s.size);
    }
}