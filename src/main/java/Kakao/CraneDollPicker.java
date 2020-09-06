package main.java.Kakao;

import java.util.Stack;

public class CraneDollPicker {
    public int solution(int[][] board, int[] moves) {
        CraneGame craneGame = new CraneGame(board);
        for (int move : moves) {
            craneGame.pick(move);
        }
        return craneGame.getResult();

    }

}

class CraneGame{
    private int[][] board;
    private int[] lastIdx;
    private Basket basket=new Basket();
    private  int MAX_Y_IDX;

    public CraneGame(int[][] board) {
        this.board = board;
        lastIdx=new int[board[0].length];
        MAX_Y_IDX= board.length-1;
        initialise();
    }

    private void initialise(){
        for (int i=0;i<board[0].length;i++){
            lastIdx[i]=board.length-1;
            for (int j=0;j<board.length;j++){
                if(board[j][i]!=0){
                    lastIdx[i]=j;
                    break;
                }
            }
        }
    }

    public void pick(int moveIdx){
        int x=moveIdx-1;
        int y=lastIdx[x];
        int doll=findDoll(x,y);

        if(doll!=0){
            basket.push(doll);
            removeDoll(x,y);
            increaseLastIdx(x);
        }

    }

    private int findDoll(int x,int y){
        return board[y][x];
    }

    private void removeDoll(int x,int y){
         board[y][x]=0;
    }

    private void increaseLastIdx(int x){
        if(lastIdx[x]>=MAX_Y_IDX){
            return;
        }
        lastIdx[x]=lastIdx[x]+1;
    }

    public int getResult(){
        return basket.getPushCount()-basket.getSize();
    }


}

class Basket {
    Stack<Integer> list = new Stack<Integer>();
    private int pushCount=0;

    public void push(int doll){
        if(!list.isEmpty()&&list.peek()==doll){
            list.pop();
//            removedCount=removedCount+2;
        }else{
            list.push(doll);
        }
        pushCount++;
    }

    public int getSize (){
        return list.size();
    }

    public int getPushCount(){
        return pushCount;
    }
}
