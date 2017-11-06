package com.istic.aoc;

import com.istic.aoc.observer.AsyncObserver;
import com.istic.aoc.observer.Subject;

import java.util.Observer;
import java.util.concurrent.Callable;

public class Update implements Callable<Void> {


    private Subject subject;

    public Update(Subject subject) {

        this.subject = subject;

    }

    public Void call() throws Exception {
        this.subject.notifyObservers();
        return null;
    }

}
