package main.java.Zoom;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Zum3 {

    public static void main(String[] args) {
        int[] array= {1,2,3,4};
//        List<Integer> list = (List<Integer>) Arrays.asList(array);
//        list.addAll();
        solution3 ss = new solution3();
        String S="John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
        String C="Example";
        System.out.println( ss.solution(S,C));

    }

}

class solution3 {

    public String solution(String S, String C){
        String companyName=C.toLowerCase();
        String[] nameList=S.split("; ");
        String[] result=new String[nameList.length];
        HashMap<String,Integer> uniqueIdAndNum= new HashMap<>();


        for(int i=0;i<nameList.length;i++){
           String[] names=nameList[i].split(" ");
           String firstName=changeToEmailName(names[0]);
           String lastName=changeToEmailName(names[names.length-1]);
           String emailId=lastName+"_"+firstName;

           if(uniqueIdAndNum.containsKey(emailId)){
               int count=uniqueIdAndNum.get(emailId)+1;
               uniqueIdAndNum.put(emailId,count);
           }else{
               uniqueIdAndNum.put(emailId,1);
           }

           String numForName="";
           if(uniqueIdAndNum.get(emailId)>1){
               numForName=uniqueIdAndNum.get(emailId)+"";
           }
           result[i]=emailId+numForName+"@"+companyName;

        }

       return printResult(nameList,result);





    }

    private String changeToEmailName(String name){
        return name.toLowerCase().replaceAll("-","");

    }


    private String printResult(String[] inputs,String[] result){
        String separator="; ";
        StringBuilder resultInString= new StringBuilder();
        for(int i=0;i<result.length;i++){
            resultInString
                    .append(inputs[i])
                    .append(" <")
                    .append(result[i])
                    .append(">")
                    .append(separator);
        }
        return resultInString.toString();

    }

}
