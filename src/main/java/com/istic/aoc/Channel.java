package com.istic.aoc;

import com.istic.aoc.generator.Generator;
import com.istic.aoc.observer.ObservatorGenerator;

import java.util.concurrent.*;

public class Channel implements ObservatorGeneratorAsync, GeneratorAsync {

    private Generator generator;
    private ObservatorGenerator display;
    private ScheduledExecutorService scheduledExecutorService;

    public Channel() {
        scheduledExecutorService = new ScheduledThreadPoolExecutor(Integer.MAX_VALUE);
    }


    public Future<Void> update(Generator generator) {
        // appeler la version synchrone de update() dans un thread
        // scheduler + method invocation
        Callable<Void> update = new Update(this.display, this);
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
}
