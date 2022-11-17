import java.util.ArrayList;

public class Nestedforloop {
    public static void main(String[] args) {

        String Name = "";
        Integer Age = 0;
        String[][] colors = {{"red", "blue", "yellow"}, {"pink", "orenge", "purple"}};

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(colors[i][j]);

            }


        }

    }
}