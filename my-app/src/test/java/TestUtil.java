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

    @Test
    public void testZeroArgument() {
        try {
            util.compute(1, 2, 0);
            fail("Sıfır argümanı için RuntimeException bekleniyordu ancak atılmadı");
        } catch (RuntimeException exception) {
            // Test, RuntimeException fırlatıldığında geçer.
        }
    }

    @Test
    public void testDivisibleSumWithMultipleArguments() {
        assertTrue("Toplamın en az bir argümana tam bölünmesi true dönmelidir", util.compute(1, 2, 3));
    }

    @Test
    public void testMultipleZerosExpectingException() {
        try {
            util.compute(0, 0, 0, 0, 0);
            fail("Girdide sıfır olduğunda RuntimeException bekleniyordu ancak atılmadı");
        } catch (RuntimeException e) {
        }
    }


    @Test
    public void testLargeNumbers() {
        assertTrue("Taşma olmadan büyük değerler için true dönmelidir", util.compute(1000000, 2000000, -3000000));
    }

}
