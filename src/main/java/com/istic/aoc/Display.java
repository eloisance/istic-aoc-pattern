package com.istic.aoc;

import com.istic.aoc.observer.Observer;

import java.util.concurrent.ExecutionException;

public class Display implements Observer<AsyncGenerator> {

    public void update(AsyncGenerator asyncGenerator) {
        try {
            System.out.println("value: " + asyncGenerator.getValue().get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    
}
