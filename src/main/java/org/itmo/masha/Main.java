package org.itmo.masha;

import org.itmo.masha.logarithm.MyLn;
import org.itmo.masha.logarithm.MyLog;
import org.itmo.masha.trigonometry.MyCos;
import org.itmo.masha.trigonometry.MyCot;
import org.itmo.masha.trigonometry.MySin;

import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
         MySin mySin = new MySin(0.01);
         MyCos myCos = new MyCos(0.01, mySin);
         MyCot myCot = new MyCot(0.01, mySin);
         MyLn myLn = new MyLn(0.01);
         MyLog myLog2 = new MyLog(0.01, 2, myLn);
         MyLog myLog3 = new MyLog(0.01, 3, myLn);
         MyLog myLog5 = new MyLog(0.01, 5, myLn);
         MyLog myLog10 = new MyLog(0.01, 10, myLn);

        MySystem mySystem = new MySystem(0.01, myLn, mySin, myCos, myCot, myLog2, myLog3, myLog5, myLog10);
        //System.out.println(myCot.calc(0));
        System.out.println(mySystem.calc(-9));
//        List<FunctionInterface> list = new ArrayList<>();
//        list.add(mySin);
//        org.itmo.masha.CSVWriter.write(list, 0.3);
//       // double tmp = mySin.calc(4.134);
        //System.out.println(tmp);

        //System.out.println(myLn.calc(5));
        //System.out.println(Math.log(5));
        //MySin mySin = new MySin(0.0001);
        //MyCot myCot = new MyCot(0.0001);
        //System.out.println(myCot.calc(0.3));
        //System.out.println(1/Math.tan(0.3));
        //org.itmo.masha.MySystem ms = new org.itmo.masha.MySystem(0.01);
        //System.out.println(ms.calc(0.7));
        //System.out.println(mySin.calc(0.5));
        //System.out.println(Math.sin(0.5));
        //System.out.println(myLn.calc(10));
        //System.out.println(Math.log(10));
        //MyLog myLog = new MyLog(0.001, 3);
        //System.out.println(myLog.calc(0.7));
    }
}
