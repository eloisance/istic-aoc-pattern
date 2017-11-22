package com.istic.aoc.generator;

import com.istic.aoc.observer.AsyncSubject;
import com.istic.aoc.strategy.DiffusionAlgorithm;

public interface Generator extends AsyncSubject<Generator> {
    Integer getValue();
    void generate();
    void setAlgo(DiffusionAlgorithm diffusionAlgorithm);
}
