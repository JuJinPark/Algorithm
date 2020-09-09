package main.java.leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximunDepthOfNaryTree_559 {
    public int maxDepth(Node root) {
        if(root==null){
            return  0;
        }
        Queue<Node> queue=new LinkedList<Node>();
        queue.offer(root);
        int depth=0;
        while(!queue.isEmpty()){
            depth++;
            int size=queue.size();
            for (int i = 0; i <size ; i++) {
                Node poll = queue.poll();
                List<Node> children = poll.children;
                for (int j = 0; j < children.size(); j++) {
                    queue.offer(children.get(j));
                }
            }
        }
        return depth;

    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};