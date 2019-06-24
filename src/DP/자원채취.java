package DP;

import java.util.Scanner;

public class 자원채취 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		
		int[][] board= new int[n][m];
		
for(int i=0;i<n;i++) {
			
			for(int j=0;j<m;j++) {
				
				board[i][j]=sc.nextInt();
				
				
			}
			
		}
		
		for(int i=1;i<m;i++) {
			board[0][i]=board[0][i-1]+board[0][i];
		}
		
for(int i=1;i<n;i++) {
	board[i][0]=board[i-1][0]+board[i][0];
		}
		
		int max=Integer.MIN_VALUE;
		
		
		
		
		for(int i=1;i<n;i++) {
			
			for(int j=1;j<m;j++) {
				
				board[i][j]=Math.max(board[i-1][j],board[i][j-1])+board[i][j];
				
				
				if(board[i][j]>max) {
					max=board[i][j];
				}
			}
			
		}
		 System.out.println(max);
	}


}
