package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        AnchorPane root = new AnchorPane();// 设置一个基础的窗口（锚点窗口）
        Scene scene = new Scene(root,400,300);//scene（场景）最开始的窗口大小
        VBox componentWidget = new VBox();//这是一个 基础窗口里的那个窗口或者是item。set up as a top layout(布局) 一个parient component
        componentWidget.setStyle("-fx-background-color: lightblue");// 这个窗口的底色和style 是蓝色的

        Label title = new Label();// give 这个窗口增加title
        title.setText("sine Wave(440 Hz)");// name the tile

        Slider slider = new Slider(220,1180,840);//定义一个silde（滑杆）并定义了他的value范围
        slider.setOnMouseDragged(e-> handleSlider(e,slider,title));//鼠标可以在这个窗口上任意拖动
        componentWidget.getChildren().add(title); // 窗口上增加了这个title
        componentWidget.getChildren().add(slider);// 窗口上增加了这slide
        componentWidget.relocate(50,100);// 窗口被relocate 到其他位置
        componentWidget.setOnMousePressed(e->handleMousePress(e));// 使这个滑杆可以按下

        root.getChildren().add( componentWidget);//窗口增加到了基础窗口里

// 下面两行基本是defat code
        stage.setScene(scene);// 让stage 包含这个最开始 窗口
        stage.show();// 让stage展现出来
    }

    private void handleSlider(MouseEvent e, Slider slider, Label title) {// 中间包含的变量 必须包括进去，mouse ，slider，title
    int value = (int)slider.getValue();// get the value from slider .
    title.setText("Sine Wave("+ value +"Hz)");
    }// 小的窗口的title 变化 在这个function里设定一个value 这个value 的变化来自鼠标推动的值（鼠标拖动值就是*MouseEven e*）

    private void handleMousePress(MouseEvent e) {
        System.out.println("mouse press");
    }//按下以后会出现上面的text

    public static void main(String[] args) {
        launch();
    }
}