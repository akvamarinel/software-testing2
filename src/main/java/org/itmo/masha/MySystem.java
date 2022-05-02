package org.itmo.masha;

import org.itmo.masha.logarithm.*;
import org.itmo.masha.trigonometry.*;
import org.itmo.masha.useful.*;

public class MySystem implements FunctionInterface {
    private double epsilon;
    private final FirstPart firstPart;
    private final SecondPart secondPart;

    public MySystem(FirstPart firstPart, SecondPart secondPart){
        this.firstPart = firstPart;
        this.secondPart = secondPart;
    }

    @Override
    public double calc(double value) {
        if (value <= 0) {
            return firstPart.calc(value);
        } else {
            if (value == 1) {
                throw new IllegalArgumentException("the denominator must not be zero");
            } else {
                return secondPart.calc(value);
            }
        }
    }

    @Override
    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
        ;
    }
}
