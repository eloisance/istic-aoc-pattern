package com.istic.aoc.observer;

public interface AsyncSubject<T> {
    void attach(AsyncObserver<T> observer);
    void detach(AsyncObserver<T> observer);
    void notifyObservers();
}
