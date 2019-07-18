package Samseung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TreeInvestment {
	
	static int n;
	static int m;
	static int k;
	
	static int[][] board;
	
	static int[][] nutrition;
	
	static int[] dirR= {-1,1,-1,1,0,1,-1,0};
	static int[] dirC= {-1,1,1,-1,1,0,0,-1};

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub

	//	staic 현재양분
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		k=sc.nextInt();
		
		board = new int[n][n];
		initBoard();
		nutrition = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				nutrition[i][j]=sc.nextInt();
			}
		}
		
		
		//initNutrition();
		
		
		
	
		
		PriorityQueue<Treei> treelist= new PriorityQueue(new TreeiComparator());
		
		for(int i=0;i<m;i++) {
			int r=sc.nextInt()-1;
			int c=sc.nextInt()-1;
			int year=sc.nextInt();
			treelist.add(new Treei(r,c,year));
			
		}

		
	
		for(int i=0;i<k;i++) {
			PriorityQueue<Treei> growntree= new PriorityQueue(new TreeiComparator());
			List<Treei> growableTree = new ArrayList();
			List<Treei> diedtree = new ArrayList();
			
			
			
			spring(treelist,growntree,growableTree,diedtree);
			summer(diedtree);
			autumn(growableTree,growntree);
			winter();
			
			
			treelist=growntree;
		}
	
	
		System.out.println(treelist.size());
		
		while(!treelist.isEmpty()) {
			System.out.println(treelist.poll());
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				
						System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}

	
	}
	
	public static void initBoard() {
		for(int i=0;i<n;i++) {
			Arrays.fill(board[i],5);
		}
	

	}
	

	
	public static void spring(PriorityQueue<Treei> treelist,PriorityQueue<Treei> growntree,List<Treei> growableTree,List<Treei> diedtree){
		while(!treelist.isEmpty()) {
			Treei crtTreei=treelist.poll();
			
			
			
			if(board[crtTreei.r][crtTreei.c]<crtTreei.year) {
				//board[crtTreei.r][crtTreei.c]=0;
				diedtree.add(crtTreei);
				//continue;
			}else {
				board[crtTreei.r][crtTreei.c]=board[crtTreei.r][crtTreei.c]-crtTreei.year;
				crtTreei.year=crtTreei.year+1;
				growntree.add(crtTreei);
				if(crtTreei.year%5==0) {
					growableTree.add(crtTreei);
				}
			}
		

	}
		

		
	}
	
	public static void summer(List<Treei> diedtree){
		for(Treei tree:diedtree) {
			board[tree.r][tree.c]+=tree.year/2;
		}

		
	}
	public static void autumn(List<Treei> growableTree,PriorityQueue<Treei> growntree){
		for(Treei tree:growableTree) {
			int crtr=tree.r;
			int crtc=tree.c;
	
			for(int i=0;i<dirR.length;i++) {
				int nxtr=crtr+dirR[i];
				int nxtc=crtc+dirC[i];
				
				
				if(!isOutOfArray(nxtr,nxtc)) {
					growntree.add(new Treei(nxtr,nxtc,1));
				}
				
			}
			
			
		}

		
		
	}
	public static boolean isOutOfArray(int r,int c) {
		 if(r>=0&&r<n&&c>=0&&c<n) {
			 return false;
		 }
		 return true;
	}

	public static void winter(){
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j]+=nutrition[i][j];
			}
		}
				

		
	}

	
	
	
	
	
}
class TreeiComparator implements Comparator<Treei>{

	
	public int compare(Treei o1, Treei o2) {

		return o1.year-o2.year;
		
	}
	
}
class Treei{
	int r;
	int c;
	int year;
	
	Treei(int r,int c, int year){
		this.r=r;
		this.c=c;
		this.year=year;
	}
	
	public String toString() {
		return r+","+c+","+year;
		
	}
	
	// 나이 좌표 
}