package test;


import main.java.Kakao.MujiEatingLive;
import main.java.Kakao.StageFailRate;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MujiEatingLiveTest {



    @Test
    public void test(){
        MujiEatingLive sol = new MujiEatingLive();
        int result = sol.solution(new int[]{3, 1, 2},6 );
        assertEquals(1  ,result);
    }


    @Test
    public void test2(){
        MujiEatingLive sol = new MujiEatingLive();
        int result = sol.solution(new int[]{7,5,4,2,9},45);
        assertEquals(5  ,result);
    }

    @Test
    public void test3(){
        MujiEatingLive sol = new MujiEatingLive();
        int result = sol.solution(new int[]{3,1,1,1,2,4,3},12);
        assertEquals(6  ,result);
    }
}
