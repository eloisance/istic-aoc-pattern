package com.istic.aoc;

import com.istic.aoc.generator.Generator;

import java.util.concurrent.Future;

/**
 * update
 */
public interface ObservatorGeneratorAsync {

    Future<Void> update(Generator g);
}
