package com.istic.aoc.generator;

import com.istic.aoc.observer.AsyncObserver;
import com.istic.aoc.strategy.AlgoDiffusion;

import java.util.ArrayList;
import java.util.Random;

public class GeneratorImpl implements Generator {

    private Integer value;

    private ArrayList<AsyncObserver> observers = new ArrayList<AsyncObserver>();

    private AlgoDiffusion diffusion;


    public void generate() {
        Random r = new Random();
        setValue(r.nextInt());
        notifyObservers();
    }

    public Integer getValue() {
       return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void attach(AsyncObserver<Generator> observer) {

        this.observers.add(observer);
    }

    public void detach(AsyncObserver<Generator> observer) {

        this.observers.remove(observer);
    }

    public void notifyObservers() {

        this.observers.forEach(o -> o.update(this));
    }
}
