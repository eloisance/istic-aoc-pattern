package com.istic.aoc;

import com.istic.aoc.generator.GeneratorImpl;
import com.istic.aoc.generator.Generator;
import com.istic.aoc.observer.Display;
import com.istic.aoc.observer.ObservatorGenerator;

public class App
{
    public static void main( String[] args )
    {
        Generator g = new GeneratorImpl();
        ObservatorGenerator display = new Display();
        g.attach(display);
        g.generate();
    }
}
