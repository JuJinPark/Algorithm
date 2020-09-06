package test;

import main.java.leetcode.medium.IntegerToRoman_12;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class IntegerToRoman_test {
    @Test
    public void test() {
        IntegerToRoman_12 solution = new IntegerToRoman_12();
        String result = solution.intToRoman(1994);
        assertEquals(result,"MCMXCIV");
    }

    @Test
    public void test2() {
        IntegerToRoman_12 solution = new IntegerToRoman_12();
        String result = solution.intToRoman(3);
        assertEquals(result,"III");
    }
}
