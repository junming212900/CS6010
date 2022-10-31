package com.example.synthesizer;

public interface AudioComponent {
    AudioClip getClip(); // return the current sound produced by this component

    boolean hasInput(); // if you can connect something to this as an input
    default int availableInputPort(){ return 0;}// Max number of (possible) input.
    default void connectInput(AudioComponent input){assert (false);} // connect another device to this input

    default void removeInput(AudioComponent input) {
        assert false;
    };
}