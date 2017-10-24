package com.istic.aoc;

public interface Generator {
    public void attach(Observer observer);
    public void detach(Observer observer);
    public void notifyObservers();
    public Integer getValue();
    public void generate();
}
