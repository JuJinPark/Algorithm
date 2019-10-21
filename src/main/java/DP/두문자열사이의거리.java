package main.java.DP;

import java.util.Scanner;

public class 두문자열사이의거리 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input1=sc.next();
		String input2=sc.next();
		
		int dp[][]= new int[input2.length()+1][input1.length()+1];
		
		for(int i=0;i<=input1.length();i++) {
			dp[0][i]=i;
		}
		
		for(int i=0;i<=input2.length();i++) {
			dp[i][0]=i;
		}
		
		for(int i=1;i<=input2.length();i++) {
			for(int j=1;j<=input1.length();j++) {
				int tmp=0;
			 if(input2.charAt(i-1)==input1.charAt(j-1)) {
				 tmp=dp[i-1][j-1];
			 }else {
				 
				 tmp=Math.min(dp[i-1][j],dp[i][j-1])+1;
			 }
				
			 dp[i][j]=tmp;
			}
			
		}
			
			
			System.out.println(dp[input1.length()][input2.length()]);

	}

}
