package main.java.soony;





	import java.util.ArrayList;
    import java.util.Collections;
	import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BfsDfs {

	   static Node[] arr;
	   public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      int N =sc.nextInt();
	      int M =sc.nextInt();
	      int V= sc.nextInt();
	      
	      arr = new Node[N+1];
	      
	      for(int i=0;i<=N;i++) {
	         arr[i] = new Node(i); 
	      }
	      //인접리스트만들기.
	      for(int i=0;i<M;i++) {
	         Node fir =arr[sc.nextInt()];
	         Node sec =arr[sc.nextInt()];
	         if(!fir.adj.contains(sec))    fir.adj.add(sec);
	         if(!sec.adj.contains(fir))    sec.adj.add(fir);
	      }
	      
	      for(int i=0;i<M;i++) {
	    	  System.out.println(arr[i]);
	    	  System.out.println(arr[i].adj);
	      }
	     
	      //정렬하기
	      for(int i=1;i<=N;i++) {
	         Collections.sort(arr[i].adj,new Comparator<Node>() {
	            @Override
	            public int compare(Node N1, Node N2) {
	               System.out.println("N1.node : "+N1.node+"N2.node : "+N2.node);
	               if(N1.node > N2.node) return 1;
	               else if(N1.node < N2.node) return -1;       
	               return 0;
	            }
	         });
	      }
	      
	      
	      
	      
	      for(int i=0;i<M;i++) {
	    	  System.out.println(arr[i]);
	    	  System.out.println(arr[i].adj);
	      }
	      DFS(V);
	    //  BFS(V);
	   }
	   
	   static void DFS(int start) {
	      //시작점 넣기
	      Node root = arr[start];
	      Queue<Node> que = new LinkedList<Node>();
	      que.add(root);
	      root.check = true;
	      while(!que.isEmpty()) {
	         Node ano =  que.poll();
	       
	         for(Node n : ano.adj) {
	            if(n.check==false) {
	               n.check=true;
	               que.add(n);
	            }
	         }
	         System.out.println(ano.node);
	      }
	      
	      
	      
	   }
	   static void BFS(int start) {
	      
	   }
	}


	class Node{
	   int node;
	   ArrayList<Node> adj;
	   boolean check;
	   Node(int node){
	      this.node =node;
	      this.check =false;
	      adj =  new ArrayList<Node>();
	   }
	   
	  public String toString() {
		   return node+"";
	   }
	
}
