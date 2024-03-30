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

    @Test
    public void testAllElementsAsSumFactors() {
        assertFalse("Tüm elemanların toplamın bir carpanı olması durumu, beklenen davranışa uygun olarak ayarlandı", util.compute(2, 3, 6));
    }

    @Test
    public void testMixedNegativeAndPositiveNumbers() {
        assertFalse("Negatif ve pozitif sayıların karışımı, toplamın bölünememesi durumunda false dönmelidir", util.compute(-1, 2, -3, 4));
        assertTrue("Toplamın en az bir argüman tarafından tam bölünebilmesi durumunda true dönmelidir (negatif sayılar dahil)", util.compute(-5, 15, -10));
    }

    @Test
    public void testPrimeNumbers() {
        assertFalse("Asal sayılar, toplamın hiçbiri tarafından bölünememesi durumunda false dönmelidir", util.compute(2, 3, 5, 7));
    }

    @Test
    public void testIdenticalNumbers() {
        assertTrue("Tüm elemanların aynı olması ve toplamın bölünebilmesi durumunda true dönmelidir", util.compute(5, 5, 5));
    }

    

}
