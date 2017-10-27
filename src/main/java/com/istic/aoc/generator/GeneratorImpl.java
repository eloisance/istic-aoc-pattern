package com.istic.aoc.generator;

import com.istic.aoc.Channel;
import com.istic.aoc.observer.Observer;

import java.util.ArrayList;
import java.util.Random;

public class GeneratorImpl implements Generator {
    private Integer value;

    private ArrayList<Channel> observers = new ArrayList<Channel>();

    public void attach(Channel channel) {
        observers.add(channel);
    }

    public void detach(Channel channel) {
        observers.remove(channel);
    }

    public void notifyObservers() {
        for (Channel o : observers) {
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
