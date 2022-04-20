package unitTests;

import org.itmo.masha.MySystem;
import org.itmo.masha.logarithm.MyLn;
import org.itmo.masha.logarithm.MyLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.itmo.masha.trigonometry.MyCos;
import org.itmo.masha.trigonometry.MyCot;
import org.itmo.masha.trigonometry.MySin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SystemTest {
    private MySystem mySystem;
    private MyCos myCos;
    private MySin mySin;
    private MyCot myCot;
    private MyLog myLog2;
    private MyLog myLog3;
    private MyLog myLog5;
    private MyLog myLog10;
    private MyLn myLn;
    private final static double EPSILON = 0.001;
    private static final double DELTA = 1.0e-3;

    @BeforeEach
    public void setUp(){
        myLn = new MyLn(EPSILON);
        mySin = new MySin(EPSILON);
        myCos = new MyCos(EPSILON, mySin);
        myCot = new MyCot(EPSILON, mySin);
        myLog2 = new MyLog(EPSILON, 2, myLn);
        myLog3 = new MyLog(EPSILON, 3, myLn);
        myLog5 = new MyLog(EPSILON, 5, myLn);
        myLog10 = new MyLog(EPSILON, 10, myLn);
        mySystem = new MySystem(0.01, myLn, mySin, myCos, myCot, myLog2, myLog3, myLog5, myLog10);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 8.6720",
            "6, 14.1787",
            "9, 20.5445"
    })
    public void mySystemReturnsRightValueWhenMoreThanZero(double arg, double ans){
        double tmp = mySystem.calc(arg);
        assertEquals(tmp, ans, DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-2, -0.1904",
            "-5, 0.0838",
            "-9, -2.0135"
    })
    public void mySystemReturnsRightValueWhenLessThanZero(double arg, double ans){
        double tmp = mySystem.calc(arg);
        assertEquals(tmp, ans, DELTA);
    }

    @Test
    public void mySystemReturnsExceptionWhenOne(){
        assertThrows(IllegalArgumentException.class, () -> {mySystem.calc(1);});
    }

    @Test
    public void mySystemReturnsNaNWhenZero(){
        double tmp = mySystem.calc(0);
        assertEquals(tmp, Double.NaN);
    }
}
