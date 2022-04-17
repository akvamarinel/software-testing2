package integrationTests;

import org.itmo.masha.logarithm.MyLn;
import org.itmo.masha.logarithm.MyLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {
    private static final double DELTA = 1.0e-3;
    private MyLog myLog;
     MyLn myLnStub = Mockito.mock(MyLn.class);

    @BeforeEach
    public void setUp(){
        Mockito.when(myLnStub.calc(1)).thenReturn(0.0);
        Mockito.when(myLnStub.calc(2)).thenReturn(0.6931);
    }

    @Test
    public void myLogWithStubs(){
        myLog = new MyLog(0.001, 2, myLnStub);
        double tmp = myLog.calc(1);
        assertEquals(tmp, 0, DELTA);
    }
}
