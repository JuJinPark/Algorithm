package main.java.ebay;

public class CardCombinationProblem {

    public int solution(int num,int[] cards){
        int[] dp = new int[num+1];

        for (int i = 1; i <= num; i++) {
            int minCombination=Integer.MAX_VALUE;
            for (int card : cards) {
                if(card <=i){
                    int currentCombinationCount = findCombinationCount(dp, i, card);
                    if(currentCombinationCount<minCombination){
                        minCombination=currentCombinationCount;
                    }
                }
            }
            dp[i]=minCombination;
        }

        if(dp[num]==Integer.MAX_VALUE || dp[num]==0){
            return -1;
        }
        return dp[num];
    }

    private int findCombinationCount(int[] dp, int targetNum, int cardNum){
        int restNum = targetNum - cardNum;
        if(restNum==0){
            return 1;
        }

        int minimumCount=dp[restNum];
        if (minimumCount==Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }

        return minimumCount+1;

    }
}
