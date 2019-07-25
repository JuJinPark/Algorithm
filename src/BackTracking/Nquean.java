package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Nquean {

	static int[][] chessBoard;
	static int[] newchessBoad;
	static int QuenNum;
	static int nmb;
	static int[] dirR= {-1,1,-1,1,0,1,-1,0};
	static int[] dirC= {-1,1,1,-1,1,0,0,-1};
	static HashSet list =  new HashSet();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		QuenNum=sc.nextInt();
		chessBoard=new int[QuenNum][QuenNum];
	//	System.out.println(QuenNum);
		newchessBoad=new int[QuenNum+1];
		
		
		for(int i=1;i<=QuenNum;i++) {
			for(int j=1;j<=QuenNum;j++) {
				//chessBoard[i][j]=1;
				newchessBoad[i]=j;
				//System.out.println(i+"xf,"+j+"yf,"+0);
				dfs(1,i,j);
			//chessBoard[i][j]=0;
				newchessBoad[i]=0;
				//print();
				
			}
			
		}
		
//		chekcprint(2,2);
//		print();
		System.out.println(list.size());

	}
	
	public static void dfs(int count,int x, int y) {
		
		if(count==QuenNum) {
	//		System.out.println(x+"x,"+y+"y,"+count);
//			//print();
//			print();
//			System.out.println("----");
			//nmb++;
			int canNmb=arrayToNmber();
		//	System.out.println(canNmb);
			
				list.add(canNmb);
		
			return;
		}
		
		for(int i=1;i<=QuenNum;i++) {
			for(int j=1;j<=QuenNum;j++) {
				//System.out.println(i+"i,"+j+"j,"+count);
				if(isPossible(i,j)) {
					//System.out.println(i+","+j+","+count);
					newchessBoad[i]=j;
					//chessBoard[i][j]=1;
					//print();
					//System.out.println("--dd--");
					dfs(count+1,i,j);
					//chessBoard[i][j]=0;
					newchessBoad[i]=0;
				}
				
				
			}
		}
		
	}
	
	private static int arrayToNmber() {
		int result=0;
		for(int i=1;i<newchessBoad.length;i++) {
			result=(result*10)+newchessBoad[i];
		}
		return result;
	}

//	private static boolean isDuplicate(int canNmb) {
//		for(int nmb:list) {
//			if(nmb==canNmb) {
//				return true;
//			}
//			
//		}
//		return false;
//		
//	}

	public static boolean isPossible(int i,int j) {

if(newchessBoad[i]!=j) {
	for(int k=1;k<=QuenNum-1;k++) {
		
		for(int p=0;p<8;p++) {
			int nxti=(dirR[p]*k)+i;
			int nxtj=(dirC[p]*k)+j;	
			
			if(nxti>=1&&nxti<=QuenNum&&nxtj>=1&&nxtj<=QuenNum) {
				
				if(newchessBoad[nxti]==nxtj) {
					return false;
				}
				
			}
			
			
		}
		
		
		
	}
	return true;
}

		return false;
		
		
	}
	
	public static void print() {
		for(int i=0;i<QuenNum;i++) {
			for(int j=0;j<QuenNum;j++) {
		System.out.print(chessBoard[i][j]);
				
			}
			System.out.println();
		}
	}
	
	public static void chekcprint(int i, int j) {
		chessBoard[i][j]=0;
		for(int k=1;k<=QuenNum-1;k++) {
	
		for(int p=0;p<8;p++) {
			int nxti=(dirR[p]*k)+i;
			int nxtj=(dirC[p]*k)+j;	
			if(nxti>=0&&nxti<QuenNum&&nxtj>=0&&nxtj<QuenNum) {
			chessBoard[nxti][nxtj]=k;
			
			}
	}
	}
	}

}
