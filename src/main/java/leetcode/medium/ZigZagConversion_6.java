package main.java.leetcode.medium;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ZigZagConversion_6 {

    public String convert(String s, int numRows) {

        if (numRows==1){
            return s;
        }
        Letters letters = new Letters();
        int x = 0;
        int y = 0;
        int idx=0;
        int xDirection=1;
        int yDirection=-1;
        for (char c : s.toCharArray()) {
            letters.add(new Letter(Character.toString(c),x,y)) ;
            if(y==numRows-1||y==0){
                yDirection=yDirection*-1;
            }
            y=y+yDirection;
            if(yDirection==-1){
                x=x+xDirection;
            }
        }


        return letters.getAsString();
    }
}

class Letters{
    private List<Letter> list = new ArrayList();

    public void add(Letter letter){
        list.add(letter);
    }

    public String getAsString(){
        Collections.sort(list,new LetterAsc());
        StringBuilder string= new StringBuilder();
        for (Letter letter : list) {
            string.append(letter.getValue());
        }
        return string.toString();
    }
}
class LetterAsc  implements Comparator<Letter> {
    public int compare(Letter a, Letter b)
    {
        int compare = Integer.compare(a.getY(), b.getY());
        if(compare==0){
           return Integer.compare(a.getX(),b.getX());
        }
        return compare;
    }
}

class Letter{
    private String value;
    private int x;
    private int y;

    public Letter(String value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
    }

    public String getValue() {
        return value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
