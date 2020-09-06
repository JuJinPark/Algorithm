package test;

import main.java.leetcode.medium.ZigZagConversion_6;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZigZagConversionTest {

    @Test
    public void test(){
        ZigZagConversion_6 zigZagConversion_6 = new ZigZagConversion_6();
        String result = zigZagConversion_6.convert("PAYPALISHIRING", 3);
        assertEquals("PAHNAPLSIIGYIR", result);
    }

    @Test
    public void test2(){
        ZigZagConversion_6 zigZagConversion_6 = new ZigZagConversion_6();
        String result = zigZagConversion_6.convert("PAYPALISHIRING", 4);
        assertEquals("PINALSIGYAHRPI", result);
    }

//    @Test
////    public void test2(){
////        ZigZagConversion_6 zigZagConversion_6 = new ZigZagConversion_6();
////        String result = zigZagConversion_6.convert("PAYPALISHIRING", 4);
////        assertEquals("PINALSIGYAHRPI", result);
////    }
}
