package lab03;

import java.util.ArrayList;

public class HowToTime {
    public static final int BILLION = 1000_000_000;
    public static final int MILLION = 1_000_000;

    public static void main(String[] args) {
        int count = 100000;
        ArrayList<Long> longs = new ArrayList<>();
        for (long i = 0; i < 160000000L; i ++) {
            longs.add(i);
        }
        long lastTime = System.nanoTime();
        int currentCount = 0;
        while (currentCount < count) {
            longs.size();
            currentCount ++;
        }
        long currentTime = System.nanoTime();
        System.out.println((currentTime - lastTime) / count);
    }



}
