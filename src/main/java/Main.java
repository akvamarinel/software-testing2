import logarithm.MyLn;
import trigonometry.MySin;

import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
        MySin mySin = new MySin(0.001);
        double tmp = mySin.calc(4.134);
        System.out.println(tmp);

        //System.out.println(myLn.calc(5));
        //System.out.println(Math.log(5));
        //MySin mySin = new MySin(0.0001);
        //MyCot myCot = new MyCot(0.0001);
        //System.out.println(myCot.calc(0.3));
        //System.out.println(1/Math.tan(0.3));
        //MySystem ms = new MySystem(0.01);
        //System.out.println(ms.calc(0.7));
        //System.out.println(mySin.calc(0.5));
        //System.out.println(Math.sin(0.5));
        //System.out.println(myLn.calc(10));
        //System.out.println(Math.log(10));
        //MyLog myLog = new MyLog(0.001, 3);
        //System.out.println(myLog.calc(0.7));
    }
}
