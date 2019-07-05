package Samseung;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ColorWeakness {
	static char[][] colorArray;
	static int[] dirR= {1,-1,0,0};
	static int[] dirC= {0,0,1,-1};
	static int N;
	
	public static void main(String[] args) {
  Scanner sc= new Scanner(System.in);
	 N=sc.nextInt();
	
	colorArray=new char[N][N];
	for(int i=0;i<N;i++) {
		
		String line=sc.next();
		
		for(int j=0;j<N;j++) {

			colorArray[i][j]=line.charAt(j);
			
		}
	}

	int normalCnt=0;
	int[][] normal= new int[N][N];
	
	for(int i=0;i<N;i++) {
		for(int j=0;j<N;j++) {
			if(normal[i][j]==0) {

				dfs(i,j,normal,++normalCnt,true);
			}
			
		}
	}
	
	
		
	int abnormalCnt=0;
	int [][] abnormal = new int[N][N];
	
	for(int i=0;i<N;i++) {
		for(int j=0;j<N;j++) {
			if(abnormal[i][j]==0) {
				dfs(i,j,abnormal,++abnormalCnt,false);
			}
			
		}
	}
	
	System.out.println(normalCnt+" "+abnormalCnt);
	
	
	}
	
	static void dfs(int sr,int sc,int[][] arr,int cnt,boolean isNormal) {
		Stack<pointC> st= new Stack();
		pointC startP=new pointC(sr,sc);
		arr[sr][sc]=cnt;
		st.push(startP);
		
		while(!st.isEmpty()) {
			pointC crt=st.peek();
			boolean isPushed=false;
			for(int i=0;i<4;i++) {
				int nxtR=crt.r+dirR[i];
				int nxtC=crt.c+dirC[i];
				boolean isSameColr=false;
				
				if(nxtR>=0&&nxtR<N&&nxtC>=0&&nxtC<N&&arr[nxtR][nxtC]==0) {
					char crtColor=colorArray[crt.r][crt.c];
					char nxtColor=colorArray[nxtR][nxtC];
					
					if(crtColor==nxtColor) {
						isSameColr=true;
					}
						
					if(!isNormal) {
					
						if(Math.abs('R'-'G')==Math.abs(crtColor-nxtColor)) {
							isSameColr=true;
						}
						
					}
									
					if(isSameColr) {
						st.push(new pointC(nxtR,nxtC));
						
						arr[nxtR][nxtC]=cnt;
						isPushed=true;
						break;
					}
					
					
					
				}
			
				
			}
			
			if(!isPushed) {
				st.pop();
			}
		}
	}
	
	static void bfs(int sr,int sc,int[][] arr,int cnt,boolean isNormal) {
		Queue<pointC> que= new LinkedList();
		
		pointC startP=new pointC(sr,sc);
		
		arr[sr][sc]=cnt;
		que.offer(startP);

		while(!que.isEmpty()) {
			pointC crt=
			
			for(int i=0;i<4;i++) {
				int nxtR=crt.r+dirR[i];
				int nxtC=crt.c+dirC[i];
				boolean isSameColr=false;
				if(nxtR>=0&&nxtR<N&&nxtC>=0&&nxtC<N&&arr[nxtR][nxtC]==0) {
					char crtColor=colorArray[crt.r][crt.c];
					char nxtColor=colorArray[nxtR][nxtC];
					
					if(crtColor==nxtColor) {
						isSameColr=true;
					}
						
					if(!isNormal) {
					
						if(Math.abs('R'-'G')==Math.abs(crtColor-nxtColor)) {
							isSameColr=true;
						}
						
					}
									
					if(isSameColr) {
						que.offer(new pointC(nxtR,nxtC));
						arr[nxtR][nxtC]=cnt;
					}
				}
			
				
			}
		
			
		}
		
		
	}
	
	
	
}
 class pointC{
	int r;
	int c;
	pointC(int r,int c){
		this.r=r;
		this.c=c;
	}
}