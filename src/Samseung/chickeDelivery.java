package Samseung;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class chickeDelivery {
static int N;
static int M;
static int[] houseRow;
static int[] houseCol;
static int[] chickenRow;
static int[] chickenCol;
static int houseIdx;
static int chickenIdx;

	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		houseRow=new int[100];
		houseCol=new int[100];
		chickenRow=new int[100];
		chickenCol=new int[100];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int input=sc.nextInt();
				if(input==1) {
					houseRow[houseIdx]=i;
					houseCol[houseIdx]=j;
						houseIdx++;
				}else if(input==2) {
					chickenRow[chickenIdx]=i;
					chickenCol[chickenIdx]=j;
					chickenIdx++;
				}
			}
		}
		//System.out.println(Arrays.toString(houseRow));
		//System.out.println(Arrays.toString(houseCol));
		//System.out.println(Arrays.toString(chickenRow));
		//System.out.println(Arrays.toString(chickenCol));
		
		int rslt=Integer.MAX_VALUE;
//		System.out.println(chickenIdx);
//		System.out.println(houseIdx);
		for(int i=0;i < 1 << chickenIdx;i++) {
			
		
			if(countBits(i)==M) {
				int sum=0;
//				System.out.println(i);
				for(int j=0;j<houseIdx;j++) {
					int clstDistc=Integer.MAX_VALUE;
//					System.out.println(j);
					for(int k=0;k<chickenIdx;k++) {
						
						if((i & (1 << k))!=0) {
							
							int distance=Math.abs(chickenRow[k]-houseRow[j])+Math.abs(chickenCol[k]-houseCol[j]);
							
								//				System.out.println(k);	
							clstDistc=Math.min(distance,clstDistc);
							
						}
						
						
					
					}
					
					//System.out.println(sum+"-"+j);
					
					sum+=clstDistc;
					
				}
				rslt=Math.min(rslt, sum);
				
				
			}
			
			
			
			//System.out.println(rslt+"-+");
		}
		
		
		System.out.println(rslt);

	}
	
	public static int countBits(int number) {
		int count=0;
		
		while(number>0) {
			
			if((number & 1)==1) {
				count++;
			}
			number =number >> 1;
		}
		
		return count;
	}

}
