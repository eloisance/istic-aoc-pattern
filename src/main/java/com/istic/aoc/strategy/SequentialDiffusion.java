package com.istic.aoc.strategy;

import com.istic.aoc.generator.GeneratorImpl;

public class SequentialDiffusion implements DiffusionAlgorithm {

    private GeneratorImpl generator;

    public SequentialDiffusion(GeneratorImpl g) {
        this.generator = g;
    }

    @Override
    public void configure() { }

    @Override
    public void execute() {
        this.generator.getObservers().forEach(o -> o.update(this.generator));
    }

}
