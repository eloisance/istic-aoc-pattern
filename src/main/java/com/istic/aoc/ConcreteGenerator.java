package com.istic.aoc;

import java.util.ArrayList;
import java.util.Random;

public class ConcreteGenerator implements Generator {
    private Integer value;

    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

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
}
