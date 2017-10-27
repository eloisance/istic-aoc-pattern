package com.istic.aoc;

import com.istic.aoc.generator.Generator;
import com.istic.aoc.observer.AsyncObserver;
import com.istic.aoc.observer.Observer;
import com.istic.aoc.observer.Subject;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Channel implements Subject<AsyncGenerator>, AsyncObserver<Generator>, AsyncGenerator {

    private Generator generator;
    private Observer<AsyncGenerator> observer;
    private ScheduledExecutorService scheduledExecutorService;

    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public Channel() {
        scheduledExecutorService = new ScheduledThreadPoolExecutor(Integer.MAX_VALUE);
    }


    public Future<Void> update(Generator generator) {
        // appeler la version synchrone de update() dans un thread
        // scheduler + method invocation
        Callable<Void> update = new Update(this.observer, this);
        return scheduledExecutorService.schedule(update, 1, TimeUnit.SECONDS);
    }

    public Future<Integer> getValue() {
        // appeler la version synchrone de getValue() dans un thread
        // scheduler + method invocation
        Callable<Integer> getValue = new GetValue(this.generator);
        return scheduledExecutorService.schedule(getValue, 1, TimeUnit.SECONDS);
    }

    public Generator getGenerator() {
        return generator;
    }

    public void setGenerator(Generator generator) {
        this.generator = generator;
    }

    public ObservatorGenerator getDisplay() {
        return display;
    }

    public void setDisplay(ObservatorGenerator display) {
        this.display = display;
    }

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
}
