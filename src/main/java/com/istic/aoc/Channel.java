package com.istic.aoc;

import com.istic.aoc.generator.Generator;
import com.istic.aoc.observer.AsyncObserver;
import com.istic.aoc.observer.Observer;
import com.istic.aoc.observer.Subject;

import java.util.concurrent.*;

public class Channel implements Subject<AsyncGenerator>, AsyncObserver<Generator>, AsyncGenerator {

    private Generator generator;
    private Observer<AsyncGenerator> observer;
    private ScheduledExecutorService scheduledExecutorService;
    private Integer delay;

    Channel(int delay) {
        this.delay = delay;
        scheduledExecutorService = new ScheduledThreadPoolExecutor(Integer.MAX_VALUE);
    }

    /**
     * Call the update method in ScheduledExecutorService
     * @param generator who have display to update
     * @return Future Void
     */
    public Future<Void> update(Generator generator) {
        this.generator = generator;
        Callable<Void> update = new Update(this);
        return scheduledExecutorService.schedule(update, delay, TimeUnit.MILLISECONDS);
    }

    /**
     * Call the getValue in ScheduledExecutorService
     * @return Future Integer
     */
    public Future<Integer> getValue() {
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

    public Observer<AsyncGenerator> getObserver() {
        return observer;
    }

    public void setObserver(Observer<AsyncGenerator> observer) {
        this.observer = observer;
    }

}
