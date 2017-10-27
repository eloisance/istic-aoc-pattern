package com.istic.aoc;

import java.util.concurrent.Future;

/**
 * getValue
 */
public interface AsyncGenerator {

    Future<Integer> getValue();
}
