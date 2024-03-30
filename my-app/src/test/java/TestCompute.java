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
        when(mq.getAt(1)).thenReturn("aylin");
        when(mq.getAt(2)).thenReturn("Aylin");
        
        assertEquals(1, compute.countNumberOfOccurrences("Aylin"));
    }

    @Test
    public void testCountNumberOfOccurrences_EmptyQueue() {
        when(mq.size()).thenReturn(0);
        assertEquals(-1, compute.countNumberOfOccurrences("aylin"));
    }

    

}
