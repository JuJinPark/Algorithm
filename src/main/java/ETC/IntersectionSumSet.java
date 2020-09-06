package main.java.ETC;

import org.apache.commons.lang.RandomStringUtils;

import java.util.Arrays;

public class IntersectionSumSet {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[] {4,3,2,2,1,7,8},new int[] {5,12,4,7,6,6,5});
    }
}

class Solution {

    public void solution(int[] ...arrays) {

        int[] result = new int[100];

        for (int i = 0; i < arrays.length; i++) {
            int[] targetArray= arrays[i];
            for (int i1 : targetArray) {
                if(result[i1]<=i){
                    result[i1]+=1;
                }
            }


        }

        System.out.println( Arrays.toString(result));
        printResult(result,arrays.length);


    }

    public void printResult(int[] result,int length){
        String sum="";
        String set="";
        String difference="";
        for (int i = 0; i < result.length; i++) {

            if (result[i] > 0) {
                sum += "," + i;
            }

            if (result[i] == length) {
                set += "," + i;
            }

            if (result[i] == 1) {
                difference += "," + i;
            }
        }

        System.out.println("합집합");
        System.out.println(sum);
        System.out.println("교집합");
        System.out.println(set);
        System.out.println("차집합");
        System.out.println(difference);
    }
}