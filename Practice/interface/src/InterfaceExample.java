interface Waterbottleinterface{
    String color = "Blue";
    void fillup();
    void pourout();
}
public class InterfaceExample implements Waterbottleinterface {
    public static void main(String[] args) {

        System.out.println(color);
        InterfaceExample ex =new InterfaceExample();
        ex.fillup();
    }

    @Override
    public void fillup() {
        System.out.println("It is filled");

    }

    @Override
    public void pourout() {

    }
}