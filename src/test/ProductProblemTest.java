package test;

import main.java.ebay.ProductProblem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductProblemTest {

    @Test
    public void test() {
        ProductProblem solution = new ProductProblem();
        int n = 2;
        int[][] products = {{10,3,2},{15,2,5}};
        long solution1 = solution.solution(n, products);
        assertEquals(48, solution1);
    }

    @Test
    public void test2() {
        ProductProblem solution = new ProductProblem();
        int n = 3;
        int[][] products = {{6,5,1},{11,3,2},{7,10,3}};
        long solution1 = solution.solution(n, products);
        assertEquals(120, solution1);
    }
}
