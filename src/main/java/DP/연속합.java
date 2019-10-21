package main.java.DP;

import java.util.Scanner;

public class 연속합 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int nmbr=sc.nextInt();
		int[] array= new int[nmbr];
		int[] dp= new int[nmbr];
		
		for(int i=0;i<nmbr;i++) {
			array[i]=sc.nextInt();
		}
		dp[0]=array[0];
		int max=dp[0];
		for(int i=1;i<nmbr;i++) {
			dp[i]=Math.max(array[i],array[i]+dp[i-1]);
			if(dp[i]>max) max=dp[i];
		}
	
		System.out.println(max);

	}

}
