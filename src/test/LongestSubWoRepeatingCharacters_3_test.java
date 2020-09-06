package test;

import main.java.leetcode.medium.LogestSubWoRepeatingCharaters_3;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestSubWoRepeatingCharacters_3_test {
    @Test
    public void test() {
        LogestSubWoRepeatingCharaters_3 solution = new LogestSubWoRepeatingCharaters_3();

        int result = solution.lengthOfLongestSubstring("abcabcbb");
        assertEquals(3, result);
    }
    @Test
    public void test2() {
        LogestSubWoRepeatingCharaters_3 solution = new LogestSubWoRepeatingCharaters_3();

        int result = solution.lengthOfLongestSubstring("bbbbb");
        assertEquals(1, result);
    }
    @Test
    public void test3() {
        LogestSubWoRepeatingCharaters_3 solution = new LogestSubWoRepeatingCharaters_3();

        int result = solution.lengthOfLongestSubstring("pwwkew");
        assertEquals(3, result);
    }

    @Test
    public void test4() {
        LogestSubWoRepeatingCharaters_3 solution = new LogestSubWoRepeatingCharaters_3();

        int result = solution.lengthOfLongestSubstring("   ");
        assertEquals(1, result);
    }

    @Test
    public void test5() {
        LogestSubWoRepeatingCharaters_3 solution = new LogestSubWoRepeatingCharaters_3();

        int result = solution.lengthOfLongestSubstring("abba");
        assertEquals(2, result);
    }
}
