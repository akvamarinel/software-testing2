package org.itmo.masha;

import org.itmo.masha.logarithm.MyLn;
import org.itmo.masha.logarithm.MyLog;
import org.itmo.masha.trigonometry.MyCos;
import org.itmo.masha.trigonometry.MyCot;
import org.itmo.masha.trigonometry.MySin;
import org.itmo.masha.useful.FunctionInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static double EPSILON = 0.01;
    public static void main(String [] args) throws IOException {
         MySin mySin = new MySin(EPSILON);
         MyCos myCos = new MyCos(EPSILON, mySin);
         MyCot myCot = new MyCot(EPSILON, mySin);
         MyLn myLn = new MyLn(EPSILON);
         MyLog myLog2 = new MyLog(EPSILON, 2, myLn);
         MyLog myLog3 = new MyLog(EPSILON, 3, myLn);
         MyLog myLog5 = new MyLog(EPSILON, 5, myLn);
         MyLog myLog10 = new MyLog(EPSILON, 10, myLn);
         MySystem mySystem = new MySystem(EPSILON, myLn, mySin, myCos, myCot, myLog2, myLog3, myLog5, myLog10);
         List <FunctionInterface> list = new ArrayList<>();
         list.add(mySystem);
         list.add(myLog2);
         list.add(myLog3);
         list.add(myLog5);
         list.add(myLog10);
         list.add(myCos);
         list.add(mySin);
         list.add(myCot);
         list.add(myLn);
         CSVWriter writer = new CSVWriter();
         writer.write(list, 0.01);



    }
}
