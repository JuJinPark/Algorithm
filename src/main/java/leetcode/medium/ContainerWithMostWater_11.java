package main.java.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        List<Container> containers = new ArrayList<>();
        HashSet<Integer> heights = new HashSet<>();
        for (int i = 0; i < height.length; i++) {
            containers.add(new Container(i,height[i]));
            heights.add(height[i]);
        }

        List<Integer> heightList = new ArrayList<Integer>(heights);
        Collections.sort(heightList, Collections.reverseOrder());
        Collections.sort(containers,new ContainerHeightDesc());



        int maxValue=0;

        for (Integer heightToFind : heightList) {
            if(maxValue>heightToFind*containers.size()){
                break;
            }
            List<Integer> idxList = findIdxToCompare(containers, heightToFind);

            for (Integer idxToCompare : idxList) {
                if(idxToCompare==0){
                   continue;
                }
                Container containerToCompare = containers.get(idxToCompare);
                for (int i = idxToCompare-1; i >=0; i--) {
                    Container tempContainer = containers.get(i);
                    int tempDistance=Math.abs(tempContainer.getLocation()-containerToCompare.getLocation());
                    int tempMaxValue= tempDistance*heightToFind;
                    if(tempMaxValue>maxValue){
                        maxValue=tempMaxValue;
                    }

                }

            }


        }


        return maxValue;

    }


    private List<Integer> findIdxToCompare(List<Container> containers,int maxHeightToFind){
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i <containers.size() ; i++) {
            Container container = containers.get(i);
            if(container.getHeight()<maxHeightToFind){
                break;
            }

            if(container.getHeight()==maxHeightToFind){
                integers.add(i);
            }

        }

        return integers;
    }
}
class Container{
    private int location;

    private int height;

    public Container(int location, int height) {
        this.location = location;
        this.height = height;
    }

    public int getLocation() {
        return location;
    }

    public int getHeight() {
        return height;
    }
}

class ContainerHeightDesc implements Comparator<Container> {
    public int compare(Container a, Container b)
    {
        return Integer.compare(a.getHeight(),b.getHeight())*-1;
    }
}
