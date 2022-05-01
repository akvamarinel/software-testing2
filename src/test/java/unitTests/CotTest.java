package unitTests;

import org.itmo.masha.trigonometry.MyCos;
import org.itmo.masha.trigonometry.MyCot;
import org.itmo.masha.trigonometry.MySin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CotTest {
    private static final double DELTA = 1.0e-3;
    private static final double EPSILON = 0.001;
    private MyCot myCot;
    private MySin mySin;

    @BeforeEach
    public void setUp() {
        mySin = new MySin(EPSILON);
        myCot = new MyCot(EPSILON, mySin);
    }

    @Test
    public void myCotReturnsNaNWhenZero() {
        double tmp = myCot.calc(0);
        assertEquals(tmp, Double.NaN);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-2.0944, 0.5773",
            "-2.35619, 0.999",
            "-2.61799, 1.7320"
    })
    public void myCotReturnsRightValuesInThirdQuarter(double arg, double ans) {
        double tmp = myCot.calc(arg);
        assertEquals(tmp, ans, DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2.0944, -0.5773",
            "2.35619, -0.9999",
            "2.61799, -1.7320"
    })
    public void myCotReturnsRightValuesInSecondQuarter(double arg, double ans) {
        double tmp = myCot.calc(arg);
        assertEquals(tmp, ans, DELTA);
    }
}
