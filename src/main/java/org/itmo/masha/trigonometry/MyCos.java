package org.itmo.masha.trigonometry;

import org.itmo.masha.useful.FunctionInterface;

public class MyCos implements FunctionInterface {
    private double epsilon;
    private MySin mySin;

    public MyCos(double epsilon, MySin mySin){
        this.epsilon = epsilon;
        this.mySin = mySin;
    }

    @Override
    public double calc(double value) {
        return mySin.calc(Math.PI/2 + value);
    }

    @Override
    public void setEpsilon(double epsilon) {
        if (epsilon <= 0 || epsilon == Double.NEGATIVE_INFINITY || epsilon == Double.POSITIVE_INFINITY || Double.isNaN(epsilon)) {
            throw new IllegalArgumentException("epsilon must be more than zero: " + epsilon);
        }
        this.epsilon = epsilon;
    }

    public double getEpsilon(){
        return epsilon;
    }
}
