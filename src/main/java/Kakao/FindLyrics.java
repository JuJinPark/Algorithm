package main.java.Kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLyrics {
//    static Trie normalTrie = new Trie();
//    static Trie reverseTrie= new Trie();
    static Trie[] normalTrie = new Trie[10001];
    static  Trie[] reverseTrie = new Trie[10001];

    public int[] solution(String[] words, String[] queries) {


        insertWords(words);


     return getAnswers(queries);


    }

    public void insertWords(String[] words){



        for(int i=0;i<words.length;i++){

            if(normalTrie[words[i].length()]==null){
                normalTrie[words[i].length()]=new Trie();
            }

            if(reverseTrie[words[i].length()]==null){
                reverseTrie[words[i].length()]=new Trie();
            }


            normalTrie[words[i].length()].insert(words[i]);
            String reversed= new StringBuffer(words[i]).reverse().toString();
            reverseTrie[words[i].length()].insert(reversed);

        }

    }

    public int[] getAnswers(String[] queries){
        int [] answer = new int[queries.length];
        Trie trie;
        Map<String,Integer> memory= new HashMap<>();

        for(int i=0;i<queries.length;i++){

            if(memory.containsKey(queries[i])){
                answer[i]=memory.get(queries[i]);
                continue;
            }

            String wordOnly=queries[i].replaceAll("\\?","");
            if(isPrefix(queries[i])){
                trie=normalTrie[queries[i].length()];
            }else{
                wordOnly=new StringBuilder(wordOnly).reverse().toString();
                trie=reverseTrie[queries[i].length()];
            }


            int questionNmb=queries[i].length()-wordOnly.length();
            TreeNode node=trie.getPrefixNode(wordOnly);
            answer[i]=trie.countChdOfNode(node,questionNmb);
            memory.put(queries[i],answer[i]);
//trie null 체크 한번 해주어야 함
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
//            String childrenFullLetter=word.substring(i);

//            Map<Integer,List<String>> childrenPerLength= current.getChildrenPerLength();
//            if(childrenPerLength.containsKey(childrenFullLetter.length())){
//                childrenPerLength.get(childrenFullLetter.length()).add(childrenFullLetter);
//            }else{
//                List list=new ArrayList();
//                list.add(childrenFullLetter);
//                childrenPerLength.put(childrenFullLetter.length(),list);
//            }
//            Map<Integer,Integer> childrenPerLength= current.getChildrenPerLength();
//            if(childrenPerLength.containsKey(childrenFullLetter.length())){
//                int crtnum=childrenPerLength.get(childrenFullLetter.length());
//                childrenPerLength.put(childrenFullLetter.length(),crtnum+1);
//            }else{
////                List list=new ArrayList();
////                list.add(childrenFullLetter);
//                childrenPerLength.put(childrenFullLetter.length(),1);
//            }
            current.addCount();
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

//        List<String> chdList=prefix.getChildrenPerLength().get(chdLength);
//        if(chdList==null) return 0;
//        return chdList.size();
//        Integer childNum=prefix.getChildrenPerLength().get(chdLength);
//        if(childNum==null) return 0;
        return prefix.getCount();
    }


}

class TreeNode{
    private char letter;
    private Map<Character,TreeNode> children=new HashMap<>();
    private int count;
//    private Map<Integer,List<String>> childrenPerLength=new HashMap<>();
//    private Map<Integer,Integer> childrenPerLength=new HashMap<>();
    private boolean isEndOfWord;

    TreeNode(char letter){
        this.letter=letter;
    }

    public Map<Character,TreeNode> getChildren(){
        return children;
    }

    public void addCount(){
        count++;
    }

    public int getCount(){
        return count;
    }

//    public Map<Integer,List<String>> getChildrenPerLength(){
//        return childrenPerLength;
//    }

//        public Map<Integer,Integer> getChildrenPerLength(){
//        return childrenPerLength;
//    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}


