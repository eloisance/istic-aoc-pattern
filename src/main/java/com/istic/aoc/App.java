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
        ObservatorGenerator display1 = new Display();
        ObservatorGenerator display2 = new Display();

        // create channel for each display
        Channel c1 = new Channel();
        c1.setGenerator(g);
        c1.setDisplay(display1);

        Channel c2 = new Channel();
        c2.setGenerator(g);
        c2.setDisplay(display2);

        // g.attach(display);
        g.generate();
    }
}
