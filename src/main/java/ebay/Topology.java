package main.java.ebay;

import java.util.*;

public class Topology {
    public int solution(int[] t,int[][] r,int k){
        HashMap<Integer, Job> jobMap = new HashMap<>();
        for (int i = 0; i < r.length ; i++) {
            int preJobNumberToBeDone = r[i][0];
            Job preJob = jobMap.get(preJobNumberToBeDone);
            if(preJob==null){
                preJob=new Job(preJobNumberToBeDone,t[preJobNumberToBeDone-1]);
                jobMap.put(preJobNumberToBeDone,preJob);
            }
            int jobNum = r[i][1];
            Job job = jobMap.get(jobNum);
            if(job==null){
                job=new Job(jobNum,t[jobNum-1]);
                jobMap.put(jobNum,job);
            }
            preJob.addAdjList(job);
            job.increaseInDegreeCount();
        }

        Queue<Job> queue=new LinkedList<Job>();

        Iterator<Integer> keys = jobMap.keySet().iterator();
        while( keys.hasNext() ){
            Integer jobNum = keys.next();
            Job job = jobMap.get(jobNum);
            if(job.isProcessable()){
                queue.add(job);
            }
        }

        while(!queue.isEmpty()){
            Job currentJob = queue.poll();
            if(currentJob.getJobNum()==k){
                return currentJob.getTotalMaxConsumedTime();
            }
            List<Job> connectedList = currentJob.getAdjList();
            for (Job connectedJob : connectedList) {
                connectedJob.setMaxAccConsumedTime(currentJob.getTotalMaxConsumedTime());
                connectedJob.reduceInDegreeCount();
                if(connectedJob.isProcessable()){
                    queue.add(connectedJob);
                }
            }
        }
        return -1;

    }
}

class Job {
    private int jobNum;
    private int processingTime;
    private int maxAccConsumedTime;
    private int inDegreeCount;
    List<Job> adjList = new ArrayList<>();

    public List<Job> getAdjList() {
        return adjList;
    }

    public Job(int jobNum, int processingTime) {
        this.jobNum = jobNum;
        this.processingTime = processingTime;
    }

    public void setMaxAccConsumedTime(int accConsumedTime){
        if(maxAccConsumedTime<accConsumedTime){
            this.maxAccConsumedTime=accConsumedTime;
        }
    }

    public int getTotalMaxConsumedTime(){
        return processingTime+maxAccConsumedTime;
    }

    public int getJobNum(){
        return jobNum;
    }
    public void reduceInDegreeCount(){
        inDegreeCount--;
    }
    public boolean isProcessable() {
        return inDegreeCount==0;
    }
    public void increaseInDegreeCount(){
        inDegreeCount++;
    }

    public int getInDegreeCount() {
        return inDegreeCount;
    }

    public void addAdjList(Job job) {
        adjList.add(job);
    }
}
