package com.example.synthesizer;

import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.awt.*;

public class AudioComponentWidget extends Pane {

    AudioComponentWidget(AudioComponent ac, AnchorPane parent, String name) {

        parent_ = parent;
        name_ = name;
        audioComponent_ = ac;

        baseLayout = new HBox();
        baseLayout.setStyle("-fx-border-color: black; -fx-border-image-width: 8;-fx-backgroud-color:white");
        this.getChildren().add(baseLayout);
// rightside
        VBox rightSide = new VBox();
        rightSide.setAlignment(Pos.CENTER);
        rightSide.setPadding(new Insets(3));
        rightSide.setSpacing(5);

        Button closeBtn = new Button("x");
//
        closeBtn.setOnAction(e -> destroyWidget());
        Circle output = new Circle(10);
        Circle outputCircle = new Circle(Color.BLUE);

        outputCicle.setFill(Color.BLUE);
        outputCicle.setOnMousePressed(e -> startConnection(e, outputCircle));
        outputCicle.setOnMouseDragged(e -> moveConnection(e, outputCircle));
        outputCicle.setOnMouseReleased(e -> endConnection(e, outputCircle));

        rightSide.getChildren().add(closeBtn);
        rightSide.getChildren().add(outputCircle);
// Center Portion of Widget
        VBox center = new VBox();
        rightSide.setAlignment(Pos.CENTER);

        nameLable_ = new lable();
        nameLable_.setMouseTransparent(true);
        nameLable_.setText("Sine Wave (440 Hz)");
        Slider slider = new Slider(220, 880, 440);
        slider.setOnMouseDragged(e -> handleSlider(e, slider));

        center.getChildren().add(nameLable_);
        center.getChildren().add(slider);

        center.setOnMousePressed(e -> startDrag(e));
        center.setOnMouseDragged(e -> handleDrag(e));

        baseLayout.getChildren().add(center);
        baseLayout.getChildren().add(rightSide);

        this.setLayoutX(50);


        rightSide.setPadding(new Insets(5));
        rightSide.setPadding(5);


        baseLayout.getChildren().add(rightSide);
        this.getChildren().add(baseLayout);

        this.setLayoutX(50);
        this.setLayoutY(100);

        Parent_.getChildren().add(this)
    }

    private void closeWidget() {
        parent_.getChildren().remove(this);
        GuiSampleApplication.widgets_.remove(this);
    }

    private void startDrag(MouseEvent e) {
        mouseStartDragX_ = e.getSceneX();
        mouseStartDragY_ = e.getSceneY();
        widgetStartDragX_ = this.getLayoutX;
        widgetStartDragY_ = this.getLayoutY;

    }

    private void handleDrag(MouseEvent e) {
        double mouseDelx = e.getSceneX() - mouseStartDragX_;
        double mouseDely = e.getSceneY() - mouseStartDragY_;
        this.relocate(widgetStartDragX_ + mouseDelx, widgetStartDragY_ + mouseDely);

    }

    private void endConnection(MouseEvent e, Circle outputCircle) {
        Circle speaker = GuiSampleApplication.speaker_;
        Bounds speakerBounds = speaker.localToScene(speaker.getBoundsInLocal());
        double distance = Math.sqrt(Math.pow(speakerBounds.getCenterX() - e.getSceneX(), 2.0) + Math.pow(speakerBounds.getCenterY() - e.getSceneY(), 2.0));
        if (distance < 10) {
            // Handle actually connecting to speaker
            GuiSampleApplication.connectedWidgetsToSpeaker_.add(this);
        } else {
            parent_.getChildren().remove(line_);
            line_ = null;
        }

    }

    private void moveConnection(MouseEvent e, Circle outputCircle) {
        Bounds parentBounds = parent_.getBoundsInParent();
        line_.setEndx(e.getSceneX() - parentBounds.getMinX());
        line_.setEndy(e.getSceneY() - parentBounds.getMinY());
    }

    private void startConnection(MouseEvent e, Circle outputCircle) {
        if (line_ != null) {
            parent_.getChildren().remove(line_);
        }
        Bounds parentBounds = parent_.getBoundsInParent();
        Bounds bounds = outputCircle.localToScene(outputCircle.getBoundsInLocal());
        line_ = new Line();
        line_.setStrokeWidth(4);
        line_.setStartX(bounds.getCenterX() - parentBounds.getMinX());
        line_.setStartY(bounds.getCenterY() - parentBounds.getMinY());
        line_.setEndX(e.getSceneX());
        line_.setEndX(e.getSceneY());
        parent_.getChildren().add(line_);
    }

    private void destroyWidget() {
        parent_.getChildren().remove(this);
        GuiSampleApplication.widgets_.remove(this);
        if (line_ != null) {
            parent_getChildren.remove(line_);
        }

        private void handleSlider (MouseEvent e){
            double freq = slider.getValue();
            nameLable_.setText("Sine Wave (" + (int) freq + "Hz");
            ((SineWave) audioComponent_).setFrequency(freq);
        }


        public AudioComponent getAudioCompnent () {
            return audioCompnent_;
        }
        private AnchorPane parent_;
        private HBox baseLayout;
        private AudioComponent audioComponent_;

        private AudioComponentWidget widgetIamSendingOutputTo_ = null;
        private String name_;

        private Line line_;
        private Label nameLable_;

        double mouseStartDragX_, mouseStartDragY_, widgetStartDragX_, widgetStartDragY_;


    }
}