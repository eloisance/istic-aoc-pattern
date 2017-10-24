package com.istic.aoc;

public class App
{
    public static void main( String[] args )
    {
        Generator g = new ConcreteGenerator();
        ObservatorGenerator display = new Display();
        g.attach(display);
        g.generate();
    }
}
