package ETC;

import java.util.ArrayList;
import java.util.Arrays;



public class ���ĺ� {
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
		
		
		//��)ī��-ABACDEFG  linenum �迭(ù���� �ε����� A �״��� B)-{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,.....}
		//alphabetnum(ù���� �ε����� A �״��� B)-{2,1,1,1,1,1,1,0,0,0,0,0,0....}
		for(int i=1;i<=card.length;i++) {
			for(int j=0;j<card[i-1].length();j++) {
				char crt=card[i-1].charAt(j);
				int idx=crt-'A';
				linenum[idx]=i;
				alphabetnum[idx]+=1;
			}
		}
		
		
		//��) �ܾ� GPAQM ���⼭ ���ܾ ���ĺ� �ʿ䰹�� ���� checkalnum �迭 (ù���� �ε����� A �״��� B)-{1,0,0,0,0,0,1,0,0,}
		//checkline �迭���� LINENUM�迭���� �ش� ���ĺ��� ������ ã�ƿͼ� �ش� �ε����� ������ 1���� (G��1�����ٿ������� 1�ε����� 1����)
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
	
	//��� �� ����ؼ� ��������� Ȯ��
	public int checkline(int[] array) {
		int rslt=0;
		
		for(int i=0;i<array.length;i++) {
		
			
			
			rslt+=array[i];
		}
	
		return rslt;
	}
	
	//�Ѵܾ �ش� ���ĺ��� �ʿ䰹���� �� ī�� ���� ��
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
