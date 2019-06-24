package ETC;

import java.util.ArrayList;
import java.util.Arrays;



public class 알파벳 {
	public static void main(String[] args) {
		dds ss= new dds();
		String[] arr =  {"ABACDEFG","NOPQRSTU","HIJKLKMM"};
	String[] arr2 = {"GPAQM","GPMZ","EFU","MMNA"};
//		String[] arr2 = {"AGPAQMA"};
		System.out.println(Arrays.toString(ss.solution(arr, arr2))); 
		
		System.out.println(Arrays.toString(ss.solution(new String[] {"AABBCCDD","KKKKJJJJ","MOMOMOMO"},new String[] {"AAAAKKKKKMMMMM","ABCDKJ"}))); 
	}
}

class dds{
	public String [] solution(String[] card, String [] word) {
		ArrayList<String> rslt= new ArrayList();
		int[] linenum = new int[26];
		int[] alphabetnum = new int[26];
		
		
		//예)카드-ABACDEFG  linenum 배열(첫번쨰 인덱스가 A 그다음 B)-{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,.....}
		//alphabetnum(첫번쨰 인덱스가 A 그다음 B)-{2,1,1,1,1,1,1,0,0,0,0,0,0....}
		for(int i=1;i<=card.length;i++) {
			for(int j=0;j<card[i-1].length();j++) {
				char crt=card[i-1].charAt(j);
				int idx=crt-'A';
				linenum[idx]=i;
				alphabetnum[idx]+=1;
			}
		}
		
		
		//예) 단어 GPAQM 여기서 각단어에 알파벳 필요갯수 기입 checkalnum 배열 (첫번쨰 인덱스가 A 그다음 B)-{1,0,0,0,0,0,1,0,0,}
		//checkline 배열에는 LINENUM배열에서 해당 알파벳읠 라인을 찾아와서 해당 인덱스에 무조건 1기입 (G가1번쨰줄에있으면 1인덱스에 1기입)
		for(int i=0;i<word.length;i++) {
			int[] checkline=new int[4];
			int[] checkalnum=new int[26];
			
			for(int j=0;j<word[i].length();j++) {
				char crt=word[i].charAt(j);
				int idx=crt-'A';

				int linenumb=linenum[idx];
				checkline[linenumb]=1;
				checkalnum[idx]+=1;
				
			}
			
			if(checkline(checkline)==3) {
				if(checknum(checkalnum,alphabetnum)) {
					rslt.add(word[i]);
				}
			}
		}
		
		if(rslt.isEmpty()) {
			rslt.add("-1");
			
		}
		
		
		return rslt(rslt);
		
	}
	
	//모든 줄 사용해서 만들었는지 확인
	public int checkline(int[] array) {
		int rslt=0;
		
		for(int i=0;i<array.length;i++) {
		
			
			
			rslt+=array[i];
		}
	
		return rslt;
	}
	
	//한단어에 해당 알파벳의 필요갯수와 실 카드 갯수 비교
	public boolean checknum(int[] checkalnum,int[] alphabetnum) {
		

		for(int i=0;i<checkalnum.length;i++) {
		
			if(alphabetnum[i]<checkalnum[i]) {
				return false;
			}
			
		
		}
		return true;
	
	}
	
	public String[] rslt(ArrayList<String> list) {
		String[] rslt= new String[list.size()];
				for(int i=0;i<list.size();i++) {
					rslt[i]=(String) list.get(i);
				}
		return rslt;
	}
}
