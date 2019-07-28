package Samseung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		
		
		while(!que.isEmpty()) {
			
			//check row
			// check col
			// chekc squre
			
		}
		
		

	}
	
	public static void chekcRow(SudokuCor cor) {
		
		for(int i=0;i<9;i++) {
			if(board[i][cor.col]==0) {
				SudokuCor nxtcor=new SudokuCor(i,cor.col);
					
				int value = board[cor.row][cor.col];
				handle(nxtcor,value) ;
			}
		}
	}
	
	
	
	public static void checkCol(SudokuCor cor) {

		for(int i=0;i<9;i++) {
			if(board[cor.row][i]==0) {
				SudokuCor nxtcor=new SudokuCor(cor.row,i);
					
				int value = board[cor.row][cor.col];
				handle(nxtcor,value) ;
			}
		}
	}
	
	public static void checkSquare(SudokuCor cor) {
		
		for(int i=3*(cor.row/3);i<(3*(cor.row/3))+2;i++) {
			for(int j=3*(cor.col/3);j<(3*(cor.col/3))+2;j++) {
				
				if(board[i][j]==0) {
					SudokuCor nxtcor=new SudokuCor(i,j);
						
					int value = board[cor.row][cor.col];
					handle(nxtcor,value) ;
				}
				
			}
		}
		
	}
	
	public static void handle(SudokuCor nxtcor,int value) {
	
		List<Integer> list=candidateNmberListPerCor.get(nxtcor);
	
			list.remove(value);
			
			if(list.size()==1) {
				undecidedCount--;
				que.add(nxtcor);
				board[nxtcor.row][nxtcor.col]=list.get(0);
				candidateNmberListPerCor.remove(nxtcor);
			}
	}
	
	public static void initializeList() {
		for(int i=0;i<9;i++) {
			
			for(int j=0;j<9;j++) {
				if(board[i][j]==0) {
					undecidedCount++;
					
					SudokuCor cor= new SudokuCor(i,j);
					
					List<Integer> list=getCandidateNumber();
					if(list.size()==1) {
						que.add(cor);
						board[i][j]=list.get(0);
						continue;
					}
					candidateNmberListPerCor.put(cor, list);
				}
			}
		}
		
	}
	
	public static List<Integer> getCandidateNumber(){
		
		for() {
			checkrow
			checkcol
			check square
			
		}
		
		
		
		return null;
		
		
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
