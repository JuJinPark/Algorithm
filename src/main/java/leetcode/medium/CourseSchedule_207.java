package main.java.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        //초기화
        for (int i = 0; i < numCourses ; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int[] pairs : prerequisites) {
            int targetCourseNum=pairs[0];
            int prerequisitesCourseNum=pairs[1];
            indegree[targetCourseNum]++;
            adjList.get(prerequisitesCourseNum).add(targetCourseNum);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length ; i++) {
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        HashSet<Integer> visited = new HashSet<>();
        while(!queue.isEmpty()){
            Integer course = queue.poll();
            visited.add(course);
            for (Integer adjCourse : adjList.get(course)) {
                indegree[adjCourse]--;
                if( indegree[adjCourse]==0){
                    queue.offer(adjCourse);
                }
            }

        }

        return visited.size()==numCourses;

    }
}
