package com.istic.aoc.generator;

import com.istic.aoc.observer.AsyncObserver;
import com.istic.aoc.strategy.AtomicDiffusion;
import com.istic.aoc.strategy.DiffusionAlgorithm;

import java.util.ArrayList;

public class GeneratorImpl implements Generator {

    private Integer value = new Integer(0);

    private ArrayList<AsyncObserver> observers = new ArrayList<AsyncObserver>();

    private DiffusionAlgorithm diffusion;

    public void generate() {
        value+= 1;
        setValue(value);
        diffusion = new AtomicDiffusion(this);
        diffusion.execute();
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

    public ArrayList<AsyncObserver> getObservers() {
        return observers;
    }

    public void notifyObservers() {
        this.observers.forEach(o -> o.update(this));
    }
}
