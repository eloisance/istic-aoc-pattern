package com.istic.aoc.observer;

import java.util.concurrent.Future;

/**
 * update
 */
public interface AsyncObserver<T> {

    Future<Void> update(T g);
}
