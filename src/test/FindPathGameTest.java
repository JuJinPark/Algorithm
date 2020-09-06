package test;


import main.java.Kakao.FindPathGame;
import main.java.Kakao.StageFailRate;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class FindPathGameTest {



    @Test
    public void test(){
        FindPathGame findPathGame = new FindPathGame();
        int[][] nodeInfo ={{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        int[][] solution = findPathGame.solution(nodeInfo);
        assertTrue(Arrays.equals(new int[][]{{7,4,6,9,1,8,5,2,3},{9,6,5,8,1,4,3,2,7}}, solution));
    }



}
