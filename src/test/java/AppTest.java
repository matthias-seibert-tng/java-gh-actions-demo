import com.example.App;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testApp() {
        App myApp = new App();

        String result = myApp.getStatus();

        assertEquals("OK", result);
    }
    
    @Test
    public void testPiCalculation() {
        App myApp = new App();

        int pi = myApp.calculatePiForN(1000).setScale(0, RoundingMode.HALF_UP).intValue();

        assertEquals(4, pi);
    }

}
