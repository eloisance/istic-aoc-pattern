package com.istic.aoc;

import com.istic.aoc.generator.Generator;
import com.istic.aoc.generator.GeneratorImpl;
import com.istic.aoc.observer.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WindowController implements Initializable {

    @FXML private Label label1;
    @FXML private Label label2;
    @FXML private Label label3;
    @FXML private Label label4;

    private Generator g;
    private ScheduledExecutorService scheduledExecutorService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initialize");

        g = new GeneratorImpl();

        Observer<AsyncGenerator> display1 = new Display();
        Observer<AsyncGenerator> display2 = new Display();
        Observer<AsyncGenerator> display3 = new Display();
        Observer<AsyncGenerator> display4 = new Display();

        Channel c1 = new Channel();
        Channel c2 = new Channel();
        Channel c3 = new Channel();
        Channel c4 = new Channel();

        g.attach(c1);
        c1.setObserver(display1);

        g.attach(c2);
        c2.setObserver(display2);

        g.attach(c3);
        c3.setObserver(display3);

        g.attach(c4);
        c4.setObserver(display4);
    }

    public void onStartClickButton(ActionEvent actionEvent) {
        System.out.println("onStartClickButton");
        g.generate();
        scheduledExecutorService = new ScheduledThreadPoolExecutor(Integer.MAX_VALUE);
        scheduledExecutorService.scheduleAtFixedRate(() -> g.generate(), 0, 3, TimeUnit.SECONDS);
    }

    public void onStopClickButton(ActionEvent actionEvent) {
        System.out.println("onStopClickButton");
        scheduledExecutorService.shutdown();
    }

    public void onAtomicChoice(ActionEvent actionEvent) {
        System.out.println("onAtomicChoice");
    }

    public void onSequentialChoice(ActionEvent actionEvent) {
        System.out.println("onSequentialChoice");
    }

}
