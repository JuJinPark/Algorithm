package test;

import main.java.Kakao.FindPathGame;
import main.java.ebay.Topology;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class topology_test {

    @Test
    public void test(){
        Topology topology = new Topology();
        int result = topology.solution(new int[]{5, 8, 3, 7, 10, 5, 4}
                , new int[][]{{1, 2}, {2, 4}, {1, 4}, {6, 5}, {3, 5}, {4, 6}}
                , 5);
        assertEquals(result,35);
    }

    @Test
    public void test2(){
        Topology topology = new Topology();
        int result = topology.solution(new int[]{3,3,5,4,2,2,7,2}
                , new int[][]{{1,4},{1,3},{2,5},{2,7},{4,6},{4,7},{7,8},{6,7}}
                , 7);
        assertEquals(result,16);
    }

}
