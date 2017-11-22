package com.istic.aoc.strategy;

import com.istic.aoc.generator.Generator;

import java.util.concurrent.ExecutionException;

public class AtomicDiffusion implements DiffusionAlgorithm {

    private Generator generator;

    public AtomicDiffusion(Generator g) {
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
