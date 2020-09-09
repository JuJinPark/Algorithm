package test;

import main.java.leetcode.medium.NumberOfIslands;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfIslandsTest {
    @Test
    public void test(){
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        numberOfIslands.numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}});
    }

}
