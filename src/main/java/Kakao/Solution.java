//package main.java.Kakao;
//import java.util.HashMap;
//import java.util.Map;
//
//public class Solution {
//    public int[] solution(String[] words, String[] queries) {
//        int[] answer = new int[queries.length];
//        Trie trie = new Trie();
//        Trie revTrie = new Trie();
//        for(String word: words) {
//            trie.insert(word.length() + word);
//            revTrie.insert(word.length() + new StringBuilder(word).reverse().toString());
//        }
//        int i = 0;
//        for(String query: queries) {
//            int start = query.charAt(0) == '?' ? query.lastIndexOf('?') + 1 : 0;
//            int end = query.charAt(0) == '?' ? query.length() : query.indexOf('?');
//            String sub = query.substring(start, end);
//            String revSub =  new StringBuilder(sub).reverse().toString();
//            if(query.charAt(0) != '?') {
//                TrieNode t = trie.searchNode(query.length() + sub);
//                if(t == null) answer[i] = 0;
//                else answer[i] = t.count;
//            } else {
//                TrieNode t = revTrie.searchNode(query.length() + revSub);
//                if(t == null) answer[i] = 0;
//                else answer[i] = t.count;
//            }
//            i++;
//        }
//        return answer;
//    }
//}
//
//class TrieNode {
//    char c;
//    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
//    boolean isLeaf;
//    int count=1;
//    public TrieNode() {}
//    public TrieNode(char c){
//        this.c = c;
//    }
//}
//class Trie {
//    private TrieNode root;
//    public Trie() {
//        root = new TrieNode();
//    }
//    public void insert(String word) {
//        HashMap<Character, TrieNode> children = root.children;
//        for(int i=0; i<word.length(); i++){
//            char c = word.charAt(i);
//            TrieNode t;
//            if(children.containsKey(c)){
//                t = children.get(c);
//                t.count++;
//            }else{
//                t = new TrieNode(c);
//                children.put(c, t);
//            }
//            children = t.children;
//            if(i==word.length()-1) t.isLeaf = true;
//        }
//    }
//    public void revInsert(String word) {
//        HashMap<Character, TrieNode> children = root.children;
//        for(int i=word.length()-1; i>=0; i--){
//            char c = word.charAt(i);
//            TrieNode t;
//            if(children.containsKey(c)){
//                t = children.get(c);
//                t.count++;
//            }else{
//                t = new TrieNode(c);
//                children.put(c, t);
//            }
//            children = t.children;
//            if(i==word.length()-1) t.isLeaf = true;
//        }
//    }
//    public TrieNode searchNode(String str){
//        Map<Character, TrieNode> children = root.children;
//        TrieNode t = null;
//        for(int i=0; i<str.length(); i++){
//            char c = str.charAt(i);
//            if(children.containsKey(c)){
//                t = children.get(c);
//                children = t.children;
//            }else{
//                return null;
//            }
//        }
//        return t;
//    }
//}