package com.istic.aoc.generator;

import com.istic.aoc.observer.Observer;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}
