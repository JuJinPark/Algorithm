package test;


import main.java.Kakao.CandidateKeys;
import main.java.Kakao.StageFailRate;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CandiateKeyTest {


    @Test
    public void test() {
        CandidateKeys candidateKeys = new CandidateKeys();
        String[][] relation = {{"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}};
        candidateKeys.solution(relation);

    }


    @Test
    public void test2() {
        CandidateKeys candidateKeys = new CandidateKeys();
        String[][] relation = {{"a", "b", "c"},
                {"1", "e", "2"},
                {"asd", "f", "4"},
                {"d", "g", "9"}};
        int result = candidateKeys.solution(relation);
        assertEquals(1, result);
    }
    @Test
    public void test3() {
        CandidateKeys candidateKeys = new CandidateKeys();
        String[][] relation = {{"ab", "c"},
                {"a", "c"},
                {"x", "yz"},
                {"x", "c"}};
        int result = candidateKeys.solution(relation);
        assertEquals(0, result);
    }

}
