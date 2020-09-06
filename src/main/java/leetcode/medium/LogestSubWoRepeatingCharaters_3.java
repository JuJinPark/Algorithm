package main.java.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;

public class LogestSubWoRepeatingCharaters_3 {
    public int lengthOfLongestSubstring(String s) {

     int maxLength=0;
     int start=0;

        HashMap<Character, Integer> stringIndex = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length() ; i++) {

            if(stringIndex.containsKey(s.charAt(i))){
                start =  Math.max(stringIndex.get(s.charAt(i)),start);
            }
            maxLength = Math.max(maxLength,i-start+1);

            stringIndex.put(s.charAt(i),i+1);
        }

        return maxLength;


    }

    public int bruteForce(String s){
        int length=s.length();
        while(length>1){
            if(check(s,length)){
                return length;
            }
            length--;
        }

        return length;
    }

    public boolean check(String word,int length){
        int start =0;
        while(true){
            try{
                String subString = createWord(word, start, length);
                if(checkRepeat(subString)){
                    return true;
                }
                start++;
            }catch (IllegalArgumentException ex){
                return false;
            }
        }


    }

    public String createWord(String word,int start,int length){
        int end =start+length;
        if(end>word.length()){
            throw new IllegalArgumentException("out of Index");
        }
        return word.substring(start,end);
    }

    public boolean checkRepeat(String word){

        HashSet<Character> characters = new HashSet<>();
        for (int i = 0; i < word.length() ; i++) {
           if( characters.contains(word.charAt(i))){
               return false;
           }
            characters.add(word.charAt(i));
        }
        return true;
    }
}
