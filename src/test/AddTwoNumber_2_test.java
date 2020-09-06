package test;

import main.java.leetcode.medium.AddTwoNumber_2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddTwoNumber_2_test {
    @Test
    public void test() {
        AddTwoNumber_2 solution = new AddTwoNumber_2();

        String result = solution.testSolution(new int[]{2, 4, 3}, new int[]{5, 6, 4});
        assertEquals("708", result);
    }

    @Test
    public void test2() {
        AddTwoNumber_2 solution = new AddTwoNumber_2();

        String result = solution.testSolution(new int[]{9}, new int[]{1,9,9,9,9,9,9,9,9,9});
        System.out.println(result);
        assertEquals("00000000001", result);
//        assertEqualsquals(10000000000, result);
    }
}
