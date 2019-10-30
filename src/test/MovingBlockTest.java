package test;

import main.java.Kakao.LockAndKey;
import main.java.Kakao.MovingBlock;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovingBlockTest {



    @Test
    public void movingBlockTest(){
        MovingBlock test= new MovingBlock();

        int[][] board= new int[][] {
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0},
        };


        int result=test.solution(board);
        assertEquals(7,result);
    }

    @Test
    public void movingBlockTest2(){
        MovingBlock test= new MovingBlock();

        int[][] board= new int[][] {
                {0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0},
        };


        int result=test.solution(board);
        assertEquals(14,result);
    }

    @Test
    public void movingBlockTest3(){
        MovingBlock test= new MovingBlock();

        int[][] board= new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
        };


        int result=test.solution(board);
        assertEquals(11,result);
    }

}
