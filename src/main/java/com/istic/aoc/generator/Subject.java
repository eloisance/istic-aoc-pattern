package com.istic.aoc.generator;

import com.istic.aoc.Channel;
import com.istic.aoc.observer.Observer;

public interface Subject {
    void attach(Channel observer);
    void detach(Channel observer);
    void notifyObservers();
}
