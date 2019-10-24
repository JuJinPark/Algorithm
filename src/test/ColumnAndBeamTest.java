package test;

import main.java.Kakao.ColumnBeam.ColumnAndBeam;
import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.assertArrayEquals;

public class ColumnAndBeamTest {

    @Test
    public void testPriorityQueToArray(){

        ColumnAndBeam test = new ColumnAndBeam();
        int[][] input= new int[][] {
                {0,1,0,1},
                {0,2,0,1},
                {1,1,1,1},
                {1,2,0,1},
                {2,1,1,1},
                {2,2,0,1},
                {5,1,1,1},
                {0,2,0,0},
                {2,1,1,0},
        };

        int[][] arrayTest= test.solution(5,input);

          int[][] expected= new int[][] {
                  {0,1,0},
                  {1,1,1},
                  {1,2,0},
//                  {2,1,1},
                  {2,2,0},
                  {5,1,1},
          };

          for(int i=0;i<arrayTest.length;i++){
              assertArrayEquals(arrayTest[i],expected[i]);
          }






    }

}
