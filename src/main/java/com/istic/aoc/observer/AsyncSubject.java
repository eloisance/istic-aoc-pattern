package com.istic.aoc.observer;

import com.istic.aoc.strategy.DiffusionAlgorithm;

import java.util.ArrayList;

public interface AsyncSubject<T> {
    void attach(AsyncObserver<T> observer);
    void detach(AsyncObserver<T> observer);
    void notifyObservers();
    ArrayList<AsyncObserver> getObservers();
    void setAlgo(DiffusionAlgorithm diffusionAlgorithm);
}
