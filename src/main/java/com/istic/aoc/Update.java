package com.istic.aoc;

import com.istic.aoc.observer.Subject;

import java.util.concurrent.Callable;

public class Update implements Callable<Void> {

    private Subject subject;

    Update(Subject subject) {
        this.subject = subject;
    }

    public Void call() throws Exception {
        this.subject.notifyObservers();
        return null;
    }
}
