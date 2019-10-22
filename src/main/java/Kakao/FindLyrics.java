package main.java.Kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLyrics {
    static Trie normalTrie = new Trie();
    static Trie reverseTrie= new Trie();

    public int[] solution(String[] words, String[] queries) {


        insertWords(words);


     return getAnswers(queries);


    }

    public void insertWords(String[] words){
        for(int i=0;i<words.length;i++){
            normalTrie.insert(words[i]);
            String reversed= ( new StringBuffer(words[i]) ).reverse().toString();
            reverseTrie.insert(reversed);

        }

    }

    public int[] getAnswers(String[] queries){
        int [] answer = new int[queries.length];
        Trie trie;
        for(int i=0;i<queries.length;i++){

            if(isPrefix(queries[i])){
                trie=normalTrie;
            }else{
                trie=reverseTrie;
            }
            String wordOnly=queries[i].replaceAll("\\?","");
            int questionNmb=queries[i].length()-wordOnly.length();
            TreeNode prefix=trie.getPrefixNode(wordOnly);
            answer[i]=trie.countChdOfNode(prefix,questionNmb);
        }
    return  answer;
    }

    private boolean isPrefix(String query){
        return query.indexOf("?")!=0;
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
            String childrenFullLetter=word.substring(i);

            Map<Integer,List<String>> childrenPerLength= current.getChildrenPerLength();
            if(childrenPerLength.containsKey(childrenFullLetter.length())){
                childrenPerLength.get(childrenFullLetter.length()).add(childrenFullLetter);
            }else{
                List list=new ArrayList();
                list.add(childrenFullLetter);
                childrenPerLength.put(childrenFullLetter.length(),list);
            }

            current = current.getChildren().computeIfAbsent(word.charAt(i), c-> new TreeNode(c));

        }
        current.setEndOfWord(true);

    }

    public TreeNode getPrefixNode(String prefix){
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

    public int countChdOfNode(TreeNode prefix,int chdLength){
        if (prefix==null) return 0;

        List<String> chdList=prefix.getChildrenPerLength().get(chdLength);
        if(chdList==null) return 0;
        return chdList.size();
    }


}

class TreeNode{
    private char letter;
    private Map<Character,TreeNode> children=new HashMap<>();;
    private Map<Integer,List<String>> childrenPerLength=new HashMap<>();;
    private boolean isEndOfWord;

    TreeNode(char letter){
        this.letter=letter;
    }

    public Map<Character,TreeNode> getChildren(){
        return children;
    }

    public Map<Integer,List<String>> getChildrenPerLength(){
        return childrenPerLength;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}


