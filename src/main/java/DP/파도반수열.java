package main.java.DP;

import java.util.Scanner;

public class 파도반수열 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int testCaseN=sc.nextInt();
		int [] testCase= new int[testCaseN];
		int maxValue=5;
		
		for(int i=0;i<testCaseN;i++) {
			testCase[i]=sc.nextInt();
			if(testCase[i]>maxValue) maxValue=testCase[i];
		}
		long [] dp= new long[maxValue+1];
		
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;
		dp[5]=2;
		
		for(int i=6;i<=maxValue;i++) {
			dp[i]=dp[i-1]+dp[i-5];
			
		}
		
		for(int i=0;i<testCase.length;i++) {
			System.out.println(dp[testCase[i]]);
		}
		

		

	}


}
