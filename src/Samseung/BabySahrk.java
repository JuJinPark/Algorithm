package Samseung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BabySahrk {
	static int[][] arr;
	static int[] dirR= {-1,1,-1,1,0,1,-1,0};
	static int[] dirC= {-1,1,1,-1,1,0,0,-1};
	static int N;
	static int M;
	
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	       N =sc.nextInt();
	      M =sc.nextInt();
	      arr=new int[N][M];
		 
	      for(int i=0;i<N;i++) {
	    	  for(int j=0;j<M;j++) {
	    		  arr[i][j]=sc.nextInt();
	    	  }
	      }
		 
		 
		 int maxSafeLength=-1;
		 
		 for(int i=0;i<arr.length;i++) {
			 
			 for(int j=0;j<arr[i].length;j++) {
				 if(arr[i][j]==0) {
					 
					 int length=bfs(i,j);
//							 System.out.println(i+","+j+","+length);
					if(length>maxSafeLength) {
						maxSafeLength=length;
						}
				

				 
				 }
			 }
			
			 
		 }
		 
		 System.out.println(maxSafeLength);
	 }
	 
	 static int bfs(int r,int c) {
		 boolean visted[][] = new boolean[N][M];
		 CorBS startP=new CorBS(r,c,0);

		 Queue<CorBS> que= new LinkedList();
		 que.offer(startP);
		 visted[r][c]=true;
		 
		 while(!que.isEmpty()) {
			 
			 CorBS crt=que.poll();

			 for(int i=0;i<8;i++) {
				 int nxtR=crt.x+dirR[i];
				 int nxtC=crt.y+dirC[i];
				 int nxtD=crt.d+1;
				 
				 if(moveable(nxtR,nxtC,visted)) {
					 if(arr[nxtR][nxtC]==1) {
						 return crt.d+1;
					 }
					 
					 que.offer(new CorBS(nxtR,nxtC,nxtD));
					 visted[nxtR][nxtC]=true;
					 
				 }
				 
			 }
			 
			 
			 
			 
			 
			 
			 
		 }
		 return 0;
	 }
	 
	 static int findDis(int x,int y) {
		 boolean movable=true;

		 int count=0;
		 
		 while(movable) {
			 
			 movable=false;
			 
			 for(int k=0;k<8;k++) {
		int nxtR=x+(dirR[k]*(count+1));
	    int nxtC=y+(dirC[k]*(count+1));	 
				 
				 
			 if(!outOfArray(nxtR,nxtC)) {
				 
				 movable=true;
				 if(arr[nxtR][nxtC]==1) {
					 return count+1;
					 
					
				 }
				 
			 }
			 
			 }
			 
			 
			 count++;
			 
			 
		 }
		 
		 
		 
		 
		 return count;
	 }
	 
	 static boolean moveable(int nxtR,int nxtC,boolean[][] visited) {
		 
		 if(nxtR>=0&&nxtR<N&&nxtC>=0&&nxtC<M&&visited[nxtR][nxtC]==false) {
			 return true;
		 }
		 return false;
	 }
	 
 static boolean outOfArray(int nxtR,int nxtC) {
		 
		 if(nxtR>=0&&nxtR<N&&nxtC>=0&&nxtC<M) {
			 return false;
		 }
		 return true;
	 }
}
class CorBS{
	int x;
	int y;
	int d;
	
	CorBS(int x,int y,int d){
		this.x=x;
		this.y=y;
		this.d=d;
	}
	
}


