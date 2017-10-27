package com.istic.aoc;

import java.util.concurrent.Future;

/**
 * getValue
 */
public interface GeneratorAsync {

    Future<Integer> getValue();
}
