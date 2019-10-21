package main.java.Samseung;

import java.util.Scanner;

public class Dice {
static int N;
static int M;
static int [][] board;
static int[] dirN= new int[] {0,0,0,-1,1};
static int[] dirM= new int[] {0,1,-1,0,0};
	
	public static void main(String[] args) {
		int[] values= new int[7];
		int crtn;
		int crtm;
		int commandLength;
	Scanner sc= new Scanner(System.in);
	
	
		String[] line=sc.nextLine().split(" ");
		
			N=Integer.parseInt(line[0]);
			M=Integer.parseInt(line[1]);
			crtn=Integer.parseInt(line[2]);
			crtm=Integer.parseInt(line[3]);
			commandLength=Integer.parseInt(line[4]);
			board=new int[N][M];
			
		for(int i=0;i<N;i++) {
			String[] subline=sc.nextLine().split(" ");
			for(int j=0;j<M;j++) {
				board[i][j]=Integer.parseInt(subline[j]);
			}
			
			
		}
		
	
		
	
	
	int [] command= new int[commandLength];
	
	String[] tmpcmnd=sc.nextLine().split(" ");
	for(int i=0;i<commandLength;i++)
	{
		command[i]=Integer.parseInt(tmpcmnd[i]);
	}
	
	DiceShape crtdice=new DiceShape(2,5,4,1,3,6);
	
	
	for(int k=0;k<commandLength;k++) {
		int crtcmd=command[k];
		DiceShape nxtDice = null;
		if(crtcmd==1) {
			nxtDice=diceMoveRight(crtdice);
		}else if(crtcmd==2) {
			nxtDice=diceMoveLeft(crtdice);
		}else if(crtcmd==3) {
			nxtDice=diceMoveUp(crtdice);
		}else if(crtcmd==4) {
			nxtDice=diceMoveDown(crtdice);
		}
		
		int nxtn=crtn+dirN[crtcmd];
		int nxtm=crtm+dirM[crtcmd];
		
		if(isOutArray(nxtn,nxtm)) {
			continue;
		}
		
		int boardValue=board[nxtn][nxtm];
		if(boardValue==0) {
			board[nxtn][nxtm]=values[nxtDice.bottom];
		}else {
			values[nxtDice.bottom]=board[nxtn][nxtm];
			board[nxtn][nxtm]=0;
		}
		System.out.println(values[nxtDice.top]);
		crtdice=nxtDice;
		crtn=nxtn;
		crtm=nxtm;
		
	}
	
		

	}
	public static boolean isOutArray(int nxtn,int nxtm) {
		if(nxtn<0||nxtn>=N||nxtm<0||nxtm>=M) {
			return true;
		}
		return false;
	}
	
	
	public static DiceShape diceMoveLeft(DiceShape crt) {
	 return new DiceShape(crt.up,crt.down,crt.top,crt.left,crt.bottom,crt.right);
		
	}

	public static DiceShape diceMoveRight(DiceShape crt) {
	 return new DiceShape(crt.up,crt.down,crt.bottom,crt.right,crt.top,crt.left);
		
	}

	public static DiceShape diceMoveUp(DiceShape crt) {
	 return new DiceShape(crt.top,crt.bottom,crt.left,crt.up,crt.right,crt.down);
		
	}

	public static DiceShape diceMoveDown(DiceShape crt) {
	 return new DiceShape(crt.bottom,crt.top,crt.left,crt.down,crt.right,crt.up);
		
	}

}

class DiceShape{
	int up;
	int down;
	int left;
	int right;
	int top;
	int bottom;
	
	DiceShape(int up,int down,int left,int bottom,int right,int top){
		this.up=up;
		this.down=down;
		this.left=left;
		this.right=right;
		this.top=top;
		this.bottom=bottom;
		
	}
	
}

