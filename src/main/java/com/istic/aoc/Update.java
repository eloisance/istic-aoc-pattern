package com.istic.aoc;

import com.istic.aoc.observer.AsyncObserver;

import java.util.Observer;
import java.util.concurrent.Callable;

public class Update implements Callable<Void> {

    private AsyncGenerator asyncGenerator;

    public Update(AsyncGenerator a) {
        this.asyncGenerator = a;
    }

    public Void call() throws Exception {
        this.observer.update(channel);
        return null;
    }

}
