package main.java.Kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FindPathGame {
    public int[][] solution(int[][] nodeinfo) {

        ArrayList<BinaryNode> binaryNodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            binaryNodes.add(new BinaryNode(i+1,nodeinfo[i][0],nodeinfo[i][1]));
        }
        Collections.sort(binaryNodes,new CoordinateSort());

        BinaryNode root = binaryNodes.get(0);
        for (int i = 1; i <binaryNodes.size() ; i++) {
            root.put(binaryNodes.get(i));
        }
        int[][] answer = new int [2][binaryNodes.size()];

        this.preOrder(root,answer[0],new Index());
        this.postOrder(root,answer[1],new Index());

        System.out.println(Arrays.toString(answer[0]));
        System.out.println(Arrays.toString(answer[1]));

        return answer;
    }

    public void preOrder(BinaryNode node,int[] answer,Index idx){
            answer[idx.getValue()]=node.getValue();
             idx.increase();
            if(node.left!=null){
                preOrder(node.getLeft(),answer,idx);
            }
            if(node.right!=null){
                preOrder(node.getRight(),answer,idx);
            }

    }


    public void postOrder(BinaryNode node,int[] answer,Index idx){

        if(node.left!=null){
            postOrder(node.getLeft(),answer,idx);
        }
        if(node.right!=null){
            postOrder(node.getRight(),answer,idx);
        }

        answer[idx.getValue()]=node.getValue();
        idx.increase();
    }
}

class Index {
    int value=0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void increase() {
    value++;
    }
}

class BinaryNode {

    int value;

    int x;
    int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BinaryNode(int value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
    }

    public void put(BinaryNode node){
        if(node.getX()<this.getX()){
            setLeft(node);
            return;
        }

        setRight(node);




    }

    public int getValue() {
        return value;
    }


    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        if(this.left==null){
            this.left = left;
        }else{
            this.left.put(left);
        }

    }

    public BinaryNode getRight() {

        return right;
    }

    private void setRight(BinaryNode right) {
        if(this.right==null){
            this.right=right;
        }else{
            this.right.put(right);
        }

    }

    BinaryNode left;
    BinaryNode right;
}
class CoordinateSort  implements Comparator<BinaryNode> {
    public int compare(BinaryNode a, BinaryNode b)
    {

        int compare = (Integer.compare(a.getY(), b.getY()))*-1;
//        if(compare==0){
//            return Integer.compare(a.getX(),b.getX());
//        }
        return compare;

    }
}
