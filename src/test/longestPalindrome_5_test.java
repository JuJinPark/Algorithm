package test;

import main.java.leetcode.medium.LogestSubWoRepeatingCharaters_3;
import main.java.leetcode.medium.longestPalindrome_5;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class longestPalindrome_5_test {

    @Test
    public void test() {
        longestPalindrome_5 longestPalindrome_5 = new longestPalindrome_5();
        String result = longestPalindrome_5.longestPalindrome("babad");
        assertEquals("bab", result);
    }

    @Test
    public void test2() {
        longestPalindrome_5 longestPalindrome_5 = new longestPalindrome_5();
        String result = longestPalindrome_5.longestPalindrome("cbbd");
        assertEquals("bb", result);
    }

    @Test
    public void test3() {
        longestPalindrome_5 longestPalindrome_5 = new longestPalindrome_5();
        String result = longestPalindrome_5.longestPalindrome("ccc");
        assertEquals("ccc", result);
    }
    @Test
    public void test4() {
        longestPalindrome_5 longestPalindrome_5 = new longestPalindrome_5();
        String result = longestPalindrome_5.longestPalindrome("abcba");
        assertEquals("abcba", result);
    }
}
