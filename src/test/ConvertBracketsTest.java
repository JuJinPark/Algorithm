package test;

import main.java.Kakao.ConvertBrackets;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConvertBracketsTest {

        @Test
        public void bracketsNumber() {
            ConvertBrackets test= new ConvertBrackets();


            assertEquals("()(())()",test.solution("()))((()"));
            assertEquals("()",test.solution(  ")("));
            assertEquals("()(())()",test.solution("()))((()"));


        }


}
