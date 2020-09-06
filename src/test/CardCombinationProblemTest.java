package test;

import main.java.ebay.CardCombinationProblem;
import main.java.ebay.ProductProblem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardCombinationProblemTest {


    @Test
    public void test() {
        CardCombinationProblem solution = new CardCombinationProblem();
        int n = 8;
        int[] cards = {1,4,6};
        int solution1 = solution.solution(n, cards);
        assertEquals(2, solution1);
    }

    @Test
    public void test2() {
        CardCombinationProblem solution = new CardCombinationProblem();
        int n = 18;
        int[] cards = {1,2,5};
        int solution1 = solution.solution(n, cards);
        assertEquals(5, solution1);
    }

    @Test
    public void test3() {
        CardCombinationProblem solution = new CardCombinationProblem();
        int n = 5;
        int[] cards = {12,14,15};
        int solution1 = solution.solution(n, cards);
        assertEquals(-1, solution1);
    }

    @Test
    public void test4() {
        CardCombinationProblem solution = new CardCombinationProblem();
        int n = 23;
        int[] cards = {12,14,15};
        int solution1 = solution.solution(n, cards);
        assertEquals(-1, solution1);
    }
}
