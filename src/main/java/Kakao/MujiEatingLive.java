package main.java.Kakao;

import java.util.*;

public class MujiEatingLive {
    public int solution(int[] food_times, long k) {

        int total=0;
        List<Food> foodList = new ArrayList<>();


        for (int i = 1; i <= food_times.length ; i++) {
            total+=food_times[i-1];
            foodList.add(new Food(i,food_times[i-1]));
        }

//        if(k>=total){
//            return -1;
//        }
        // 이걸 주석처리하고 왜 효율성이 더 좋아지는건지??


        Collections.sort(foodList, new FoodTimeAscending());
        int i=0;
        int currentSize=foodList.size();
        int accMinusTime=0;
        for (Food food :foodList){
            int eatableTime=currentSize*(food.getTime()-accMinusTime);
            if(eatableTime!=0){
                if(eatableTime<=k){
                    k=k-eatableTime;
                    accMinusTime+=food.getTime()-accMinusTime;
                }else{
                    long idx = k % currentSize;
                    List<Food> leftOver=foodList.subList(i, foodList.size());
                    Collections.sort(leftOver, new IdxAscending());
                    return leftOver.get((int)idx).getIdx();

                }
            }

            currentSize--;
            i++;
        }
        return -1;
    }


}

class Food{
    private int idx;
    private int time;

    public Food(int idx, int time) {
        this.idx = idx;
        this.time = time;
    }

    public int getIdx() {
        return idx;
    }

    public int getTime() {
        return time;
    }
}

class FoodTimeAscending  implements Comparator<Food> {
    public int compare(Food a, Food b)
    {
        return Integer.compare(a.getTime(),b.getTime());
    }
}

class IdxAscending  implements Comparator<Food> {
    public int compare(Food a, Food b)
    {
        return Integer.compare(a.getIdx(),b.getIdx());
    }
}