public class Pen {
    String type = " gel";
    String color = "blue";
    double piont  = 1.0;
    static boolean clicked = false;
    public static void click(){
        clicked =true;
    }
    public  static void unclick(){
        clicked = false;
    }
}
