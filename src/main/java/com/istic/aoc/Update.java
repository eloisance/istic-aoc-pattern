package com.istic.aoc;

import com.istic.aoc.observer.AsyncObserver;

import java.util.Observer;
import java.util.concurrent.Callable;

public class Update implements Callable<Void> {

    private AsyncGenerator asyncGenerator;
    private com.istic.aoc.observer.Observer<AsyncGenerator> observer;

    public Update(AsyncGenerator a, com.istic.aoc.observer.Observer<AsyncGenerator> observer) {

        this.asyncGenerator = a;
        this.observer = observer;

    }

    public Void call() throws Exception {
        this.observer.update(this.asyncGenerator);
        return null;
    }

}
