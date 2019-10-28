package test;

import main.java.Kakao.Cor;
import main.java.Kakao.LockAndKey;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LockAndKeyTest {



    @Test
    public void lockAndKeyTest(){
        LockAndKey test= new LockAndKey();

        int[][] key= new int[][] {
                {0,0,0},
                {1,0,0},
                {0,1,1}
        };

        int[][] lock= new int[][]{
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        Boolean result=test.solution(key,lock);
        assertEquals(true,result);
    }

    @Test
    public void rotateTest(){
        LockAndKey test= new LockAndKey();
//
//        int[][] key= new int[][] {
//                {0,0,0},
//                {1,0,0},
//                {0,1,1}
//        };


        int[][] key= new int[][] {
                {0,1,0,0,0},
                {0,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,0,0},
                {1,0,0,0,1}
        };

        int[][] lock= new int[][]{
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        test.solution(key,lock);

        for(int i=0;i<4;i++){

            for(int j=0;j<key.length;j++){
                for(int k=0;k<key.length;k++){
                    if(key[j][k]==1){

                    System.out.println(test.rotateClockwise(new Cor(k,j),i));
                    }

                }
            }
            System.out.println("---------------");

        }



//        assertEquals(true,result);
    }
}
