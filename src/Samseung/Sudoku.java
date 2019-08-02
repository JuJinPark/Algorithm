package Samseung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class Sudoku {
	static int[][] board;
	
	static Map<SudokuCor,List<Integer>> candidateNmberListPerCor = new HashMap();
	static Queue<SudokuCor> que= new LinkedList();
	static int undecidedCount;
	public static void main(String[] args) throws IOException {
		board= new int[9][9];
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

		for(int i=0;i<9;i++) {
			String line=reader.readLine();
			for(int j=0;j<9;j++) {
				board[i][j]= (line.charAt(j))-'0';
			}
		}
		initializeList();
		dfs();
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
	


	public static boolean dfs() {

		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(board[i][j]==0) {
					
					
					List<Integer> list = candidateNmberListPerCor.get(new SudokuCor(i,j));
					
					for(Integer nmb:list) {
						if(isPossibleInRow(i,j,nmb)&&isPossibleIncol(i,j,nmb)&&isPossibleInSquare(i,j,nmb)) {
						
							
							board[i][j]=nmb;
							undecidedCount--;
							
							if(dfs()) {
								return true;
							}
							undecidedCount++;
							board[i][j]=0;
							
							//System.out.println(i+","+j+","+nmb);
						}
						
				
					}
					return false;
					
					
				}
				
				
			}
		}
		
		return true;
		
	
	}

	private static boolean isPossibleInSquare(int row, int col, Integer nmb) {
		for(int i=3*(row/3);i<=(3*(row/3))+2;i++) {
			for(int j=3*(col/3);j<=(3*(col/3))+2;j++) {
				
				if(board[i][j]==nmb) {
					return false;
				}
				
			}
		}
		return true;
	}

	private static boolean isPossibleIncol(int row, int col, Integer nmb) {
		for(int i=0;i<9;i++) {
			if(board[row][i]==nmb) {
			return false;
			}
		}
		return true;
	}

	private static boolean isPossibleInRow(int row, int col, Integer nmb) {
		for(int i=0;i<9;i++) {
			if(board[i][col]==nmb) {
			return false;
			}
		}
		return true;
	}

	public static void initializeList() {
		for(int i=0;i<9;i++) {
			
			for(int j=0;j<9;j++) {
				if(board[i][j]==0) {
					undecidedCount++;
					
					SudokuCor cor= new SudokuCor(i,j);
					
					List<Integer> list=getCandidateNumber(i,j);
					if(list.size()==1) {
						undecidedCount--;
						que.add(cor);
						board[i][j]=list.get(0);
						continue;
					}
					candidateNmberListPerCor.put(cor, list);
				}
			}
		}
		
	}
	
	public static List<Integer> getCandidateNumber(int row,int col){
		boolean[] array=new boolean [10];
		List<Integer> list= new LinkedList();
		
		
			checkNmbForRow(array,row,col);
			checkNmbForCol(array,row,col);
			checkNmbForSquare(array,row,col);
			
		
		
		for(int i=1;i<=9;i++) {
			if(array[i]==false) {
				list.add(i);
			}
		}
		
		
		return list;
		
		
	}

	private static void checkNmbForRow(boolean[] array, int row, int col) {
		
		for(int i=0;i<9;i++) {
			array[board[i][col]]=true;
			

		}
		
	}
	
private static void checkNmbForCol(boolean[] array, int row, int col) {
		
		for(int i=0;i<9;i++) {
			array[board[row][i]]=true;
			

		}
		
	}

private static void checkNmbForSquare(boolean[] array, int row, int col) {
	
	for(int i=3*(row/3);i<=(3*(row/3))+2;i++) {
		for(int j=3*(col/3);j<=(3*(col/3))+2;j++) {
			//System.out.println(board[i][j]+"-"+row+"-"+col);
			array[board[i][j]]=true;
	
			
		}
	}
	
}

}

class SudokuCor{
	int row;
	int col;
	SudokuCor(int row,int col){
		this.row=row;
		this.col=col;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SudokuCor) {
			SudokuCor obj1=(SudokuCor)obj;
			if(obj1.row==this.row&&obj1.col==this.col) {
				return true;
			}
		}
		return false;
		
	}
	public int hashCode() {
		String result="row"+row+","+"col"+col;
		return result.hashCode();
		
		
	}
	
}