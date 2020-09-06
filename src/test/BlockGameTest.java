package test;

import main.java.Kakao.BlockGame;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlockGameTest {

    @Test
    public void test() {
        BlockGame blockGame = new BlockGame();
        int[][] board = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,4,0,0,0},{0,0,0,0,0,4,4,0,0,0},{0,0,0,0,3,0,4,0,0,0},{0,0,0,2,3,0,0,0,5,5},{1,2,2,2,3,3,0,0,0,5},{1,1,1,0,0,0,0,0,0,5}};
        int result = blockGame.solution(board);
        assertEquals(2, result);
    }
}
