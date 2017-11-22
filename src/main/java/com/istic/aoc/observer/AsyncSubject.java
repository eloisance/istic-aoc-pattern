package com.istic.aoc.observer;

import java.util.ArrayList;

public interface AsyncSubject<T> {
    void attach(AsyncObserver<T> observer);
    void detach(AsyncObserver<T> observer);
    void notifyObservers();
    ArrayList<AsyncObserver> getObservers();
}
