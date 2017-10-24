package com.istic.aoc.observer;

import com.istic.aoc.generator.Generator;

public class Display implements ObservatorGenerator {

    public void update(Generator subject) {
        System.out.println("value: " + subject.getValue());
    }
}
