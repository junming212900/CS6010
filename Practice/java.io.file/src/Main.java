import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File inputfile = new File("/Users/junmingjin/MSD/CS6011/Week 1 /Day3/Rainfall/src/Macon copy.txt" );
        Scanner scan = new Scanner(inputfile);
        String fileContent = "this is new file made by Junming ";
        while (scan.hasNextLine()) {
            fileContent = fileContent.concat(scan.nextLine()+"\n");
        }
        FileWriter writer = new FileWriter("/Users/junmingjin/MSD/CS6011/Week 1 /Day3/Rainfall/src/Newfiletxt");
        writer.write(fileContent);
        writer.close();
    }
}