package main.java.Kakao.ColumnBeam;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ColumnAndBeam {

    static PriorityQueue<Material> constructed;
    static int[][] map;
    static int N;
    public int[][] solution(int n, int[][] build_frame) {
      constructed = new PriorityQueue<>(new MaterialComparator ());
      N=n;
      map= new int[N+1][N+1];

        for(int i=0;i< build_frame.length;i++){

            if(build_frame[i][3]==0){
                remove(build_frame[i]);
                continue;
            }

            construct(build_frame[i]);

        }

        return convertToArray();

    }


    private boolean isConstructable(int[] frames){

        if(frames[2]==0) return checkForColumn(frames[0],frames[1]);

        return checkForBeam(frames[0],frames[1]);
    }

    private boolean checkForColumn(int x,int y){
        int yinMap=N-y;
        int xinMap=x;

        if(yinMap==N) return true; //바닥

        if(xinMap-1>0&&map[yinMap][xinMap-1]==2) return true; // 밑에 보

        if(yinMap-1>0&&map[yinMap-1][xinMap]==1) return true; //밑에 기둥

        return false;
    }

    private boolean checkForBeam(int x,int y){
        int yinMap=N-y;
        int xinMap=x;


        if(yinMap-1>0&&map[yinMap-1][xinMap]==1) return true;// 바로 밑에 기둥

        if(yinMap-1>0&&xinMap+1<=N&&map[yinMap-1][xinMap+1]==1)        //옆에 밑에 기둥



        if(xinMap-1>0&&xinMap+1<=N&&map[yinMap][xinMap-1]==2&&map[yinMap][xinMap+1]==2) return true;    //양옆에 보



        return false;
    }

    private boolean isRemovable(int[] frames){
        if(frames[2]==0) return checkForColumn(frames[0],frames[1]);

        return checkForBeam(frames[0],frames[1]);
    }


    private void construct(int[] frames){
       if(isConstructable(frames)) {
           Material material=create(frames);
           constructed.offer(material);
           map[N-frames[1]][frames[0]]=material.getType()+1;
           // mark in map
       }

    }

    private Material create(int[] frames){
        if(frames[2]==0) return new Column(frames[0],frames[1]);

        return new Beam(frames[0],frames[1]);

    }

    private void remove(int[] frames){

        if(isRemovable(frames)){
            constructed.remove(create(frames));
            map[N-frames[1]][frames[0]]=0;

        }
    }

    public int[][] convertToArray(){


        int[][] result= new int[constructed.size()][3];
        int idx=0;
        while(!constructed.isEmpty()){
            Material material=constructed.poll();
            result[idx]=new int[3];
            result[idx][0]= material.getX();
            result[idx][1]= material.getY();
            result[idx][2]= material.getType();
            idx++;
        }

        return result;
    }


}


class MaterialComparator implements Comparator<Material> {


    @Override
    public int compare(Material o1, Material o2) {
        if(o1.getX()==o2.getX()){
            if(o1.getY()==o2.getY()){
                return o1.getType()-o2.getType();
            }
            return o1.getY()-o2.getY();
        }

        return o1.getX()-o2.getX();
    }
}
interface Material{


    public int getX() ;


    public int getY() ;


    public int getType() ;


}

class Beam implements Material{
    private int x;
    private int y;
    private int type;

    Beam(int x,int y){
        this.x=x;
        this.y=y;
        this.type=1;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public int getType() {
        return type;
    }

    public boolean equals(Object obj){
        Beam temp;
        if(obj instanceof Beam){
            temp=(Beam)obj;

              if(temp.getX()==getX()
                  &&temp.getY()==getY()){
                  return true;
              }

        }
        return false;

    }
}

class Column implements Material{
    private int x;
    private int y;
    private int type;

    Column(int x,int y){
        this.x=x;
        this.y=y;
        this.type=0;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public int getType() {
        return type;
    }

    public boolean equals(Object obj){
        Column temp;
        if(obj instanceof Column){
            temp=(Column)obj;

            if(temp.getX()==getX()
                    &&temp.getY()==getY())
                   {
                return true;
            }

        }
        return false;

    }
}




