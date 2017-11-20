package com.istic.aoc.strategy;

import com.istic.aoc.generator.GeneratorImpl;

import java.util.concurrent.ExecutionException;

public class AtomicDiffusion implements DiffusionAlgorithm {

    private GeneratorImpl generator;

    public AtomicDiffusion(GeneratorImpl g) {
        this.generator = g;
    }

    @Override
    public void configure() { }

    @Override
    public void execute() {
        this.generator.getObservers().forEach(o -> {
            try {
                o.update(this.generator).get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

}
