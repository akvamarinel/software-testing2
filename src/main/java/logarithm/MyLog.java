package main.java.logarithm;

import main.java.useful.FunctionInterface;

public class MyLog implements FunctionInterface {
    private int base;
    private double epsilon;
    static private MyLn myLn;

    public MyLog(double epsilon, int base, MyLn myLn){
        if(base <= 0 || base == 1){
            throw new IllegalArgumentException("base must be more than zero and not one: " + base);
        }
        this.base = base;
        this.myLn = myLn;
        this.epsilon = epsilon;
    }

    public double calc(double value){
        double tmp1 =  myLn.calc(value);
        double tmp2 = myLn.calc(this.base);
        return tmp1/tmp2;
    }

    public void setBase(int base){
        this.base = base;
    }

    public int getBase(){
        return this.base;
    }

    public void setEpsilon(double epsilon){
        myLn.setEpsilon(epsilon);
    }
}
