package unitTests;

import org.itmo.masha.logarithm.MyLn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LnTest {
    private MyLn myLn;
    private static final double DELTA = 1.0e-3;
    private static final double EPSILON = 0.0001;

    @BeforeEach
    public void setUp(){
        myLn = new MyLn(EPSILON);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-10.2, -5, 0})
    public void myLnReturnsNaNWhenLessThanZero(double arg){
       double tmp = myLn.calc(arg);
       assertEquals(tmp, Double.NaN);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2.7, 0.9932",
            "6.0, 1.7917",
            "17.6, 2.8678"
    })
    public void myLnReturnsRightValuesWhenNormalParameters(double arg, double ans){
        double tmp = myLn.calc(arg);
        assertEquals(tmp, ans, DELTA);
    }

    @Test
    public void myLnReturnsInfinityWhenInfinity(){
        double tmp = myLn.calc(Double.POSITIVE_INFINITY);
        assertEquals(tmp, Double.POSITIVE_INFINITY);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, -2, -5, 0})
    public void setEpsilonReturnsException(double arg){
        assertThrows(IllegalArgumentException.class, () -> {myLn.setEpsilon(arg);});
    }

}
