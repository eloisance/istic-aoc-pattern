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
    int delay;
    //private ArrayList<Observer> observers = new ArrayList<Observer>();

    Channel(int delay) {

        scheduledExecutorService = new ScheduledThreadPoolExecutor(Integer.MAX_VALUE);
        this.delay = delay;
    }


    public Future<Void> update(Generator generator) {
        // appeler la version synchrone de update() dans un thread
        // scheduler + method invocation
        this.generator = generator;
        Callable<Void> update = new Update(this);
        return scheduledExecutorService.schedule(update, delay, TimeUnit.MILLISECONDS);
//        () -> {
//            observer.update(Channel.this);
//            return null;}
    }

    public Future<Integer> getValue() {
        // appeler la version synchrone de getValue() dans un thread
        // scheduler + method invocation
        Callable<Integer> getValue = new GetValue(this.generator);
        return scheduledExecutorService.schedule(getValue, delay, TimeUnit.MILLISECONDS);
    }

    public void attach(Observer observer) {
        setObserver(observer);
    }

    public void detach(Observer observer) {
        setObserver(null);
    }

    public void notifyObservers() {
            observer.update(this);
    }

    public Generator getGenerator() {
        return generator;
    }

    public void setGenerator(Generator generator) {
        this.generator = generator;
    }

    public Observer<AsyncGenerator> getObserver() {
        return observer;
    }

    public void setObserver(Observer<AsyncGenerator> observer) {
        this.observer = observer;
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return scheduledExecutorService;
    }

    public void setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = scheduledExecutorService;
    }

//    public ArrayList<Observer> getObservers() {
//        return observers;
//    }
//
//    public void setObservers(ArrayList<Observer> observers) {
//        this.observers = observers;
//    }
}
