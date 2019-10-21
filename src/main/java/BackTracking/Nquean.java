package main.java.BackTracking;

import java.util.Scanner;

public class Nquean {


	static int[] newchessBoad;
	static int QuenNum;
	static int nmb;

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		QuenNum=sc.nextInt();
		

		newchessBoad=new int[QuenNum];
		
	
		dfs(0);

		System.out.println(nmb);

	}
	
	public static void dfs(int rowNum) {
		
		if(rowNum==QuenNum) {
			nmb++;
	
		
			return;
		}
		
		for(int i=1;i<=QuenNum;i++) {
			newchessBoad[rowNum]=i;
			
				if(isPossible(rowNum)) {
				
					
		
					dfs(rowNum+1);
		
				
				}
				
		
		}
		
	}


	public static boolean isPossible(int rowNum) {

		for(int i=0;i<rowNum;i++)
		{
			if(newchessBoad[i]==newchessBoad[rowNum]) {
				return false;
			}
			if(rowNum-i==Math.abs(newchessBoad[i]-newchessBoad[rowNum])) {
				return false;
			}
			
			
		}
		return true;
		
	}
	


}
