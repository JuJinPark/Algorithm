package Samseung;
import java.util.Scanner;

public class 계단오르기 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int number= sc.nextInt();
		int[] values= new int[number];
		
		for(int i=0;i<number;i++) {
			values[i]=sc.nextInt();
			
		}
		
		int [][] dp= new int [number][2];
		
		dp[0][0]=values[0];
		dp[0][1]=values[0];
		
		dp[1][0]=values[0]+values[1];
		dp[1][1]=values[1];		
		for(int i=2;i<number;i++) {
			dp[i][0]=values[i]+dp[i-1][1];
			dp[i][1]=values[i]+Math.max(dp[i-2][0],dp[i-2][1]);		
			
		}
		
		System.out.println(Math.max(dp[number-1][0],dp[number-1][1]));

	}

}
