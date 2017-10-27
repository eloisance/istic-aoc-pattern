package com.istic.aoc.observer;

import com.istic.aoc.Channel;

import java.util.concurrent.ExecutionException;

public class Display implements ObservatorGenerator {

    public void update(Channel c) {
        try {
            System.out.println("value: " + c.getValue().get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
