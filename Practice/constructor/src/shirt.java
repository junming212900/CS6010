import java.sql.Statement;

public class shirt {
    public static String  color;
    public static  char size;
    public static void puton(){
        System.out.println("Shirt is on");
    }
    public static void takeoff(){
        System.out.println("Shirt is off");

    }
    public static void SetColor(String Newcolor){
        color = Newcolor;

    }
    public static void SetSize(char NewSize){
        size = NewSize;
    }
}
