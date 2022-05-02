package org.itmo.masha;

import org.itmo.masha.logarithm.MyLn;
import org.itmo.masha.logarithm.MyLog;

public class SecondPart{
    private double epsilon;
    private MyLn myLn;
    private final MyLog myLog2;
    private final MyLog myLog3;
    private final MyLog myLog5;
    private final MyLog myLog10;

    public SecondPart(MyLn myLn, MyLog myLog2,MyLog myLog3,MyLog myLog5, MyLog myLog10){
        this.myLn = myLn;
        this.myLog2 = myLog2;
        this.myLog3 = myLog3;
        this.myLog5 = myLog5;
        this.myLog10 = myLog10;
    }

    public double calc(double value){
        double first = ((myLog5.calc(value) + myLog3.calc(value)) / (myLog10.calc(value))) - myLn.calc(value);
        double second = Math.pow((myLog3.calc(value) / myLn.calc(value)), 2);
        double tmpFisrt = first + second;
        double fourth = (myLn.calc(value) / myLog10.calc(value));
        double fifth = (Math.pow(myLog5.calc(value), 3)) * (Math.pow(myLog2.calc(value), 2) / (myLog5.calc(value) + myLn.calc(value)));
        double tmpSecond = fourth + fifth;
        double res = tmpFisrt * tmpSecond;
        return res;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
        myLn.setEpsilon(epsilon);
        myLog2.setEpsilon(epsilon);
        myLog3.setEpsilon(epsilon);
        myLog5.setEpsilon(epsilon);
        myLog10.setEpsilon(epsilon);
    }

}
