package Samseung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EscapeTheBead {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n= sc.nextInt();
		int m=sc.nextInt();
		
		String[][] board= new String[n][m];
		RedAndBlueBead startPoint = new RedAndBlueBead();
		for(int i=0;i<n;i++) {
			
			String line=sc.next();
			for(int j=0;j<m;j++) {
				String value=line.charAt(j)+"";
				if("R".equals(value)) {
					startPoint.setRedn(i);
					startPoint.setRedm(j);
					value=".";
				}else if("B".equals(value)) {
					startPoint.setBluen(i);
					startPoint.setBluem(j);
					value=".";
				}
				
					board[i][j]=value;
			
				
			}
		}

		
		startPoint.setDirFrom(0);
		startPoint.setMoveCount(0);
		

		
		EscapeTheBeadSol sol = new EscapeTheBeadSol();
	System.out.println(sol.solution(n, m, board, startPoint));
	}

}
class EscapeTheBeadSol{
	static int[] dirR= {0,1,-1,0,0};
	static int[] dirC= {0,0,0,1,-1};
	static String[] dir= {"","아래","위","오른쪽","왼쪽"};
	static int[] maxRange;
	
	public int solution(int n,int m,String[][] board,RedAndBlueBead startPoint) {
		maxRange=new int[] {0,n,0,m,0};
		
		return bfs(board,startPoint);
		
		
	}
	
	public int bfs(String[][] board,RedAndBlueBead startPoint) {
		Queue<RedAndBlueBead> que= new LinkedList();
		que.add(startPoint);
		while(!que.isEmpty()) {
			RedAndBlueBead crt=que.poll();
			
			if(crt.moveCount>=10) {
				return -1;
			}
			//1 은 아래 2=위 3=오른쪽 4=왼쪽
			for(int i=1;i<=4;i++) {
				
				if(crt.dirFrom==i) {
					continue;
				}
				int Nxtredn=crt.redn;
				int Nxtredm=crt.redm;
				int Nxtbluen=crt.bluen;
				int Nxtbluem=crt.bluem;
				
			boolean blueFoundHole = false;

				
				int crtRangeR = crt.redn;
				
				int crtRangeB = crt.bluen;
				if(i>2) {
					crtRangeR=crt.redm;
					crtRangeB=crt.bluem;
				}
				
				int mxRangeR=Math.abs(maxRange[i]-crtRangeR);
				int mxRangeB=Math.abs(maxRange[i]-crtRangeB);
				
				
				for(int b=1;b<=mxRangeB;b++) {
					int tmpNxtbluen = Nxtbluen+dirR[i];
					int tmpNxtbluem = Nxtbluem+dirC[i];
					
					if(board[tmpNxtbluen][tmpNxtbluem].equals("O")) {
						blueFoundHole=true;
						break;
						
					}
					if(board[tmpNxtbluen][tmpNxtbluem].equals("#")) {
						break;
					}
					Nxtbluen=tmpNxtbluen;
					Nxtbluem=tmpNxtbluem;
				}
				
				for(int r=1;r<=mxRangeR;r++) {
					int tmpNxtredn = Nxtredn+dirR[i];
					int tmpNxtredm = Nxtredm+dirC[i];
					
					if(board[tmpNxtredn][tmpNxtredm].equals("O")) {
						if(!blueFoundHole) {
							return crt.moveCount+1;
						}
						
					}
					
					if(board[tmpNxtredn][tmpNxtredm].equals("#")) {
						break;
					}
					
					Nxtredn=tmpNxtredn;
					Nxtredm=tmpNxtredm;
				}
				
				
				
				if((Nxtredn==Nxtbluen)&&(Nxtredm==Nxtbluem)) {
					//1 은 아래 2=위 3=오른쪽 4=왼쪽
					if(i==1) {
						if(crtRangeR<crtRangeB) {
							Nxtredn=Nxtredn-1;
						}else {
							Nxtbluen=Nxtbluen-1;
						}
						
					}else if(i==2) {
						
						if(crtRangeR<crtRangeB) {
							Nxtbluen=Nxtbluen+1;
							
						}else {
							Nxtredn=Nxtredn+1;
						}
						
					}else if(i==3) {
						if(crtRangeR<crtRangeB) {
							Nxtredm=Nxtredm-1;
						}else {
							Nxtbluem=Nxtbluem-1;
						}
						
						
					}else {
						if(crtRangeR<crtRangeB) {
							Nxtbluem=Nxtbluem+1;
						
						}else {
							Nxtredm=Nxtredm+1;
						}
						
					}
					// crt로 비교해서 진행반대방향쪽에 가까운거에서 한칸뒤로 수정
					
				}
				


		if(!blueFoundHole) {
			
	
				if(Nxtredn!=crt.redn||Nxtredm!=crt.redm||Nxtbluen!=crt.bluen||Nxtbluem!=crt.bluem) {

					RedAndBlueBead nxt= new RedAndBlueBead();
					nxt.setRedn(Nxtredn);
					nxt.setRedm(Nxtredm);
					nxt.setBluen(Nxtbluen);
					nxt.setBluem(Nxtbluem);
					nxt.setMoveCount(crt.moveCount+1);
					nxt.setDirFrom(i+dirR[i]+dirC[i]);
					que.add(nxt);
				}
		}
		
			}
			
		}
		return -1;
			
		
	}
}
class RedAndBlueBead{
	int redn;
	int redm;
	int bluen;
	int bluem;
	
	int dirFrom;
	int moveCount;
	public int getRedn() {
		return redn;
	}
	public void setRedn(int redn) {
		this.redn = redn;
	}
	public int getRedm() {
		return redm;
	}
	public void setRedm(int redm) {
		this.redm = redm;
	}
	public int getBluen() {
		return bluen;
	}
	public void setBluen(int bluen) {
		this.bluen = bluen;
	}
	public int getBluem() {
		return bluem;
	}
	public void setBluem(int bluem) {
		this.bluem = bluem;
	}
	public int getDirFrom() {
		return dirFrom;
	}
	public void setDirFrom(int dirFrom) {
		this.dirFrom = dirFrom;
	}
	public int getMoveCount() {
		return moveCount;
	}
	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
	}


	
}
