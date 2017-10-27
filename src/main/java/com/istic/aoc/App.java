package com.istic.aoc;

import com.istic.aoc.generator.GeneratorImpl;
import com.istic.aoc.generator.Generator;

public class App
{
    public static void main(String[] args)
    {
        Generator g = new GeneratorImpl();

        ObservatorGenerator display1 = new Display();
        ObservatorGenerator display2 = new Display();

        Channel c1 = new Channel();
        Channel c2 = new Channel();

        g.attach(c1);

        g.generate();
    }
}
