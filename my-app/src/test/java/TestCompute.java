import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestCompute {

    private Compute compute;
    private MessageQueue mq;

    @Before
    public void setUp() {
        mq = mock(MessageQueue.class); 
        compute = new Compute(mq);
    }

    @Test
    public void example() {
      MessageQueue mq = mock(MessageQueue.class);
      compute = new Compute(mq);
      assertTrue(true);
    }

    @Test
    public void testCountNumberOfOccurrences_MixedCase() {
        when(mq.size()).thenReturn(3);
        when(mq.contains("Aylin")).thenReturn(true);
        when(mq.getAt(0)).thenReturn("AYLİN");
        when(mq.getAt(1)).thenReturn("Aylin");
        when(mq.getAt(2)).thenReturn("aylin");
        
        assertEquals(1, compute.countNumberOfOccurrences("Aylin"));
    }

    @Test
    public void testCountNumberOfOccurrences_EmptyQueue() {
        when(mq.size()).thenReturn(0);
        assertEquals(-1, compute.countNumberOfOccurrences("aylin"));
    }

    @Test
    public void testCountNumberOfOccurrences_LargeQueue() {
        when(mq.size()).thenReturn(1000);
        when(mq.contains("a")).thenReturn(true);
        for (int i = 0; i < 1000; i++) {
            when(mq.getAt(i)).thenReturn(i % 2 == 0 ? "a" : "b");
        }

        assertEquals(500, compute.countNumberOfOccurrences("a"));
    }

    @Test
    public void testCountNumberOfOccurrences_ElementNotFound() {
        when(mq.size()).thenReturn(5);
        when(mq.contains("test")).thenReturn(false);
        assertEquals(0, compute.countNumberOfOccurrences("test"));
    }

    @Test
    public void testCountNumberOfOccurrences_ElementFound() {
        when(mq.size()).thenReturn(8);
        when(mq.contains("a")).thenReturn(true);
        when(mq.getAt(0)).thenReturn("a");
        when(mq.getAt(1)).thenReturn("b");
        when(mq.getAt(2)).thenReturn("a");
        
        assertEquals(2, compute.countNumberOfOccurrences("a"));
    }

      

    @Test
    public void testCountNumberOfOccurrences_SpecialCharacters() {
        when(mq.size()).thenReturn(3);
        when(mq.contains("@#%")).thenReturn(true);
        when(mq.getAt(0)).thenReturn("other");
        when(mq.getAt(1)).thenReturn("@#%");
        when(mq.getAt(2)).thenReturn("@#%");

        assertEquals(2, compute.countNumberOfOccurrences("@#%"));
    }    

 @Test
    public void testCountNumberOfOccurrences_EmptyString() {
        when(mq.size()).thenReturn(7);
        when(mq.contains("")).thenReturn(true);
        when(mq.getAt(0)).thenReturn("");
        when(mq.getAt(1)).thenReturn("something");
        when(mq.getAt(2)).thenReturn("");
        
        assertEquals(2, compute.countNumberOfOccurrences(""));
    }

    @Test(expected = NullPointerException.class)
    public void testCountNumberOfOccurrences_NullElement() {
        when(mq.size()).thenReturn(3);
        when(mq.contains(null)).thenReturn(true);
        when(mq.getAt(0)).thenReturn(null);
        when(mq.getAt(1)).thenReturn("test");
        when(mq.getAt(2)).thenReturn(null);

        compute.countNumberOfOccurrences(null);
    }

}
