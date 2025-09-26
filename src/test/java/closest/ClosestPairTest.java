package closest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.closest.ClosestPair;
import java.awt.Point;
import java.util.Random;
public class ClosestPairTest {

@Test
public void testSmallSet() {
    Point[] points = {new Point(0,0), new Point(3,4), new Point(1,1)};
    double result = ClosestPair.closestPair(points);
    assertEquals(Math.sqrt(2), result, 1e-6);
}

@Test
public void testTwoPoints() {
    Point[] points = {new Point(0,0), new Point(0,1)};
    double result = ClosestPair.closestPair(points);
    assertEquals(1.0, result, 1e-6);
}

@Test
public void testClosestPairVsBruteForce() {
    Random rand = new Random();
    for (int trial = 0; trial < 10; trial++) {
        Point[] points = new Point[100];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(rand.nextInt(1000), rand.nextInt(1000));
        }
        
        double fastResult = ClosestPair.closestPair(points);
        double bruteResult = bruteForceClosestPair(points);
        
        assertEquals(bruteResult, fastResult, 1e-6, "Trial " + trial + " failed");
    }
}

private double bruteForceClosestPair(Point[] points) {
    double min = Double.MAX_VALUE;
    for (int i = 0; i < points.length; i++) {
        for (int j = i + 1; j < points.length; j++) {
            double dist = Math.hypot(points[i].x - points[j].x, points[i].y - points[j].y);
            if (dist < min) min = dist;
        }
    }
    return min;
}
}
