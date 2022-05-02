package org.itmo.masha.logarithm;

import org.itmo.masha.useful.FunctionInterface;

public class MyLog implements FunctionInterface {
    private double base;
    private double epsilon;
    private MyLn myLn;

    public MyLog(double epsilon, double base, MyLn myLn){
        if(base <= 0 || base == 1 || Double.isNaN(base) || base == Double.POSITIVE_INFINITY || base == Double.NEGATIVE_INFINITY){
            throw new IllegalArgumentException("base must be more than zero and not one: " + base);
        }
        this.base = base;
        this.myLn = myLn;
        this.epsilon = epsilon;
    }

    public double calc(double value){
        if (value <= 0){
            return Double.NaN;
        }
        if (value == Double.POSITIVE_INFINITY){
            return Double.POSITIVE_INFINITY;
        }
        double tmp1 =  myLn.calc(value);
        double tmp2 = myLn.calc(this.base);
        return tmp1/tmp2;
    }

    public void setBase(int base){
        this.base = base;
    }

    public double getBase(){
        return this.base;
    }

    public void setEpsilon(double epsilon){
        if (epsilon <= 0 || epsilon == Double.NEGATIVE_INFINITY || epsilon == Double.POSITIVE_INFINITY || Double.isNaN(epsilon)) {
            throw new IllegalArgumentException("epsilon must be more than zero: " + epsilon);
        }
        this.epsilon = epsilon;
        myLn.setEpsilon(epsilon);
    }
}
