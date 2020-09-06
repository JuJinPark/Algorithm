package main.java.Kakao;

import java.util.*;

public class BlockGame {
    public int solution(int[][] board) {
        Board gameBoard = new Board(board);
        BlockGameClass blockGameClass = new BlockGameClass(gameBoard,createBlocks(board));
        return blockGameClass.findRemovableBlockCount();
//        int answer = 0;
//        while(true){
//            boolean removeFlag = false;
//            for (Integer key : blocks.keySet()) {
//                Block block = blocks.get(key);
//                if(gameBoard.isRemovable(block)){
//                    gameBoard.removeBlock(block);
//                    blocks.remove(key);
//                    removeFlag=true;
//                    answer++;
//                    break;
//                }
//            }
//
//            if(!removeFlag){
//                break;
//            }
//
//        }

//        return answer;
    }

    public LinkedList<Block> createBlocks(int[][] board){
        HashMap<Integer,Block> blocks = new HashMap<>();
        for(int i=0;i<board.length;i++){
            for (int j = 0; j < board[i].length ; j++) {
                if(board[i][j]==0){
                    continue;
                }
                int key=board[i][j];
                Coordinate coordinate = new Coordinate(j, i);
                if(blocks.get(key)==null){
                    Block block = new Block();
                    block.addCoordinate(coordinate);
                    blocks.put(key,block);
                }else{
                    Block block = blocks.get(key);
                    block.addCoordinate(coordinate);
                }
            }
        }
        return new LinkedList<>(blocks.values());
    }
}

class BlockGameClass {
    private Board board;
    private List<Block> blocks;
    public BlockGameClass(Board board,List<Block> blocks) {
        this.board=board;
        this.blocks=blocks;
    }

    public int findRemovableBlockCount(){
        int count=0;
        for (int i = 0; i < blocks.size(); i++) {
            Block block = blocks.get(i);
            if(board.isRemovable(block)){
                board.removeBlock(block);
                blocks.remove(i);
                i=-1;
                count++;
            }

        }
        return count;
    }
}
class Board{
    private int[][] board;

    public Board(int[][] board) {
        this.board = board;
    }

    public void removeBlock(Block block){
        List<Coordinate> coordinateList = block.getCoordinateList();
        for (Coordinate coordinate : coordinateList) {
            board[coordinate.getY()][coordinate.getX()]=0;
        }
    }

    public boolean isRemovable(Block block){
        List<Coordinate> missingCors = block.getMissingCors();
        for (Coordinate missingCor : missingCors) {
            int nextY=missingCor.getY();
            while(nextY>=0){
                if(board[nextY][missingCor.getX()]!=0){
                    return false;
                }
                nextY--;
            }
        }

        return true;
    }
}

class Block{

    private List<Coordinate> coordinateList = new ArrayList<>();
    private List<Coordinate> missingCors = new ArrayList<>();
    private List<Integer> xAxis = new ArrayList<>();
    private List<Integer> yAxis = new ArrayList<>();


    public List<Coordinate> getMissingCors() {
        if(missingCors.size()!=2){
            missingCors=findMissingCoordinates();
        }
        return missingCors;
    }

    public List<Coordinate> getCoordinateList() {
        return coordinateList;
    }


    private List<Coordinate> findMissingCoordinates (){

        ArrayList<Coordinate> missingCors = new ArrayList<>();
        for (Integer x : xAxis) {
            for (Integer y : yAxis) {
                Coordinate coordinate = new Coordinate(x, y);
                if(!coordinateList.contains(new Coordinate(x,y))){
                    missingCors.add(coordinate);
                }
            }
        }
        if(missingCors.size()!=2){
            throw new IllegalStateException("wrong block");
        }
        return missingCors;
    }

    public void addCoordinate(Coordinate coordinate) {
        coordinateList.add(coordinate);
        if(!xAxis.contains(coordinate.getX())){
            xAxis.add(coordinate.getX());
        }
        if(!yAxis.contains(coordinate.getY())){
            yAxis.add(coordinate.getY());
        }

    }
}

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
