package main.java.Kakao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MovingBlock {

    static Queue<Robot> que;
    static  ArrayList<Position> visited;
    public int solution(int[][] board) {

        que = new LinkedList<>();
        visited = new ArrayList<>();

        Robot initial=new Robot(1,0,0,0,0,1);
        que.add(initial);
        visited.add(initial.getPosition());

       while(!que.isEmpty()){
           Robot robot=que.poll();


           if(isArrive(robot,board.length-1)){
               return robot.getTravelledTime();
           }

           move(robot,board);


       }

       return -1;

    }

    private void move(Robot robot,int[][] board){

        moveUp(robot,board);
        moveDown(robot,board);
        moveLeft(robot,board);
        moveRight(robot,board);
        spinClockwise(robot,board);
        spinAntiClockwise(robot,board);


    }
    private void moveUp(Robot robot,int[][] board){

        Robot upWard=robot.moveUpward();
        if(isMovable(upWard.getPosition(),board)){
            checkDuplicateAndAdd(upWard);
        }

    }

    private void moveDown(Robot robot,int[][] board){
        Robot downWard=robot.downUpward();
        if(isMovable(downWard.getPosition(),board)){
            checkDuplicateAndAdd(downWard);
        }

    }

    private void moveLeft(Robot robot,int[][] board){
        Robot left=robot.left();
        if(isMovable(left.getPosition(),board)){
            checkDuplicateAndAdd(left);
        }

    }


    private void moveRight(Robot robot,int[][] board){
        Robot right=robot.right();
        if(isMovable(right.getPosition(),board)){
            checkDuplicateAndAdd(right);
        }

    }



    private void spinClockwise(Robot robot,int[][] board){

        spinFrontClockwise(robot,board);
        spinRearClockwise(robot,board);

    }

    private void spinAntiClockwise(Robot robot,int[][] board){
        spinFrontAntiClockwise(robot,board);
        spinRearAntiClockwise(robot,board);


    }

    private void spinFrontAntiClockwise(Robot robot,int[][] board){
        MBCor spinningCor=robot.getCorWhenSpinFrontAntiClockwise();
        if(checkWallAndOutOfBoard(spinningCor,board)){
            Robot frontAntiClockwise=robot.spinFrontAntiClockwise();
            if(isMovable(frontAntiClockwise.getPosition(),board)){
                checkDuplicateAndAdd(frontAntiClockwise);

            }

        }
    }

    private void spinRearAntiClockwise(Robot robot,int[][] board){
        MBCor spinningCor=robot.getCorWhenSpinRearAntiClockwise();
        if(checkWallAndOutOfBoard(spinningCor,board)){
            Robot rearAntiClockwise=robot.spinRearAntiClockwise();
            if(isMovable(rearAntiClockwise.getPosition(),board)){
                checkDuplicateAndAdd(rearAntiClockwise);

            }

        }
    }

    private void spinFrontClockwise(Robot robot,int[][] board){
        MBCor spinningCor=robot.getCorWhenSpinFrontClockwise();
        if(checkWallAndOutOfBoard(spinningCor,board)){
            Robot frontClockwise=robot.spinFrontClockwise();
            if(isMovable(frontClockwise.getPosition(),board)){
                checkDuplicateAndAdd(frontClockwise);

            }

        }
    }

    private void spinRearClockwise(Robot robot,int[][] board){
        MBCor spinningCor=robot.getCorWhenSpinRearClockwise();
        if(checkWallAndOutOfBoard(spinningCor,board)){
            Robot rearClockwise=robot.spinRearClockwise();
            if(isMovable(rearClockwise.getPosition(),board)){
                checkDuplicateAndAdd(rearClockwise);

            }

        }
    }

    private void checkDuplicateAndAdd(Robot robot){
        if(!visited.contains(robot.getPosition())){
            que.add(robot);
            visited.add(robot.getPosition());
        }
    }

    private boolean isMovable(Position position,int[][] board){

       return checkWallAndOutOfBoard(position.getFront(),board)&&checkWallAndOutOfBoard(position.getRear(),board);
    }

    private boolean checkWallAndOutOfBoard(MBCor movedCor,int[][] board){
        if(movedCor.getX()<0||movedCor.getX()>=board.length||movedCor.getY()<0|movedCor.getY()>=board.length) return false;

        if(board[movedCor.getY()][movedCor.getX()]==1) return false;


        return true;
    }





    private boolean isArrive(Robot robot,int length){
        if(robot.getPosition().getFront().getX()==length&&robot.getPosition().getFront().getY()==length){
            return true;
        }
        return false;
    }



}

class Robot{

    private Position position;
    private int travelledTime;
    private int axis;


    Robot(Position position,int travelledTime,int axis){
        this.position=position;
        this.travelledTime=travelledTime;
        this.axis=axis;
        //1 x축모양 -1y축모양
    }
    Robot(int frontX,int frontY,int rearX,int rearY,int travelledTime,int axis){

      this(new Position(new MBCor(frontX,frontY),new MBCor(rearX,rearY)),travelledTime,axis);

    }

    public int getTravelledTime() {
        return travelledTime;
    }

    public Position getPosition() {
        return position;
    }

    public Robot moveUpward(){

        return moveIntoFourDirection(0,-1);

    }
    public Robot downUpward(){
        return moveIntoFourDirection(0,1);

    }

    public Robot left(){
        return moveIntoFourDirection(-1,0);
    }

    public Robot right(){
        return moveIntoFourDirection(1,0);
    }
    public Robot moveIntoFourDirection(int x,int y){
        MBCor newFront= new MBCor(this.getPosition().getFront().getX()+x,this.getPosition().getFront().getY()+y);
        MBCor newRear=new MBCor(this.getPosition().getRear().getX()+x,this.getPosition().getRear().getY()+y);

        return new Robot(new Position(newFront,newRear),this.travelledTime+1,this.axis);
    }





    public MBCor getCorWhenSpinFrontClockwise(){

        return calculateCor(this.getPosition().getFront(),-1,-1);
    }

    public MBCor getCorWhenSpinFrontAntiClockwise(){

        return calculateCor(this.getPosition().getFront(),-1,1);
    }

    public MBCor getCorWhenSpinRearClockwise(){

        return calculateCor(this.getPosition().getRear(),1,-1);
    }

    public MBCor getCorWhenSpinRearAntiClockwise(){

        return calculateCor(this.getPosition().getRear(),1,1);
    }

    private MBCor calculateCor(MBCor pivotCor,int PR,int spinDirection){
        // PR 1 front -1 rear (moving part)
        // spinDirection 1 clock -1 anti
        MBCor cor=null;
        if(this.axis==1){
            cor=new MBCor(pivotCor.getX(),pivotCor.getY()+(PR*spinDirection));
        }else{
            cor=new MBCor(pivotCor.getX()-(PR*spinDirection),pivotCor.getY());
        }
        return cor;
    }

    public Robot spinFrontClockwise(){

        MBCor newPoint=calculateCor(this.getPosition().getRear(),1,1);
        Position newPosition;
        if(this.axis==1){
            newPosition=new Position(newPoint,this.getPosition().getRear());
        }else{
            newPosition=new Position(this.getPosition().getRear(),newPoint);
        }

        return new Robot(newPosition,this.travelledTime+1,this.axis*-1);
    }

    public Robot spinFrontAntiClockwise(){
        MBCor newPoint=calculateCor(this.getPosition().getRear(),1,-1);
        Position newPosition;
        if(this.axis==1){
            newPosition=new Position(this.getPosition().getRear(),newPoint);
        }else{
            newPosition=new Position(newPoint,this.getPosition().getRear());
        }

        return new Robot(newPosition,this.travelledTime+1,this.axis*-1);

    }

    public Robot spinRearClockwise(){
        MBCor newPoint=calculateCor(this.getPosition().getFront(),-1,1);
        Position newPosition;
        if(this.axis==1){
            newPosition=new Position(this.getPosition().getFront(),newPoint);
        }else{
            newPosition=new Position(newPoint,this.getPosition().getFront());
        }

        return new Robot(newPosition,this.travelledTime+1,this.axis*-1);
    }


    public Robot spinRearAntiClockwise(){
        MBCor newPoint=calculateCor(this.getPosition().getFront(),-1,-1);
        Position newPosition;
        if(this.axis==1){
            newPosition=new Position(newPoint,this.getPosition().getFront());
        }else{
            newPosition=new Position(this.getPosition().getFront(),newPoint);
        }
        return new Robot(newPosition,this.travelledTime+1,this.axis*-1);
    }
}

class Position{
    private MBCor front;
    private MBCor rear;

    Position(MBCor front,MBCor rear){
    this.front=front;
    this.rear=rear;
    }

    public boolean equals(Object obj){

        if(obj instanceof Position){
            MBCor objFront=((Position) obj).getFront();
            MBCor objRear=((Position) obj).getRear();

            if(objFront.getX()==this.front.getX()&&
               objFront.getY()==this.front.getY()&&
               objRear.getX()==this.rear.getX()&&
               objRear.getY()==this.rear.getY()
            ) return true;
        }

        return false;
    }

    public MBCor getFront() {
        return front;
    }

    public MBCor getRear(){
        return rear;
    }

    public void setFront(MBCor front){
        this.front=front;
    }

    public void setRear(MBCor rear){
        this.rear=rear;
    }
}

class MBCor{
    private int x;
    private int y;

    public MBCor(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    public String toString(){
        return this.y+","+this.x;
    }
}
