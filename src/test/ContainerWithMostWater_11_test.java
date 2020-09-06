package test;

import main.java.leetcode.medium.ContainerWithMostWater_11;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContainerWithMostWater_11_test {
    @Test
    public void test() {
        ContainerWithMostWater_11 solution = new ContainerWithMostWater_11();
        int result = solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        assertEquals(49, result);
    }
}
