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

    /**
     * Waits for the main thread to be available to retrieve the data
     * @param asyncGenerator to perform the getValue and retrieve the value (a Future)
     */
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
