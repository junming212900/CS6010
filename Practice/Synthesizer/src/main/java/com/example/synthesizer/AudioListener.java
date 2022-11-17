package com.example.synthesizer;
import  javax.sound.sampled.*;

class AudioListener implements LineListener {
    public AudioListener(Clip){ clip_= c;}
    public void update(LineEvent event){
        if (event.getType() == LineEvent.Type.STOP){
            clip_.close();
        }
    }
    private Clip clip_;
}
