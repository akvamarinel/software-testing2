package unitTests;

import org.itmo.masha.trigonometry.MyCos;
import org.itmo.masha.trigonometry.MyCot;
import org.itmo.masha.trigonometry.MySin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CotTest {
    private MyCot myCot;
    private MySin mySin;

    @BeforeEach
    public void setUp(){
        mySin = new MySin(0.01);
        myCot = new MyCot(0.01, mySin);
    }

    @Test
    public void myCotReturnsNaNWhenZero(){
        double tmp = myCot.calc(0);
        assertEquals(tmp, Double.NaN);
    }
}
