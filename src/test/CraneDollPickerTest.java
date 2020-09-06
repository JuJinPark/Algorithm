package test;

import main.java.Kakao.ConvertBrackets;
import main.java.Kakao.CraneDollPicker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CraneDollPickerTest {


    @Test
    public void bracketsNumber() {
        CraneDollPicker test= new CraneDollPicker();


        assertEquals(4,test.solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}},new int[]{1,5,3,5,1,2,1,4}));



    }
}
