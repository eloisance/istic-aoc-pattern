package com.istic.aoc;

import com.istic.aoc.observer.Observer;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.concurrent.ExecutionException;

public class Display implements Observer<AsyncGenerator> {

    private Label label;

    public Display(Label l) {
         this.label = l;
    }

    public void update(AsyncGenerator asyncGenerator) {
        Platform.runLater(() -> {
            try {
                label.setText(asyncGenerator.getValue().get().toString());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

}
