import java.util.Scanner;
import java.io.*;
import java.text.DateFormatSymbols;

public class RainFall {

    static String inttoMonth(int month){
        String monthName=new DateFormatSymbols()
                .getMonths()[month - 1];
        return monthName;
    }

    public static void main(String[] args)
            throws IOException, FileNotFoundException {

        System.out.println("Enter the file name to read rainfall data");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.next();
        // System.out.println(fileName);
        sc.close();

        double[] rainData = new double[12];
        double[] tempData = new double[12];

        File file = new File(fileName);
        BufferedReader br = new BufferedReader(
                new FileReader(file));

        String st;
        double d;
        int i = 0;
        while ((st = br.readLine()) != null) {

            d = Double.parseDouble(st);
            // System.out.println(d);
            rainData[i] = d;
            tempData[i] = d;
            i++;
        }

        br.close();

        double totalRainfall = 0;
        for (i = 0; i < rainData.length; i++) {
            // System.out.println(rainData[i]);
            totalRainfall += rainData[i];
        }
        System.out.printf("\nTotal rainfall (year) : %.2f",
                totalRainfall);
        System.out.printf("\nAverage Monthly rainfall: %.2f",
                totalRainfall / 12);
        System.out.println("\n");
        // System.out.println("File read successfully");

        double temp;
        double minRainFall = 0;
        double maxRainFall = 0;

        for (i = 0; i < tempData.length; i++) {
            temp = 0;
            for (int j = 1 + i; j < tempData.length; j++) { if (tempData[i] > tempData[j]) {
                temp = tempData[i];
                tempData[i] = tempData[j];
                tempData[j] = temp;

            }

            }
            minRainFall = tempData[0];
            maxRainFall = tempData[tempData.length - 1];
        }

        int minRainMonth = 0;
        int maxRainMonth = 0;
        for (i = 0; i < rainData.length; i++) {
            if (rainData[i] == minRainFall) {
                minRainMonth = i + 1;
            }
            if (rainData[i] == maxRainFall) {
                maxRainMonth = i + 1;
            }
            // System.out.println(tempData[i]);
        }

        System.out.println(minRainFall +
                " is the min Rainfall in month of "
                + inttoMonth(minRainMonth));
        System.out.println(maxRainFall +
                " is the max Rainfall and in month of "
                + inttoMonth(maxRainMonth));

    }

}