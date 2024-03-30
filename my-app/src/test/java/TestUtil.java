import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TestUtil {
    private Util util;

    @Before
    public void setUp() {
        util = new Util();
    }

    @Test
    public void example() { assertTrue(true); }

    @Test
    public void testSingleArgument() {
        assertFalse("Tek argüman false dönmelidir", util.compute(1));
    }

    @Test
    public void testNotDivisibleSumWithOddArguments() {
        assertFalse("Toplamın hiçbir argümana bölünmemesi false dönmelidir", util.compute(19, 7, 17));
    }


    @Test
    public void testEvenNumberArguments() {
        assertFalse("Çift sayıda argüman false dönmelidir", util.compute(1, 2, 3, 4));
    }


}
