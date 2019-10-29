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
        assertEquals(15,result);
    }

//    @Test
//    public void rotateTest(){
//        LockAndKey test= new LockAndKey();
////
////        int[][] key= new int[][] {
////                {0,0,0},
////                {1,0,0},
////                {0,1,1}
////        };
//
//
//        int[][] key= new int[][] {
//                {0,1,0,0,0},
//                {0,1,0,0,0},
//                {0,0,1,0,0},
//                {0,0,0,0,0},
//                {1,0,0,0,1}
//        };
//
//        int[][] lock= new int[][]{
//                {1,1,1},
//                {1,1,0},
//                {1,0,1}
//        };
//        test.solution(key,lock);
//
//        for(int i=0;i<4;i++){
//
//            for(int j=0;j<key.length;j++){
//                for(int k=0;k<key.length;k++){
//                    if(key[j][k]==1){
//
//                    System.out.println(test.rotateClockwise(new Cor(k,j),i));
//                    }
//
//                }
//            }
//            System.out.println("---------------");
//
//        }
//
//
//
////        assertEquals(true,result);
//    }
}
