import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {

    @Test
    public void isSameNumberTest(){
        assertTrue("should be true but false", Flik.isSameNumber(1, 1));
        assertTrue("should be false but true", Flik.isSameNumber(2, 3));
    }
}
