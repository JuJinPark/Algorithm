package main.java.leetcode.medium;

public class StringToInteger_8 {
    private final char WHITE_CHAR=' ';
    private final char MINUS_CHAR='-';
    private final char PLUS_CHAR='+';

//    public int myAtoi(String str) {
//        String cleanedStr=str.trim();
//        StringBuilder result = new StringBuilder();
//        for(char ch:cleanedStr.toCharArray()){
//            if(ch==WHITE_CHAR && result.length()==0){
//                continue;
//            }
//            if(Character.isDigit(ch)){
//                result.append(ch);
//            }else if(ch == MINUS_CHAR || ch == PLUS_CHAR){
//                if(result.length()==0){
//                    result.append(ch);
//                }else {
//                    break;
//                }
//
//            }else{
//                break;
//            }
//        };
//        if(result.toString().equals("") || result.toString().equals(MINUS_CHAR+"") ||result.toString().equals(PLUS_CHAR+"") ){
//            return 0;
//        }
//        Double resultInDouble= Double.valueOf(result.toString());
//        if(resultInDouble>Integer.MAX_VALUE){
//            return Integer.MAX_VALUE;
//        }
//        if(resultInDouble<Integer.MIN_VALUE){
//            return Integer.MIN_VALUE;
//        }
//        return Integer.parseInt(result.toString());
//    }


    public int myAtoi(String str) {
        String cleanedStr=str.trim();
        int result=0;
        int sign  =1;
        int idxToCheckFrom=0;

        if(cleanedStr.length()==0){
            return 0;

        }
        if(cleanedStr.charAt(0)==MINUS_CHAR) {
            sign=-1;
            idxToCheckFrom=1;
        }else if(cleanedStr.charAt(0)==PLUS_CHAR){
            idxToCheckFrom=1;
        }

        for (int i = idxToCheckFrom; i < cleanedStr.length() ; i++) {
            char targetChar = cleanedStr.charAt(i);
            if(!Character.isDigit(targetChar)){
                break;
            }
            int toAddNum=targetChar-'0';

            if(isOverFlow(result,sign,toAddNum)){
                if(sign==1){
                    return Integer.MAX_VALUE;
                }else{
                    return Integer.MIN_VALUE;
                }
            }


            result=result*10+(toAddNum);
        }
        return result*sign;
    }

    private boolean isOverFlow(int result, int sign, int toAddNum) {
        int maxCurrentResultValue=Integer.MAX_VALUE/10;
        if(sign==-1) {
            maxCurrentResultValue = Integer.MIN_VALUE/10*-1;
        }
        if(maxCurrentResultValue<result){
            return true;
        }

        int maxLastDigitNum=Integer.MAX_VALUE%10;
        if(sign==-1) {
            maxLastDigitNum = Integer.MIN_VALUE%10*-1;
        }

        if(maxCurrentResultValue==result && maxLastDigitNum<toAddNum)
        {
            return true;
        }

        return false;

    }

}
