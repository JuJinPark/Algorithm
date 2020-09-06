package main.java.Kakao;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.Arrays;
import java.util.PriorityQueue;

public class StageFailRate {

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] failedPlayersPerStage= new int[N+2];
        int[] totalPlayedPlayersPerStage = new int[N+2];
        PriorityQueue<Stage> priorityQueue = new PriorityQueue<Stage>();

        for(int i=0;i<stages.length;i++){
            int stageNumber=stages[i];
            failedPlayersPerStage[stageNumber]++;

        }


        for(int i=failedPlayersPerStage.length-1;i>=1;i--){
            if(i==N+1){
                totalPlayedPlayersPerStage[i]=failedPlayersPerStage[i];
                continue;
            }
            int stageNumber=i;
            int failedPlayers=failedPlayersPerStage[i];
            totalPlayedPlayersPerStage[i]=totalPlayedPlayersPerStage[i+1]+failedPlayers;
            int triedPlayers=totalPlayedPlayersPerStage[i];

            Stage stage = new Stage(stageNumber, triedPlayers, failedPlayers);
            priorityQueue.offer(stage);
        }

        int idx=0;
        while(!priorityQueue.isEmpty()){
            Stage stage = priorityQueue.poll();
            answer[idx]=stage.getStageNumber();
            idx++;
        }
        return answer;
    }



}


class Stage implements Comparable<Stage> {
   private int stageNumber;
    private double stageFailure;


    public Stage(int stageNumber,int totalTriedPlayers,int totalFailedPlayers) {
        this.stageNumber = stageNumber;
        if(totalTriedPlayers==0){
            this.stageFailure=(double)0;
            return;
        }
        this.stageFailure= (totalFailedPlayers/(double)totalTriedPlayers);
    }

    public int getStageNumber() {
        return stageNumber;
    }

    public double getStageFailure() {
        return stageFailure;
    }

    @Override
    public int compareTo(Stage target) {

        int compare = Double.compare(target.getStageFailure(), this.stageFailure);
        if(compare==0){
            return Integer.compare(target.getStageNumber(),this.stageNumber)*-1;
        }
            return compare;

    }
}