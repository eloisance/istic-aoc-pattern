package com.istic.aoc;

import com.istic.aoc.generator.GeneratorImpl;
import com.istic.aoc.generator.Generator;
import com.istic.aoc.observer.Observer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application
{
    public static void main(String[] args)
    {
        Generator g = new GeneratorImpl();

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

        g.generate();

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("window.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("ActiveObject");
        stage.setScene(scene);
        stage.show();
    }
}
