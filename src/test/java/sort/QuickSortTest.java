package sort;
import com.example.metrics.Metrics;
import com.example.sort.QuickSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class QuickSortTest {

@Test
public void testRandomArray() {
    int[] arr = {5, 2, 8, 1, 9};
    QuickSort.sort(arr, new Metrics());
    assertArrayEquals(new int[]{1,2,5,8,9}, arr);
}

@Test
public void testDepthBound() {
    int[] arr = new int[1000];
    for (int i = 0; i < arr.length; i++) arr[i] = (int)(Math.random() * 10000);
    
    Metrics metrics = new Metrics();
    QuickSort.sort(arr, metrics);
    
    int expectedMaxDepth = 2 * (int)Math.floor(Math.log(arr.length)/Math.log(2)) + 5;
    assertTrue(metrics.getMaxDepth() <= expectedMaxDepth, 
        "Depth " + metrics.getMaxDepth() + " exceeds bound " + expectedMaxDepth);
}
}
