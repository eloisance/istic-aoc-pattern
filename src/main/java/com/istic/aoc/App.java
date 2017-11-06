package com.istic.aoc;

import com.istic.aoc.generator.GeneratorImpl;
import com.istic.aoc.generator.Generator;
import com.istic.aoc.observer.Observer;

public class App
{
    public static void main(String[] args)
    {
        Generator g = new GeneratorImpl();

        Observer<AsyncGenerator> display1 = new Display();
        Observer<AsyncGenerator> display2 = new Display();

        Channel c1 = new Channel();
        Channel c2 = new Channel();

        g.attach((Observer<Generator>) c1);
        c1.setObserver(display1);

        g.generate();

    }
}
