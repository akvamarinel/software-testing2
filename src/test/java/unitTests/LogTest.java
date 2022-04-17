package unitTests;

import logarithm.MyLn;
import logarithm.MyLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogTest {
    private MyLog myLog;
    private MyLn myLn;
    private final static double DELTA = 1.0e-2;

    @BeforeEach
    public void setUp(){
        myLn = new MyLn(0.001);
    }

    @ParameterizedTest
    @ValueSource(ints = {-4, -7, 0, 1})
    public void myLogReturnsExceptionWhenBaseLessThanZeroOrOne(int arg){
        assertThrows(IllegalArgumentException.class, () -> {myLog = new MyLog(0.001, arg, myLn);});
    }

    @ParameterizedTest
    @ValueSource(doubles = {-10.2, -5, 0})
    public void myLogReturnsNaNWhenParametersLessThanZero(double arg){
        double tmp = myLn.calc(arg);
        assertEquals(tmp, Double.NaN);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "10, 3.3233",
            "64, 6",
            "0.5, -1"
    })
    public void myLogReturnsRightValuesWhenNormalParameters(double arg, double ans){
        myLog = new MyLog(0.001, 2, myLn);
        double tmp = myLog.calc(arg);
        assertEquals(tmp, ans, DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0.5, -0.43067",
            "7, 1.20906",
            "625, 4"
    })
    public void myLogReturnsRightValuesWhenNormalParameters2(double arg, double ans){
        myLog = new MyLog(0.001, 5, myLn);
        double tmp = myLog.calc(arg);
        assertEquals(tmp, ans, DELTA);
    }
    @Test
    public void myLogReturnsInfinityWhenParameterInfinity(){
        myLog = new MyLog(0.001, 3, myLn);
        double tmp = myLog.calc(Double.POSITIVE_INFINITY);
        assertEquals(tmp, Double.POSITIVE_INFINITY);

    }
    @ParameterizedTest
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, -2, -5, 0})
    public void setEpsilonReturnsException(double arg){
        assertThrows(IllegalArgumentException.class, () -> {myLog.setEpsilon(arg);});
    }

}
