package test;

import main.java.Kakao.ColumnBeam.ColumnAndBeam;
import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ColumnAndBeamTest {

    @Test
    public void testPriorityQueToArray(){

        ColumnAndBeam test = new ColumnAndBeam();
        int[][] input= new int[][] {
                {1,0,0,1},
                {1,1,1,1},
                {2,1,0,1},
                {2,2,1,1},
                {5,0,0,1},
                {5,1,0,1},
                {4,2,1,1},
                {3,2,1,1}

        };

        int[][] result= test.solution(5,input);

          int[][] expected= new int[][] {
                  {1,0,0},
                  {1,1,1},
                  {2,1,0},
                 {2,2,1},
                  {3,2,1},
                  {4,2,1},
                  {5,0,0},
                  {5,1,0},
          };



          for(int i=0;i<result.length;i++){
              assertArrayEquals(expected[i],result[i]);
          }






    }

    @Test
    public void test2(){
        ColumnAndBeam test = new ColumnAndBeam();
        int[][] input= new int[][] {
                {0,0,0,1},
                {2,0,0,1},
                {4,0,0,1},
                {0,1,1,1},
                {1,1,1,1},
                {2,1,1,1},
                {3,1,1,1},
                {2,0,0,0},
                {1,1,1,0},
                {2,2,0,1}

        };

        int[][] result= test.solution(5,input);

        int[][] expected= new int[][] {
                {0,0,0},
                {0,1,1},
                {1,1,1},
                {2,1,1},
                {3,1,1},
                {4,0,0}

        };

        for(int i=0;i<expected.length;i++){
            System.out.println(result[i][0]+","+result[i][1]+","+result[i][2]);
            assertArrayEquals(expected[i],result[i]);
        }



    }


    @Test
    public void test3(){
        ColumnAndBeam test = new ColumnAndBeam();
        int[][] input= new int[][] {
                {1,0,0,1},
                {1,5,0,1},
                {4,5,1,1},
                {1,1,1,1},
                {2,1,0,1},
                {2,2,0,1},
                {1,2,0,1},
                {1,3,1,1},
                {2,3,0,1},
                {0,0,0,1},
                {0,1,0,1},
                {0,2,1,1},
                {1,2,0,1},
                {2,2,0,0},

        };

        int[][] result= test.solution(5,input);

        int[][] expected= new int[][] {
                {0,0,0},
                {0,1,0},
                {0,2,1},
                {1,0,0},
                {1,1,1},
                {1,2,0},
                {1,3,1},
                {2,1,0},
                {2,3,0}

        };


        for(int i=0;i<expected.length;i++){
            System.out.println(result[i][0]+","+result[i][1]+","+result[i][2]);
            assertArrayEquals(expected[i],result[i]);
        }



    }



    @Test
    public void test4(){

        ColumnAndBeam test = new ColumnAndBeam();
        int[][] input= new int[][] {
                {1,0,0,1},
                {1,1,1,1},
                {2,1,0,1},
                {2,2,1,1},
                {5,0,0,1},
                {5,1,0,1},
                {4,2,1,1},
                {3,2,1,1},
                {3,2,1,0},
                {2,2,1,0},
                {2,1,0,0},
                {1,1,1,0},
                {1,0,0,0},
                {4,2,1,0},
                {5,1,0,0},
                {5,0,0,0},


        };

        int[][] result= test.solution(5,input);

//        assertEquals(0,result.length);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i][0]+","+result[i][1]+","+result[i][2]);
        }
          int[][] expected= new int[][]{};
        assertArrayEquals(expected,result);
//
//
//





    }
}
