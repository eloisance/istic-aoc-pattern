package com.istic.aoc;

import com.istic.aoc.generator.Generator;
import com.istic.aoc.generator.GeneratorImpl;

import java.util.concurrent.Callable;

public class GetValue implements Callable<Integer> {

    private Generator generator;

    public GetValue(Generator generator) {

        this.generator = generator;
    }

    public Integer call() throws Exception {
        return generator.getValue();
    }

}
