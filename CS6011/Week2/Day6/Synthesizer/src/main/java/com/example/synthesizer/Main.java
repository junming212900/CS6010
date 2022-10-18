package com.example.synthesizer;
import javax.sound.sampled.*;

public class Main { // this class is used to test SineWave
    public static void main(String[] args) throws LineUnavailableException {
        // Get properties from the system about samples rates, etc.
        // AudioSystem is a class from the Java standard library.
        Clip c = AudioSystem.getClip(); // Note, this is different from our AudioClip class.

        // This is the format that we're following, 44.1 KHz mono audio, 16 bits per sample.
        AudioFormat format16 = new AudioFormat(44100, 16, 1, true, false);

        AudioComponent gen = new SineWave(440); // Your code
//        AudioComponent gen = new LinearRamp(50, 2000);
        AudioClip clip = gen.getClip();         // Your code

        byte[] data = clip.getData();
        c.open(format16, data, 0, data.length); // Reads data from our byte array to play it.

        System.out.println("About to play...");
        c.start(); // Plays it.
//        c.loop(2); // Plays it 2 more times if desired, so 6 seconds total

        // Makes sure the program doesn't quit before the sound plays.
        while (c.getFramePosition() < AudioClip.totalSample || c.isActive() || c.isRunning()) {
            // Do nothing while we wait for the note to play.
        }

        System.out.println("Done.");
        c.close();
    }
}