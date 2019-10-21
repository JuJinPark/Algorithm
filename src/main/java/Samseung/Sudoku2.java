package main.java.Samseung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Sudoku2 {
	
	static int[][] board = new int[9][9];
	static boolean[][] numbersinRow  = new boolean [9][10];
	static boolean[][] numbersinCol  = new boolean [9][10];
	static boolean[][] numbersinSquare  = new boolean [9][10];
	static ArrayList<SudokuCor> list = new ArrayList();


	public static void main(String[] args) throws IOException {
	
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

		for(int i=0;i<9;i++) {
			String line=reader.readLine();
			for(int j=0;j<9;j++) {
				int nmb=line.charAt(j)-'0';
				
				if(nmb==0) {
					list.add(new SudokuCor(i,j));
				}else {
					numbersinRow[i][nmb]=true;
					numbersinCol[j][nmb]=true;
					numbersinSquare[((i/3)*3)+(j/3)][nmb]=true;
					
				}
				board[i][j]=nmb;
				
			}
		}
		
		dfs(0);
		print();
		
		

	}
	
	public static void print() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(board[i][j]+"");
			}
			
				System.out.println();
			
			
		}
	}
	


	public static boolean dfs(int idx) {
		

		if(list.size()==idx) {
			return true;
			
		}
		
		
		int row=list.get(idx).row;
		int col=list.get(idx).col;
			
			for(int j=1;j<=9;j++) {

					if(isPossibleInRow(row,j)) continue;
					if(isPossibleIncol(col,j)) continue;
					if(isPossibleInSquare(((row/3)*3)+(col/3),j)) continue;
					
					numbersinRow[row][j]=true;
					numbersinCol[col][j]=true;
					numbersinSquare[((row/3)*3)+(col/3)][j]=true;
					board[row][col]=j;
					
					if(dfs(idx+1)) return true;
					numbersinRow[row][j]=false;
					numbersinCol[col][j]=false;
					numbersinSquare[((row/3)*3)+(col/3)][j]=false;
					board[row][col]=0;
					
			
	
					

		
	
	}
			return false;
			
	}

	private static boolean isPossibleInSquare(int area, int nmb) {
		
				
		
		return numbersinSquare[area][nmb];
	}

	private static boolean isPossibleIncol(int col, int nmb) {
		
		return numbersinCol[col][nmb];
	
	}

	private static boolean isPossibleInRow(int row, int nmb) {
		return numbersinRow[row][nmb];
		
		
	}

	

}



