package main.java.Kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLyrics {
    static Trie prefixTrie;
    static Trie suffixTrie;

    public int[] solution(String[] words, String[] queries) {

        insertWords(words);

     return getAnswers(queries);


    }

    public void insertWords(String[] words){
        prefixTrie = new Trie();
        suffixTrie = new Trie();

        for(int i=0;i<words.length;i++){

            prefixTrie.insert(words[i]);
            String reversed= new StringBuffer(words[i]).reverse().toString();
            suffixTrie.insert(reversed);

        }

    }



    public int[] getAnswers(String[] queries){
        int [] answer = new int[queries.length];
        Trie trie;
         Map<String,Integer> cache= new HashMap<>();

        for(int i=0;i<queries.length;i++){

            if(cache.containsKey(queries[i])){
                answer[i]=cache.get(queries[i]);
                continue;
            }

            String wordOnly=extractWordFromQuery(queries[i]);
            trie=getTrie(queries[i]);
            answer[i]=trie.getCount(queries[i],wordOnly);
            cache.put(queries[i],answer[i]);

        }
    return  answer;
    }

    private String extractWordFromQuery(String query){
        String wordOnly=query.replaceAll("\\?","");
        if(isSuffix(query)){
            wordOnly=new StringBuilder(wordOnly).reverse().toString();
        }
       return wordOnly ;
    }

    private Trie getTrie(String query){
        if(isPrefix(query)){
           return prefixTrie;
        }
        return suffixTrie;
    }


    private boolean isPrefix(String query){
        return query.indexOf("?")!=0;
    }

    private boolean isSuffix(String query){
        return !isPrefix(query);
    }


}

class Trie{
    private TreeNode root;
    public Trie(){
        root=new TreeNode(' ');
    }

    public void insert(String word){
        TreeNode current=root;
        for (int i = 0; i < word.length(); i++) {

            current = current.getChildren().computeIfAbsent(word.charAt(i), c-> new TreeNode(c));

        }
        current.setEndOfWord(true);

    }

    public TreeNode getNode(String prefix){
        TreeNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            TreeNode node = current.getChildren().get(ch);
            if (node == null) {
                return null;
            }
            current = node;
        }
        return current;
    }

    public int getCount(String query,String wordOnly){
        TreeNode nodeForWord=getNode(wordOnly);
        if(nodeForWord==null) return 0;
        return countChd(nodeForWord,0,query.length()-wordOnly.length());
    }



    public int countChd(TreeNode prefix,int depth,int qeustionNmb){
        if (depth==qeustionNmb){
            if(prefix.isEndOfWord()){
                return 1;
            }
        }
        int count=0;
        for(TreeNode child:prefix.getChildren().values()){
            count+=countChd(child,depth+1,qeustionNmb);
        }
        return count;
    }




}

class TreeNode{
    private char letter;
    private Map<Character,TreeNode> children=new HashMap<>();
    private boolean isEndOfWord;

    TreeNode(char letter){
        this.letter=letter;
    }

    public Map<Character,TreeNode> getChildren(){
        return children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}


