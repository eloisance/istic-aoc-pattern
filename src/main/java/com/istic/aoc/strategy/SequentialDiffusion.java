package com.istic.aoc.strategy;

import com.istic.aoc.generator.Generator;

public class SequentialDiffusion implements DiffusionAlgorithm {

    private Generator generator;

    public SequentialDiffusion(Generator g) {
        this.generator = g;
    }

    @Override
    public void configure() { }

    @Override
    public void execute() {
        this.generator.getObservers().forEach(o -> o.update(this.generator));
    }

}
