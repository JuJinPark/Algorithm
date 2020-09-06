package main.java.leetcode.hard;


import java.util.*;

public class ParallelCoursesII {
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        int maxNumberOfCoursePerSemester=k;
        HashMap<Integer, Course> courseList = new HashMap<>();

        for (int i = 1; i <= n; i++) {
                Course course=new Course(i);
                courseList.put(i,course);
        }

        for (int i = 0; i < dependencies.length ; i++) {
            int preCourseNum = dependencies[i][0];
            int targetCourseNum = dependencies[i][1];
            Course preCourse = courseList.get(preCourseNum);
            Course targetCourse = courseList.get(targetCourseNum);
            preCourse.addAdjList(targetCourse);
            targetCourse.increaseInDegreeCount();

        }

        Queue<Course> queue=new PriorityQueue<>(new CourseAdjDesc());

        Iterator<Integer> keys = courseList.keySet().iterator();

        while( keys.hasNext() ){
            Integer courseNum = keys.next();
            Course course = courseList.get(courseNum);
            if(course.isEligible()){
                queue.add(course);
            }
        }

        int semester=0;
        while(!queue.isEmpty()){
            int numberOfCourseCanBeTakenInThisSemester=Math.min(maxNumberOfCoursePerSemester,queue.size());
            ArrayList<Course> finishedCourses = new ArrayList<>();
            for (int i = 0; i <numberOfCourseCanBeTakenInThisSemester ; i++) {
                finishedCourses.add(queue.poll());
            }
            semester++;
            for (Course doneCourse : finishedCourses) {
                List<Course> adjList = doneCourse.getAdjList();
                for (Course course : adjList) {
                    course.reduceInDegreeCount();
                    if(course.isEligible()){
                        queue.add(course);
                    }
                }
            }


        }


        return semester;

    }


}

class Course {
    private int courseNum;
    private int inDegree;
    List<Course> adjList = new ArrayList<>();

    public Course(int courseNum) {
        this.courseNum = courseNum;
    }
    public void increaseInDegreeCount(){
        inDegree++;
    }
    public void addAdjList(Course course) {
        adjList.add(course);
    }

    public boolean isEligible (){
        return inDegree==0;
    }

    public int getAdjListCount(){
        return adjList.size();
    }
    public void reduceInDegreeCount(){
        inDegree--;
    }

    public List<Course> getAdjList() {
        return adjList;
    }
}

class CourseAdjDesc  implements Comparator<Course> {
    public int compare(Course a, Course b)
    {
        return Integer.compare(a.getAdjListCount(),b.getAdjListCount())*-1;
    }
}