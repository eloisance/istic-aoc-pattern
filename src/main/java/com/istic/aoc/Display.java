package com.istic.aoc;

public class Display implements ObservatorGenerator {

    public void update(Generator subject) {
        System.out.println("value: " + subject.getValue());
    }
}
