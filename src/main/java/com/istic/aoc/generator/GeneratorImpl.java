package com.istic.aoc.generator;

import com.istic.aoc.Channel;
import com.istic.aoc.observer.Observer;

import java.util.ArrayList;
import java.util.Random;

public class GeneratorImpl implements Generator {

    private Integer value;

    private ArrayList<Observer> observers = new ArrayList<Observer>();


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

    public void attach(Observer<Generator> observer) {
        this.observers.add(observer);
    }

    public void detach(Observer<Generator> observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        this.observers.forEach(o -> o.update(this));
    }
}
