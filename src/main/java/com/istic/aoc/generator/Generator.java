package com.istic.aoc.generator;

import com.istic.aoc.observer.Subject;

public interface Generator extends Subject<Generator> {
    Integer getValue();
    void generate();
}
