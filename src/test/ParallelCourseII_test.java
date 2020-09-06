package test;

import main.java.leetcode.hard.ParallelCoursesII;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParallelCourseII_test {

    @Test
    public void test(){
        ParallelCoursesII course = new ParallelCoursesII();
        int result = course.minNumberOfSemesters(4
                , new int[][]{{2,1}, {3,1}, {1, 4}}
                , 2);
        assertEquals(result,3);
    }

    @Test
    public void test2(){
        ParallelCoursesII course = new ParallelCoursesII();
        int result = course.minNumberOfSemesters(5
                , new int[][]{{2,1}, {3,1}, {4, 1},{1,5}}
                , 2);
        assertEquals(result,4);
    }

    @Test
    public void test3(){
        ParallelCoursesII course = new ParallelCoursesII();
        int result = course.minNumberOfSemesters(11
                , new int[][]{}
                , 2);
        assertEquals(result,6);
    }
}
