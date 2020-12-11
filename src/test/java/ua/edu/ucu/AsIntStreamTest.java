package ua.edu.ucu;

import org.junit.Test;
import ua.edu.ucu.stream.AsIntStream;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AsIntStreamTest {

    @Test
    public void averageTest() {
        ArrayList<Integer> intArrayList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        AsIntStream intStream = new AsIntStream(intArrayList);
        double expResult = 3;
        double actualResult = intStream.average();
        assertEquals(expResult, actualResult, 0.000001);
    }

    @Test
    public void sumTest() {
        ArrayList<Integer> intArrayList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        AsIntStream intStream = new AsIntStream(intArrayList);
        int expResult = 15;
        int actualResult = intStream.sum();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void minTest() {
        ArrayList<Integer> intArrayList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        AsIntStream intStream = new AsIntStream(intArrayList);
        int expResult = 1;
        int actualResult = intStream.min();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void maxTest() {
        ArrayList<Integer> intArrayList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        AsIntStream intStream = new AsIntStream(intArrayList);
        int expResult = 5;
        int actualResult = intStream.max();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void arrayTest() {
        ArrayList<Integer> intArrayList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        AsIntStream intStream = new AsIntStream(intArrayList);
        int[] expResult = {1, 2, 3, 4, 5};
        int[] actualResult = intStream.toArray();
        assertArrayEquals(expResult, actualResult);
    }
}
