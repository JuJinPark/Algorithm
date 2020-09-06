package test;

import main.java.ebay.ServiceDeskProblem;
import main.java.leetcode.medium.StringToInteger_8;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ServiceDeskProblemTest {
    @Test
    public void test10(){
        ServiceDeskProblem problem = new ServiceDeskProblem();
        int result=problem.solution(2, new int[][]{{0,3},{2,5},{4,2},{5,3}});
        assertEquals(1, result);
    }

    @Test
    public void test2(){
        ServiceDeskProblem problem = new ServiceDeskProblem();
        int result=problem.solution(1, new int[][]{{2,3},{5,4},{6,3},{7,4}});
        assertEquals(8, result);
    }
}
