package com.istic.aoc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WindowController {

    @FXML private Label c1;
    @FXML private Label c2;
    @FXML private Label c3;
    @FXML private Label c4;

    public void onStartClickButton(ActionEvent actionEvent) {
        System.out.println("onStartClickButton");
    }

    public void onStopClickButton(ActionEvent actionEvent) {
        System.out.println("onStopClickButton");
    }

    public void onAtomicChoice(ActionEvent actionEvent) {
        System.out.println("onAtomicChoice");
    }

    public void onSequentialChoice(ActionEvent actionEvent) {
        System.out.println("onSequentialChoice");
    }

}
