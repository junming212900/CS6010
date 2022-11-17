package com.example.synthesizer;

import javafx.application.Application;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.util.ArrayList;

public class GuiSampleApplication extends Application {

    public void start(Stage stage) throws IOException {
    BorderPane root = new BorderPane();
    Scene scene = new Scene(root,600,400);
    stage.setTitle("My Synth");
    VBox rightPanel = new VBox();
    rightPanel.setPadding(new Insets(4));
    rightPanel.setStyle("-fx-background-color: lightblue ");

    Button sineWaveBtn = new Button( " Sine Wave");
    rightPanel.getChildren().add(sineWaveBtn);
    sineWaveBtn.setOnAction(e -> createComponet("SineWave"));
    Circle speakerCicle = new Circle(400, 200 ,15 );
    speakerCicle.setFill(Color.black );
    mainCanves_.getChildren().add( speakerCicle);

    //Bottom Panel stuff
        Hbox bottomPanel = new HBox();
        Button playBtn = new Button( "play");
        playBtn.setOnAction(e->playNetwork());
        bottomPanel.getChildren().add(playBtn);



    // center Panel Stuff
      mainCanvas_ = new AnchorPane();
      mainCanvas_.setStyle("-fx-background-color: darkblue");

    root.setRight(rightPanel);
    root.setCenter(manCanvas_);
    root.setBottom( bottomPanel);
    stage.setScene(scene);
    stage.show();
    }

    private void playNetwork() {

        if (widgets_.size() == 0) {

            try {

                AudioListener listener = new AudioListener();

                Clip c = AudioSystem.getClip();

                AudioFormat format = new AudioFormat(44100, 16, 1, true, false);
                AudioComponentWidget acw = widget_.get(0);
                AudioComponent ac = acw.getAudioCompnent();
                byte[] data = ac.getClip().getData();
                c.open(format, data, 0, data.length);
                c.start();
                c.addLineListener(Listener);
                while (!done with c){
                }
        catch(lineUnavailableException e )
            }

            private void createComponet (String sineWave){
                System.out.println("in create Component");
                AudioComponent sinewave = new SineWave(440);
                AudioComponentWidget acw = new AudioComponentWidget(sinewave, mainCanvas_, "Sine Wave");
                widgets_add(acw);
            }

            public static void main (String[]args){
                launch(args);
            }

            @Override
            public void start (Stage primaryStage){
                private AnchorPane mainCanvas_;
                public static Circle speaker_;
                public static ArrayList<AudioComponent> allwidgets_ = new ArrayList<>();
                public static ArrayList<AudioComponent> widgetsConnectedTOSpeaker_ = new ArrayList<>();


            }
        }
    }
}