package Samseung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EncryptedText3 {

	static LinkedList<Integer> result = new LinkedList ();
	//static Scanner sc= new Scanner(System.in);
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		 StringTokenizer st;
		for(int i=0;i<10;i++) {
			
			
			int encrptedTextNmb=Integer.parseInt(br.readLine());;
			
			 st = new StringTokenizer(br.readLine(), " ");
			    while(encrptedTextNmb-- > 0){
		         
		              result.add(Integer.parseInt(st.nextToken()));
		            
		          }

			
			
			 st = new StringTokenizer(br.readLine(), " ");
			int cmdNmb=Integer.parseInt(st.nextToken());

			 st = new StringTokenizer(br.readLine(), " ");		
			while(cmdNmb>0) {
				
				String cmd=st.nextToken();
				excuteCommand(cmd,st);
				
				
				cmdNmb--;
			}
			
			
			
			
			printResult(result,i);
			result.clear();
			
		}
		br.close();
		
		
		

	}
	
	public static void excuteCommand(String cmd,StringTokenizer st) {
		int idx=Integer.parseInt(st.nextToken());
		int number=Integer.parseInt(st.nextToken());
			
			if("I".equals(cmd)) {
			
				insert(idx,number,st);
				
			}else if("D".equals(cmd)) {
				delete(idx,number);
				
			}else if("A".equals(cmd)) {

				addLast(idx,number,st);
			}
		
	}
	
	public static void insert(int idx,int number, StringTokenizer st) {
		
		while(number --> 0) {
			result.add(idx++,Integer.parseInt(st.nextToken()));
		}
		
//		for(int i=0;i<number;i++) {
//			
//		}
		
		
		
	}
	
	public static void addLast(int idx,int number, StringTokenizer st) {
		
		while(number --> 0) {
			result.addLast(Integer.parseInt(st.nextToken()));
		}
	
	}
	
	public static void delete(int idx,int number) {
		while(number --> 0) {
			result.remove(idx);
		}
//		for(int i=0;i<number;i++) {
//			
//			result.remove(idx);
//		}
	}
	public static void printResult(LinkedList<Integer> list,int testCaseNmb) {
		
		StringBuilder sb = new StringBuilder();
		System.out.print("#" + (testCaseNmb + 1) + " ");
		
		for (int i = 0; i < 10; i++) {

			if (list.isEmpty())
				break;
			sb.append(list.remove());
			sb.append(" ");
		}
		System.out.println(sb.toString());
//		System.out.print("#"+(testCaseNmb+1)+" ");
//		int min=Math.min(list.size(),10);
//		for(int j=0;j<min;j++) {
//			System.out.print(list.get(j)+" ");
//		}
//		System.out.println();
	}
	
	
	

}
