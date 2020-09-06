package test;

import main.java.ETC.BestAlbumProblem;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BestAlbum_test {
    @Test
    public void test() {

        BestAlbumProblem bestAlbumProblem = new BestAlbumProblem();
        int[] result=bestAlbumProblem.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        assertArrayEquals(new int[]{4, 1, 3, 0}, result);
    }
}
