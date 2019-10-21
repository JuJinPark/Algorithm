package main.java.Kakao;

import java.util.Arrays;

public class ConvertBrackets {

    public String solution(String p) {

        String answer = "()(())()";
        return answer;
    }

    private String recur(String w) {

        if (w.isEmpty()) {
            return "";
        }
        UV uv = splitIntoBalancedBrackets(w);


        if (isCorrectBrackets(uv.getU())) {

            return uv.getU() + recur(uv.getV());

        }

        String front = "(" + recur(uv.getV()) + ")";
        String back = removeFirstandLastAndReverse(uv.getU());

        return front + back;


    }

    private UV splitIntoBalancedBrackets(String w) {


    }


}

class UV {
    private String[] uv;

    UV() {
        uv = new String[2];
    }

    public String getU() {
        return uv[0];
    }

    public String getV() {
        return uv[1];
    }
}




