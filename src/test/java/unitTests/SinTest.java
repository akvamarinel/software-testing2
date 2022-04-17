package unitTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import trigonometry.MySin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SinTest {
    private MySin mySin;
    private static final double DELTA = 1.0e-4;

    @BeforeEach
    public void setUp() {
        mySin = new MySin(0.001);
    }


    @ParameterizedTest
    @CsvSource(value = {
            "0.523599, 0.5000",
            "0.785398, 0.70710",
            "1.0472, 0.86602"
    })
    public void mySinReturnsPositiveValuesInFirstQuarter(double arg, double ans) {
        double tmp = mySin.calc(arg);
        assertEquals(tmp, ans, DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-0.523599, -0.5000",
            "-0.785398, -0.7071",
            "-1.0472, -0.8660"
    })
    public void mySinReturnsNegativeValuesInFourthQuarter(double arg, double ans) {
        double tmp = mySin.calc(arg);
        assertEquals(tmp, ans, DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2.0944, 0.8660",
            "2.35619, 0.70710",
            "2.61799, 0.5000"
    })
    public void mySinReturnsPositiveValuesInSecondQuarter(double arg, double ans) {
        double tmp = mySin.calc(arg);
        assertEquals(tmp, ans, DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-2.0944, -0.8660",
            "-2.35619, -0.70710",
            "-2.61799, -0.5000"
    })
    public void mySinReturnsNegativeValuesInThirdQuarter(double arg, double ans) {
        double tmp = mySin.calc(arg);
        assertEquals(tmp, ans, DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0})
    public void mySinReturnsZeroWhenZero(double arg) {
        double tmp = mySin.calc(arg);
        assertEquals(tmp, 0);
    }


    @ParameterizedTest
    @ValueSource(doubles = {3.141592/2})
    public void mySinReturnsOneWhen90(double arg) {
        double tmp = mySin.calc(arg);
        assertEquals(tmp, 1, DELTA);
    }

   @Test
    public void mySinReturnsMinusOneWhen270() {
        double tmp = mySin.calc(-3.141592/2);
        assertEquals(tmp, -1, DELTA);
    }

    @Test
    public void mySinReturnsNaNWhenNan() {
        double tmp = mySin.calc(Double.NaN);
        assertEquals(tmp, Double.NaN);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY})
    public void mySinReturnsNaNWhenInfinity(double arg) {
        double tmp = mySin.calc(arg);
        assertEquals(tmp, Double.NaN);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, -2, -5, 0})
    public void setEpsilonReturnsException(double arg){
       assertThrows(IllegalArgumentException.class, () -> {mySin.setEpsilon(arg);});
    }


}