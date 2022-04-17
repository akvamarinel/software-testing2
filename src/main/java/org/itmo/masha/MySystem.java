package org.itmo.masha;

import org.itmo.masha.logarithm.*;
import org.itmo.masha.trigonometry.*;
import org.itmo.masha.useful.*;

public class MySystem implements FunctionInterface {
    private double epsilon;
    private MyCos myCos;
    private MySin mySin;
    private MyCot myCot;
    private MyLog myLog2;
    private MyLog myLog3;
    private MyLog myLog5;
    private MyLog myLog10;
    private MyLn myLn;


    public MySystem(double epsilon, MyLn myLn, MySin mySin, MyCos myCos, MyCot myCot, MyLog myLog2, MyLog myLog3, MyLog myLog5, MyLog myLog10) {
        this.epsilon = epsilon;
        this.myLn = new MyLn(epsilon);
        this.mySin = new MySin(epsilon);
        this.myCos = new MyCos(epsilon, mySin);
        this.myCot = new MyCot(epsilon, mySin);
        this.myLog2 = new MyLog(epsilon, 2, myLn);
        this.myLog3 = new MyLog(epsilon, 3, myLn);
        this.myLog5 = new MyLog(epsilon, 5, myLn);
        this.myLog10 = new MyLog(epsilon, 10, myLn);
    }

    @Override
    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    @Override
    public double calc(double value) {
        if (value <= 0) {
            return myCot.calc(value) * myCos.calc(value);
        } else {
            if (value == 1) {
                throw new IllegalArgumentException("the denominator must not be zero");
            } else {
                double first = ((myLog5.calc(value) + myLog3.calc(value)) / (myLog10.calc(value))) - myLn.calc(value);
                double second = Math.pow((myLog3.calc(value) / myLn.calc(value)), 2);
                double tmpFisrt = first + second;
                double fourth = (myLn.calc(value) / myLog10.calc(value));
                double fifth = (Math.pow(myLog5.calc(value), 3)) * Math.pow(myLog2.calc(value), 2) / (myLog5.calc(value) + myLn.calc(value));
                double tmpSecond = fourth + fifth;
                double res = tmpFisrt * tmpSecond;
//            double firstPart = (((myLog5.calc(value) + myLog3.calc(value))/myLog10.calc(value)) - myLn.calc(value) + (Math.pow(myLog3.calc(value)/myLn.calc(value), 2)));
//            double secondPart = ((myLn.calc(value)/myLog10.calc(value)) + (myLog5.calc(Math.pow(value, 3)) * (myLog2.calc(Math.pow(value, 2))/(myLog5.calc(value) + myLn.calc(value)))));
//            double result = firstPart * secondPart;
                return res;
            }
        }
    }
}
