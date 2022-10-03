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

            if (rainDataList.get(i).month.equals("January")) {
                rainfalls[0] += rainDataList.get(i).rainfall;
            }
            if (rainDataList.get(i).month.equals("February")) {
                rainfalls[1] += rainDataList.get(i).rainfall;
            }
            if (rainDataList.get(i).month.equals("March")) {
                rainfalls[2] += rainDataList.get(i).rainfall;
            }
            if (rainDataList.get(i).month.equals("April")) {
                rainfalls[3] += rainDataList.get(i).rainfall;
            }
            if (rainDataList.get(i).month.equals ("May")) {
                rainfalls[4] += rainDataList.get(i).rainfall;
            }
            if (rainDataList.get(i).month.equals ("June")) {
                rainfalls[5] += rainDataList.get(i).rainfall;
            }
            if (rainDataList.get(i).month.equals("July") ){
                rainfalls[6] += rainDataList.get(i).rainfall;
            }
            if (rainDataList.get(i).month.equals("August") ){
                rainfalls[7] += rainDataList.get(i).rainfall;
            }
            if (rainDataList.get(i).month.equals("September")) {
                rainfalls[8] += rainDataList.get(i).rainfall;
            }
            if (rainDataList.get(i).month.equals("October")) {
                rainfalls[9] += rainDataList.get(i).rainfall;
            }
            if (rainDataList.get(i).month.equals("November")) {
                rainfalls[10] += rainDataList.get(i).rainfall;
            }
            if (rainDataList.get(i).month.equals("December")){
                rainfalls[11] += rainDataList.get(i).rainfall;
            }
        }
////            tempRainfalls.set(map.get(rainDataList.get(i).month), rainDataList.get(i).rainfall);
//            rainfalls[map.get(rainDataList.get(i).month)] += rainDataList.get(i).rainfall;
//        }
        for (int i = 0; i < rainfalls.length; i++) {
            pw.println("The average rainfall amount for " + months.get(i) + " is " + (rainfalls[i] / 20) + " inches.");
        }
        pw.close();
    }

}




