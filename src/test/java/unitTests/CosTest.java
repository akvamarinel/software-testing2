package unitTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.itmo.masha.trigonometry.MyCos;
import org.itmo.masha.trigonometry.MySin;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosTest {
    private static final double DELTA = 1.0e-3;
    private MyCos myCos;
    private MySin mySin;

    @BeforeEach
    public void setUp(){
        mySin = new MySin(0.001);
        myCos = new MyCos(0.001, mySin);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0.523599, 0.8660",
            "0.785398, 0.70710",
            "1.0472, 0.499997"
    })
    public void myCosReturnsPositiveValuesInFirstQuarter (double arg, double ans) {
        double tmp = myCos.calc(arg);
        assertEquals(tmp, ans, DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-0.523599, 0.8660",
            "-0.785398, 0.70710",
            "-1.0472, 0.499997"
    })
    public void myCosReturnsPositiveValuesInFourthQuarter(double arg, double ans){
        double tmp = myCos.calc(arg);
        assertEquals(tmp, ans, DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2.0944, -0.50000",
            "2.35619, -0.707103",
            "2.61799, -0.86602"
    })
    public void myCosReturnsNegativeValuesInSecondQuarter(double arg, double ans){
        double tmp = myCos.calc(arg);
        assertEquals(tmp, ans, DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-2.0944, -0.5000",
            "-2.35619, -0.7071",
            "-2.61799, -0.86604"
    })
    public void myCosReturnsNegativeValuesInThirdQuarter(double arg, double ans){
        double tmp = myCos.calc(arg);
        assertEquals(tmp, ans, DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0})
    public void myCosReturnsOneWhenZero(double arg){
        double tmp = myCos.calc(arg);
        assertEquals(tmp, 1, DELTA);
    }


    @ParameterizedTest
    @ValueSource(doubles = {3.141592})
    public void myCosReturnsMinusOneWhen180(double arg){
        double tmp = myCos.calc(arg);
        assertEquals(tmp, -1, DELTA);
    }


    @Test
    public void myCosReturnsNaNWhenNan(){
        double tmp = myCos.calc(Double.NaN);
        assertEquals(tmp, Double.NaN);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY})
    public void myCosReturnsNaNWhenInfinity(double arg){
        double tmp = myCos.calc(arg);
        assertEquals(tmp, Double.NaN);
    }
}
