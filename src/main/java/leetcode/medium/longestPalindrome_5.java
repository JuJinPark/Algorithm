package main.java.leetcode.medium;

public class longestPalindrome_5 {

    public String longestPalindrome(String s) {
        int[][] dp= new int[s.length()][s.length()];
        char[] chars = s.toCharArray();


        String answer ="";
        for(int i=0;i<s.length();i++){
            dp[i][i]=1;
            if(answer.length()<1){
                answer=s.substring(i,i+1);
            }
        }
        for(int i=0;i<s.length()-1;i++){
            if(chars[i]==chars[i+1]){
                dp[i][i+1]=1;
                if(answer.length()<2){
                    answer=s.substring(i,i+2);
                }

            }
        }

        for (int i = 3; i <= s.length() ; i++) {
            for (int j = 0; j <= s.length()-i ; j++) {
                int idxToCompare=j+i-1;
                if(chars[j]==chars[idxToCompare]&&dp[j+1][idxToCompare-1]==1){
                    dp[j][idxToCompare]=1;
                    if(answer.length()<i){
                        answer=s.substring(j,idxToCompare+1);
                    }
                }
            }
        }


        return answer;




    }

}
