package integrationTests;

import org.itmo.masha.FirstPart;
import org.itmo.masha.MySystem;
import org.itmo.masha.SecondPart;
import org.itmo.masha.logarithm.MyLn;
import org.itmo.masha.logarithm.MyLog;
import org.itmo.masha.trigonometry.MyCos;
import org.itmo.masha.trigonometry.MyCot;
import org.itmo.masha.trigonometry.MySin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class IntegrationTest {
    private static final double DELTA = 1.0e-3;
    private static final double EPSILON = 0.01;
    private MyLog myLog;
    private MyCos myCos;
    private MySin mySin;
    private MyCot myCot;
    private MyLog myLog2;
    private MyLog myLog3;
    private MyLog myLog5;
    private MyLog myLog10;
    private MyLn myLn;
    private FirstPart firstPart;
    private SecondPart secondPart;
    private MySystem mySystem;
    private MyLn myLnStub = Mockito.mock(MyLn.class);
    private MySin mySinStub = Mockito.mock(MySin.class);
    private MyCos myCosStub = Mockito.mock(MyCos.class);
    private MyCot myCotStub = Mockito.mock(MyCot.class);
    private MyLog myLogStub = Mockito.mock(MyLog.class);
    private MyLog myLog2Stub = Mockito.mock(MyLog.class);
    private MyLog myLog3Stub = Mockito.mock(MyLog.class);
    private MyLog myLog5Stub = Mockito.mock(MyLog.class);
    private MyLog myLog10Stub = Mockito.mock(MyLog.class);
    private MySystem mySystemStub = Mockito.mock(MySystem.class);
    private FirstPart firstPartStub = Mockito.mock(FirstPart.class);
    private SecondPart secondPartStub = Mockito.mock(SecondPart.class);

    @BeforeEach
    public void setUp(){
        mySin = new MySin(EPSILON);
        myLn = new MyLn(EPSILON);
        myLog2 = new MyLog(EPSILON, 2, myLn);
        myLog3 = new MyLog(EPSILON, 3, myLn);
        myLog5 = new MyLog(EPSILON, 5, myLn);
        myLog10 = new MyLog(EPSILON, 10, myLn);
        firstPart = new FirstPart(myCos, myCot);
        secondPart = new SecondPart(myLn, myLog2, myLog3, myLog5, myLog10);
        mySystem = new MySystem(firstPart, secondPart);
        Mockito.when(myLnStub.calc(1)).thenReturn(0.0);
        //Mockito.when(myLnStub.calc(2)).thenReturn(0.6931);
        Mockito.when(mySinStub.calc(2.4367963267948967)).thenReturn(0.648);
        Mockito.when(mySinStub.calc(-0.5236036732051033)).thenReturn(-0.5000);
        Mockito.when(mySinStub.calc(4.188786326794896)).thenReturn(-0.8661);
        Mockito.when(mySinStub.calc(3.6651963267948964)).thenReturn(-0.499962);
        Mockito.when(mySinStub.calc(2.0944)).thenReturn(0.8661);
        Mockito.when(mySinStub.calc(3.9269863267948963)).thenReturn(-0.7074);
        Mockito.when(mySinStub.calc(-1.0471936732051033)).thenReturn(-0.86601);
        Mockito.when(mySinStub.calc(2.35619)).thenReturn(0.7074);
        Mockito.when(mySinStub.calc(-2.61799)).thenReturn(-0.4999);
        Mockito.when(mySinStub.calc(-0.42920367320510344)).thenReturn(-0.41614);
        Mockito.when(mySinStub.calc(-2.0)).thenReturn(-0.90934);
        Mockito.when(myCosStub.calc(-2.0)).thenReturn(-0.41614);
        Mockito.when(myCotStub.calc(-2.0)).thenReturn(0.457632);
        Mockito.when(mySinStub.calc(-3.4292036732051034)).thenReturn(0.28353);
        Mockito.when(mySinStub.calc(-5.0)).thenReturn(0.95889);
        Mockito.when(myCosStub.calc(-5.0)).thenReturn(0.28353);
        Mockito.when(myCotStub.calc(-5.0)).thenReturn(0.29568);
        Mockito.when(mySinStub.calc(-7.429203673205103)).thenReturn(-0.91112);
        Mockito.when(mySinStub.calc(-9.0)).thenReturn(-0.41205);
        Mockito.when(myCosStub.calc(-9.0)).thenReturn(-0.91112);
        Mockito.when(myCotStub.calc(-9.0)).thenReturn(2.21118);
        Mockito.when(myCotStub.calc(-9.0)).thenReturn(2.21118);
        Mockito.when(myLnStub.calc(2.0)).thenReturn(0.688172179310195);
        Mockito.when(myLnStub.calc(1.25)).thenReturn(0.21875);
        Mockito.when(myLog5Stub.calc(2.0)).thenReturn(0.43143038879869194);
        Mockito.when(myLnStub.calc(1.5)).thenReturn(0.4010416666666667);
        Mockito.when(myLnStub.calc(6.0)).thenReturn(1.7773860252870568);
        Mockito.when(myLog3Stub.calc(2.0)).thenReturn(0.6318063086069271);
        Mockito.when(myLog10Stub.calc(2.0)).thenReturn(0.3013980925476676);
        Mockito.when(myLog2Stub.calc(2.0)).thenReturn(1.0);
        Mockito.when(myLog2Stub.calc(6.0)).thenReturn(2.582763556452776);
        Mockito.when(myLog5Stub.calc(6.0)).thenReturn(1.1142826853355134);
        Mockito.when(myLog3Stub.calc(6.0)).thenReturn(1.6318063086069272);
        Mockito.when(myLog10Stub.calc(6.0)).thenReturn(0.7784400094164968);
        Mockito.when(firstPartStub.calc(-2.0)).thenReturn (-0.1904);
        Mockito.when(secondPartStub.calc(2.0)).thenReturn(8.6898);
    }

    @Test
    public void myLogWithStubs(){
        myLog = new MyLog(0.001, 2, myLnStub);
        double tmp = myLog.calc(1);
        verify(myLnStub, times(1)).calc(1);
        verify(myLnStub, times(1)).calc(2);
        assertEquals(tmp, 0, DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0.866, 0.648",
            "-2.0944, -0.5000",
            "2.61799, -0.86610 "
    })
    public void myCosWithStubs(double arg, double ans){
        myCos = new MyCos(0.001, mySinStub);
        double tmp = myCos.calc(arg);
        assertEquals(tmp, ans, DELTA);
    }


    @ParameterizedTest
    @CsvSource(value = {
            "2.0944, -0.5772",
            "2.35619, -0.9999",
            "-2.61799, 1.7321"
    })
    public void myCotWithStubs(double arg, double ans){
        myCot = new MyCot(0.001, mySinStub);
        double tmp = myCot.calc(arg);
        assertEquals(tmp, ans, DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-2, -0.1904",
            "-5, 0.0838",
            "-9, -2.0146"
    })
    public void mySystemWithStubsWhenLessThanZero(double arg, double ans){
        firstPart = new FirstPart(myCosStub, myCotStub);
        secondPart = new SecondPart(myLnStub, myLog2Stub, myLog3Stub, myLog5Stub, myLog10Stub);
        mySystem = new MySystem(firstPart, secondPart);
        double tmp = mySystem.calc(arg);
        assertEquals(tmp, ans, DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 8.6720",
            "6, 14.1973"
    })
    public void mySystemWithStubsWhenMoreThanZero(double arg, double ans){
        firstPart = new FirstPart(myCosStub, myCotStub);
        secondPart = new SecondPart(myLnStub, myLog2Stub, myLog3Stub, myLog5Stub, myLog10Stub);
        mySystem = new MySystem(firstPart, secondPart);
        double tmp = mySystem.calc(arg);
        assertEquals(tmp, ans, DELTA);
    }

    @Test
    public void mySystemWithFirstPartStub(){
        mySystem = new MySystem(firstPartStub, secondPartStub);
        double tmp = mySystem.calc(-2);
        verify(firstPartStub, times(1)).calc(-2);
        assertEquals(tmp, -0.1904, DELTA);
    }

    @Test
    public void mySystemWithSecondPartStub(){
        mySystem = new MySystem(firstPartStub, secondPartStub);
        double tmp = mySystem.calc(2);
        verify(secondPartStub, times(1)).calc(2);
        assertEquals(tmp, 8.6898, DELTA);
    }
}
