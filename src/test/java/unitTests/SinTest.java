package unitTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import trigonometry.MySin;

public class SinTest {
    private MySin mySin;
    private static final double DELTA = 1.0e-2;

    @BeforeEach
    public void setUp(){
        mySin = new MySin(0.001);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "10, 3.3233",
            "64, 6",
            "0.5, -1"
    })
    public void mySinReturnsRightValuesWithNormalParameters(){

    }
}
