package main.java.Kakao.ColumnBeam;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ColumnAndBeam {

    static PriorityQueue<Material> constructed;
    static int[][] totalMap;
    static int[][] columnMap;
    static int[][] beamMap;


    static int N;
    public int[][] solution(int n, int[][] build_frame) {
      constructed = new PriorityQueue<>(new MaterialComparator ());
      N=n;
      totalMap= new int[N+1][N+1];
      columnMap= new int[N+1][N+1];
      beamMap= new int[N+1][N+1];

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
        int yinMap=N-frames[1];
        int xinMap=frames[0];

        if(frames[2]==0) return checkForColumn(xinMap,yinMap);

        return checkForBeam(xinMap,yinMap);
    }

    private boolean checkForColumn(int xinMap,int yinMap){


        if(yinMap==N) return true; //바닥

        if(xinMap-1>=0&&beamMap[yinMap][xinMap-1]==1) return true; // 옆에 보

        if(beamMap[yinMap][xinMap]==1) return true; // 같은자리에 보

        if(yinMap+1<=N&&columnMap[yinMap+1][xinMap]==1) return true; //밑에 기둥

        return false;
    }

    private boolean checkForBeam(int xinMap,int yinMap){

        if(yinMap+1<=N&&columnMap[yinMap+1][xinMap]==1) return true;// 바로 밑에 기둥

        if(yinMap+1<=N&&xinMap+1<=N&&columnMap[yinMap+1][xinMap+1]==1)  return true;      //옆에 밑에 기둥

        if(xinMap-1>=0&&xinMap+1<=N&&beamMap[yinMap][xinMap-1]==1&&beamMap[yinMap][xinMap+1]==1) {
            return true;    //양옆에 보
        }



        return false;
    }

    private boolean isRemovable(int[] frames){
        int yinMap=N-frames[1];
        int xinMap=frames[0];


        if(frames[2]==0) {
            return isColumnRemovable(xinMap,yinMap);
        }

        return isBeamRemovable(xinMap,yinMap);





    }

    private boolean isColumnRemovable(int xinMap,int yinMap){

        return checkUp(xinMap,yinMap)&&checkUpLeft(xinMap,yinMap);

    }

    private boolean checkUp(int xinMap,int yinMap){

        int x=xinMap;
        int y=yinMap-1;

        if(y<0){
            return true;
            //위가 없음
        }

        if(totalMap[y][x]==1){
            return checkForColumn(x,y);
            // 위에 기둥일시
        }else if(totalMap[y][x]==2||totalMap[y][x]==3){
            return checkForBeam(x,y);
            //위에 보거나 둘다 있거나

        } else{
            return true;
            //위에 아무것도 없음
        }


    }

    private boolean checkUpLeft(int xinMap,int yinMap){
        int x=xinMap-1;
        int y=yinMap-1;

        if(y<0||x<0){
            return true;
            //위가 나 위옆에 없음
        }

        if(totalMap[y][x]==2||totalMap[y][x]==3){
            return checkForBeam(x,y);
            // 위옆이 보일시에만 검사
        }else{
            return true;
        }



    }


    private boolean isBeamRemovable(int xinMap,int yinMap){

        return checkRight(xinMap,yinMap)&&checkLeft(xinMap,yinMap)&&checkCurrent(xinMap,yinMap);


    }

    private boolean checkRight(int xinMap,int yinMap){
        int x=xinMap+1;
        int y=yinMap;

        if(x>N){
            return true;
            //오른쪽이 없음
        }


        if(totalMap[y][x]==1){
            return checkForColumn(x,y);
            // 옆에 기둥일시
        }else if(totalMap[y][x]==2||totalMap[y][x]==3){
            return checkForBeam(x,y);
            //옆에 보일시
        }else{
            return true;
            //옆에 아무것도 없음

        }



    }

    private boolean checkLeft(int xinMap,int yinMap){
        int x=xinMap-1;
        int y=yinMap;

        if(x<0){
            return true;
            //왼쪽이 없음
        }


        if(totalMap[y][x]==2||totalMap[y][x]==3){
            return checkForBeam(x,y);
            // 왼쪽 옆이 보나 두가 다 있을시
        }else{
            return true;
            //옆에 아무것도없거나 기둥만 있을시

        }



    }
    private boolean checkCurrent(int xinMap,int yinMap){
        int x=xinMap;
        int y=yinMap;


        if(totalMap[y][x]==1){
            return checkForColumn(x,y);
            // 자기자리에 지우기전에 둘다 잇으시 그러니까 현재 기둥이 있을시시
       }else{
            return true;
            //옆에 아무것도없거나 기둥만 있을시

        }
    }


    private void construct(int[] frames){
       if(isConstructable(frames)) {
           Material material=getMaterial(frames);
           markInMap(frames);
           constructed.offer(material);
       }

    }

    private void markInMap(int[] frames){
        markInMap(frames,1);
    }
    private void removeMarkInMap(int[] frames){
        markInMap(frames,-1);
    }

    private void markInMap(int[] frames,int num){

        totalMap[N-frames[1]][frames[0]]=totalMap[N-frames[1]][frames[0]]+((frames[2]+1)*num);
        if(frames[2]==0) {
            columnMap[N-frames[1]][frames[0]]=columnMap[N-frames[1]][frames[0]]+num;
            return;
        }
       beamMap[N-frames[1]][frames[0]]=beamMap[N-frames[1]][frames[0]]+num;

    }




    private Material getMaterial(int[] frames){
        if(frames[2]==0)  return new Column(frames[0],frames[1]);
        return new Beam(frames[0],frames[1]);
    }

    private void remove(int[] frames){

        removeMarkInMap(frames);

        if(isRemovable(frames)){

             constructed.remove(getMaterial(frames));

             return;
        }


        markInMap(frames);



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




