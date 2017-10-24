package com.istic.aoc;

import java.util.concurrent.Future;

public interface GeneratorAsync {
    Future<Integer> getValue();
}
