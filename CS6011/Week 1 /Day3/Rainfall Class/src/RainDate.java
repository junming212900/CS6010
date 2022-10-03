import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.*;


public class RainDate {

    public static void main(String[] args) throws IOException {

        ArrayList<String> months = new ArrayList<>();
        ArrayList<Float> tempRainfalls = new ArrayList<>(12);
        float[] rainfalls = new float[12];
        ArrayList<RainData> rainDataList = new ArrayList<>();
        File filename = new File("/Users/junmingjin/MSD/CS6011/Week 1 /Day3/Rainfall Class/src/Atlanta.txt");
        Scanner scan = new Scanner(filename);
        scan.nextLine();
        for (int i = 0; i < 240; i++) {
            String month = scan.next();
            int year = scan.nextInt();
            float rainfall = scan.nextFloat();
            if (!months.contains(month)) {
                months.add(month);
            }
            RainData rainData = new RainData(month, year, rainfall);
            rainDataList.add(rainData);
        }
        scan.close();

//
        float totalRainfall = 0;
        for (RainData rainData : rainDataList) {
            totalRainfall += rainData.rainfall;
        }
        float averageRainfall = (float) totalRainfall / 240;
        System.out.println("The overall average rainfall amount is " + averageRainfall + " inches.");

        PrintWriter pw = new PrintWriter
                ("/Users/junmingjin/MSD/CS6011/Week 1 /Day3/Rainfall Class/src/rainfall_results.txt");
        for (int i = 0; i < rainDataList.size(); i++) {
//            tempRainfalls.set(map.get(rainDataList.get(i).month), rainDataList.get(i).rainfall);
            rainfalls[map.get(rainDataList.get(i).month)] += rainDataList.get(i).rainfall;
        }
        for (int i = 0; i < rainfalls.length; i++) {
            pw.println("The average rainfall amount for " + months.get(i) + " is " + (rainfalls[i] / 20) + " inches.");
        }
        pw.close();
    }

}




