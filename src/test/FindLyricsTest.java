package test;

import main.java.Kakao.FindLyrics;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FindLyricsTest {
    @Test
    public void matchingNumber() {
        FindLyrics test= new FindLyrics();


        assertArrayEquals(new int[]{3,2,4,1,0,1,1,2,0,1,1,1},test.solution(new String[] {
                "frodo",
                "front",
                "frost",
                "frozen",
                "frame",
                "kakao",
                "s",
                "apartmentgameisgoodverygood"
                },
                new String[]{
                     "fro??",
                        "????o",
                        "fr???",
                        "fro???",
                        "pro?",
                        "??????",
                        "?",
                        "????t",
                        "kakao?",
                        "kaka?",
                        "froze?",
                        "fros?"
                }
                ));



    }
}
