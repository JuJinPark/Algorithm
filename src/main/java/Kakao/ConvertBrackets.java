package main.java.Kakao;

import java.util.Arrays;
import java.util.Stack;

public class ConvertBrackets {

    public String solution(String p) {

        return recur(new Bracket(p));
    }

    private String recur(Bracket w) {

        if (w.toString().equals("")) {
            return "";
        }

        int splitPoint=w.getFirstBalancedBracketIdx();

        Bracket u=new Bracket(w.toString().substring(0,splitPoint+1));
        Bracket v=new Bracket("");
        if(splitPoint+1<w.toString().length()){
            v= new Bracket(w.toString().substring(splitPoint+1));
        }


        if (u.isCorrectBracket()) {

            return u.toString() + recur(v);

        }

        String front = "(" + recur(v) + ")";
        String back =  u.toStringInReverse();
        return front + back.substring(1,back.length()-1);


    }



}

class Bracket {

    final char OPEN='(';
    final char CLOSE=')';
    private String bracket;
    Bracket(String bracket){
        this.bracket=bracket;
    }

    public String toString(){
        return bracket;
    }

    public String toStringInReverse(){
        StringBuilder result=new StringBuilder();
        for(int i=0;i<bracket.length();i++){
            if(OPEN==bracket.charAt(i)){
             result.append(CLOSE);
            }else{
             result.append(OPEN);
            }

        }

        return result.toString();


    }

    public boolean isCorrectBracket(){
        Stack<Character> stack= new Stack();
        for(int i=0;i<bracket.length();i++){
            if(OPEN==bracket.charAt(i)){
                stack.push(OPEN);
            }else{
                if(stack.empty()){
                    return false;
                }
                stack.pop();
            }

        }

        if(!stack.empty()) return false;

        return true;


    }

    public int getFirstBalancedBracketIdx(){
        int sum=0;
        int idx=-1;
        for(int i=0;i<bracket.length();i++){
            if(OPEN==bracket.charAt(i)){
                sum+=1;
            }else{
                sum+=-1;
            }

            if(sum==0){
                idx=i;
                break;
            }

        }

        return idx;

    }

}




