package com.istic.aoc;

import com.istic.aoc.generator.Generator;

import java.util.concurrent.Callable;

public class GetValue implements Callable<Integer> {

    private Generator generator;

    GetValue(Generator generator) {
        this.generator = generator;
    }

    public Integer call() throws Exception {
        return generator.getValue();
    }
}
