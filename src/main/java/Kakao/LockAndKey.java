package main.java.Kakao;

import java.util.ArrayList;

public class LockAndKey {
    static int n;
    static int m;

    public boolean solution(int[][] key, int[][] lock) {

        ArrayList<Cor> keyList=new ArrayList<>();
        int holeNmb=countHoles(lock);
        n=key.length;
        m=lock.length;

        keyList=storeKeyCoordinate(key);


        if(holeNmb>keyList.size()){
            return false;
        }

        for(int rotateTimes=0;rotateTimes<4;rotateTimes++){

            for(int i=((n-1)*-1);i<=m;i++){

                for(int j=((n-1)*-1);j<=m;j++){

                    int matchingNum=0;


                    for(Cor current:keyList){

                        Cor rotated=rotateClockwise(current,rotateTimes);

                        int nextX=rotated.getX()+j;
                        int nextY=rotated.getY()+i;

                        if(nextX<0||nextX>=m||nextY<0||nextY>=m){
                            // 자물쇠범위를 벗어난경우 스킵
                            continue;
                        }

                        if(lock[nextY][nextX]==1){
                            // 서로 돌기가 만나는 경우
                            matchingNum=0;
                            break;
                        }

                        if(lock[nextY][nextX]==0){
                            // 돌기와 홈이 맞나는 경우
                            matchingNum++;
                        }


                    }



                    if(matchingNum==holeNmb){
                        return true;
                    }
                }



            }


        }

        return false;
    }

    private int countHoles(int[][] lock){
        int holeNmb=0;
        for(int i=0;i<lock.length;i++){
            for(int j=0;j<lock.length;j++){
                if(lock[i][j]==0){
                    holeNmb++;
                }

            }
        }

        return holeNmb;
    }

    private ArrayList<Cor> storeKeyCoordinate(int[][] key){
        ArrayList<Cor> keyList=new ArrayList<>();
        for(int i=0;i<key.length;i++){
            for(int j=0;j<key.length;j++){
                if(key[i][j]==1){
                    keyList.add(new Cor(j,i));
                }

            }
        }

        return keyList;
    }

    private Cor rotateClockwise(Cor cor,int times){
        int x= cor.getX();
        int y= cor.getY();

        for(int i=0;i<times;i++){
            int tempX=x;
            int tempY=y;

            y=tempX;
            x=n-1-tempY;


        }

        return new Cor(x,y);



    }
}

class Cor{
    private int x;
    private int y;

    public Cor(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x){
        this.x=x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString(){
        return this.y+","+this.x;
    }
}
