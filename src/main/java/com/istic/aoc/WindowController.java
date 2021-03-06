package com.istic.aoc;

import com.istic.aoc.generator.Generator;
import com.istic.aoc.generator.GeneratorImpl;
import com.istic.aoc.observer.Observer;
import com.istic.aoc.strategy.AtomicDiffusion;
import com.istic.aoc.strategy.SequentialDiffusion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

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

    @FXML private Button btnStart;
    @FXML private Button btnStop;

    @FXML private RadioButton radioAtomic;
    @FXML private RadioButton radioSequential;

    private Generator g;
    private ScheduledExecutorService scheduledExecutorService;

    /**
     * Init generator, channels and displays
     * Attach all channels to the generator
     * Set all observers
     * Set default strategy for the diffusion algorithm
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initialize");

        g = new GeneratorImpl();

        Observer<AsyncGenerator> display1 = new Display(label1);
        Observer<AsyncGenerator> display2 = new Display(label2);
        Observer<AsyncGenerator> display3 = new Display(label3);
        Observer<AsyncGenerator> display4 = new Display(label4);

        Channel c1 = new Channel(0);
        Channel c2 = new Channel(50);
        Channel c3 = new Channel(200);
        Channel c4 = new Channel(400);

        g.attach(c1);
        c1.setObserver(display1);

        g.attach(c2);
        c2.setObserver(display2);

        g.attach(c3);
        c3.setObserver(display3);

        g.attach(c4);
        c4.setObserver(display4);

        // Default algorithm
        radioAtomic.setSelected(true);
        g.setAlgo(new AtomicDiffusion(g));
    }

    /**
     * onClick start button
     * Start generate in ScheduledThreadPoolExecutor
     * Enable stop button and disable start button
     * @param actionEvent type of event
     */
    public void onStartClickButton(ActionEvent actionEvent) {
        System.out.println("onStartClickButton");
        scheduledExecutorService = new ScheduledThreadPoolExecutor(Integer.MAX_VALUE);
        scheduledExecutorService.scheduleAtFixedRate(() -> g.generate(), 0, 1, TimeUnit.SECONDS);
        btnStart.setDisable(true);
        btnStop.setDisable(false);
    }

    /**
     * onClick stop button
     * Shutdown current ScheduledExecutorService
     * Enable start button and disable stop button
     * @param actionEvent type of event
     */
    public void onStopClickButton(ActionEvent actionEvent) {
        System.out.println("onStopClickButton");
        scheduledExecutorService.shutdown();
        btnStart.setDisable(false);
        btnStop.setDisable(true);
    }

    /**
     * onChoice atomic diffusion algorithm
     * Set diffusion algorithm
     * Check atomic radio button (auto) and uncheck sequential radio button
     * @param actionEvent type of event
     */
    public void onAtomicChoice(ActionEvent actionEvent) {
        System.out.println("onAtomicChoice");
        g.setAlgo(new AtomicDiffusion(g));
        radioSequential.setSelected(false);
    }

    /**
     * onChoice sequential diffusion algorithm
     * Set diffusion algorithm
     * Check sequential radio button (auto) and uncheck atomic radio button
     * @param actionEvent type of event
     */
    public void onSequentialChoice(ActionEvent actionEvent) {
        System.out.println("onSequentialChoice");
        g.setAlgo(new SequentialDiffusion(g));
        radioAtomic.setSelected(false);
    }

}
