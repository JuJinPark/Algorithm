package main.java.DP;

import java.util.Scanner;

public class 팰린드롬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input=sc.nextLine();
		int length=input.length();
		
		int[][] Dp= new int[length][length];
		
		for(int i=length-1;i>=0;i--) {
			for(int j=i;j<=length-1;j++) {
				int tmp=0;
				if(i==j) {
					
				}else if(input.charAt(i)==input.charAt(j)) {
					tmp=Dp[i+1][j-1];
				}else {
					tmp=Math.min(Dp[i][j-1],Dp[i+1][j])+1;
				}
				
				Dp[i][j]=tmp;
				
			}
		}
		
		System.out.println(Dp[0][length-1]);

	}

}
