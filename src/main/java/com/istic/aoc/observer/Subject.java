package com.istic.aoc.observer;

import com.istic.aoc.observer.Observer;

public interface Subject<T> {
    void attach(Observer<T> observer);
    void detach(Observer<T> observer);
    void notifyObservers();
}
