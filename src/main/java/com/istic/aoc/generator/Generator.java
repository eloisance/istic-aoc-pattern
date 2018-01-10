package com.istic.aoc.generator;

import com.istic.aoc.observer.AsyncSubject;

public interface Generator extends AsyncSubject<Generator> {
    Integer getValue();
    void generate();
}
