package com.istic.aoc;

import com.istic.aoc.observer.ObservatorGenerator;

import java.util.concurrent.Callable;

public class Update implements Callable<Void> {

    private ObservatorGenerator display;
    private Channel channel;

    public Update(ObservatorGenerator d, Channel c) {
        this.display = d;
        this.channel = c;
    }

    public Void call() throws Exception {
        this.display.update(channel);
        return null;
    }

}
