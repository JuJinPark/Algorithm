package test;

import main.java.leetcode.hard.MedianofTwoSortedArrays_4;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MedianOfTwoSortedArraysTest {

    @Test
    public void test(){
        MedianofTwoSortedArrays_4 medianofTwoSortedArrays_4 = new MedianofTwoSortedArrays_4();
        double result = medianofTwoSortedArrays_4.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        assertEquals(2.00000, result);
    }

    @Test
    public void test2(){
        MedianofTwoSortedArrays_4 medianofTwoSortedArrays_4 = new MedianofTwoSortedArrays_4();
        double result = medianofTwoSortedArrays_4.findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4});
        assertEquals(2.50000, result);
    }

    @Test
    public void test3(){
        MedianofTwoSortedArrays_4 medianofTwoSortedArrays_4 = new MedianofTwoSortedArrays_4();
        double result = medianofTwoSortedArrays_4.findMedianSortedArrays(new int[]{2}, new int[]{});
        assertEquals(2, result);
    }

    @Test
    public void test4(){
        MedianofTwoSortedArrays_4 medianofTwoSortedArrays_4 = new MedianofTwoSortedArrays_4();
        double result = medianofTwoSortedArrays_4.findMedianSortedArrays(new int[]{1}, new int[]{1});
        assertEquals(2, result);
    }
    @Test
    public void test5(){
        MedianofTwoSortedArrays_4 medianofTwoSortedArrays_4 = new MedianofTwoSortedArrays_4();
        double result = medianofTwoSortedArrays_4.findMedianSortedArrays(new int[]{3,4}, new int[]{1,2});
        assertEquals(2, result);
    }
}
