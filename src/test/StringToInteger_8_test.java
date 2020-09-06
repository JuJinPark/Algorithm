package test;

import main.java.leetcode.medium.StringToInteger_8;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringToInteger_8_test {

    @Test
    public void test(){
        StringToInteger_8 atoi = new StringToInteger_8();
        int result = atoi.myAtoi("42");
        assertEquals(42, result);
    }

    @Test
    public void test2(){
        StringToInteger_8 atoi = new StringToInteger_8();
        int result = atoi.myAtoi("   -42");
        assertEquals(-42, result);
    }

    @Test
    public void test3(){
        StringToInteger_8 atoi = new StringToInteger_8();
        int result = atoi.myAtoi("4193 with words");
        assertEquals(4193, result);
    }
    @Test
    public void test4(){
        StringToInteger_8 atoi = new StringToInteger_8();
        int result = atoi.myAtoi("words and 987");
        assertEquals(0, result);
    }
    @Test
    public void test5(){
        StringToInteger_8 atoi = new StringToInteger_8();
        int result = atoi.myAtoi("-91283472332");
        assertEquals(-2147483648, result);
    }

    @Test
    public void test6(){
        StringToInteger_8 atoi = new StringToInteger_8();
        int result = atoi.myAtoi("-");
        assertEquals(0, result);
    }

    @Test
    public void test7(){
        StringToInteger_8 atoi = new StringToInteger_8();
        int result = atoi.myAtoi("+-2");
        assertEquals(0, result);
    }

    @Test
    public void test8(){
        StringToInteger_8 atoi = new StringToInteger_8();
        int result = atoi.myAtoi("+2");
        assertEquals(2, result);
    }
    @Test
    public void test9(){
        StringToInteger_8 atoi = new StringToInteger_8();
        int result = atoi.myAtoi("+");
        assertEquals(0, result);
    }

    @Test
    public void test10(){
        StringToInteger_8 atoi = new StringToInteger_8();
        int result = atoi.myAtoi("   +0 123");
        assertEquals(0, result);
    }
    @Test
    public void test11(){
        StringToInteger_8 atoi = new StringToInteger_8();
        int result = atoi.myAtoi("   + 0 123");
        assertEquals(0, result);
    }

    @Test
    public void test12(){
        StringToInteger_8 atoi = new StringToInteger_8();
        int result = atoi.myAtoi("-2147483649");
        assertEquals(-2147483648, result);
    }

    @Test
    public void test13(){
        StringToInteger_8 atoi = new StringToInteger_8();
        int result = atoi.myAtoi("2147483648");
        assertEquals(2147483647, result);
    }
}
