package test;


import main.java.Kakao.LockAndKey;
import main.java.Kakao.StageFailRate;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StageFailRateTest {



    @Test
    public void test(){
        StageFailRate stageFailRate = new StageFailRate();
        int[] result = stageFailRate.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        assertTrue(Arrays.equals(new int[]{3, 4, 2, 1, 5}, result));
    }


    @Test
    public void test2(){
        StageFailRate stageFailRate = new StageFailRate();
        int[] result = stageFailRate.solution(4, new int[]{4,4,4,4,4});
        assertTrue(Arrays.equals(new int[]{4,1,2,3}, result));
    }
}
