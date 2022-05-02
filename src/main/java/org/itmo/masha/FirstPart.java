package org.itmo.masha;

import org.itmo.masha.trigonometry.MyCos;
import org.itmo.masha.trigonometry.MyCot;
import org.itmo.masha.trigonometry.MySin;

public class FirstPart{
    private final MyCos myCos;
    private final MyCot myCot;
    private double epsilon;

    public FirstPart(MyCos myCos, MyCot myCot){
        this.myCos = myCos;
        this.myCot = myCot;
    }

    public double calc(double value){
        return myCot.calc(value) * myCos.calc(value);
    }

    public void setEpsilon(double epsilon){
        this.epsilon = epsilon;
        myCos.setEpsilon(epsilon);
        myCot.setEpsilon(epsilon);
    }
}
