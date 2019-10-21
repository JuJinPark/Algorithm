package main.java.ETC;


import org.apache.commons.lang.RandomStringUtils;

public class 짧은문자열찾기 {

	public static void main(String[] args) {
		FG ss= new FG();
//		System.out.println(ss.solution("abababab"));
		System.out.println(ss.solution("abcabcabd"));
//		System.out.println(ss.solution("abcabc"));
		
//		 byte[] array = new byte[1000000]; // length is bounded by 7
//		    new Random().nextBytes(array);
//		    String generatedString = new String(array, Charset.forName("UTF-8"));
//			System.out.println(ss.solution(generatedString));
			
			String generatedStringa = RandomStringUtils.randomAlphabetic(50).toLowerCase();
//			 System.out.println(generatedStringa);
			 System.out.println(ss.solution(generatedStringa));

	}

}

class FG{
	public int solution(String input) {
		int length=input.length();
		
		for(int i=1;i<=(length/2);i++) {
			if(length%i==0) {
				boolean flag=true;
				String first=input.substring(0,i);
				
				for(int j=1;j<=(length/i)-1;j++) {
				int start=i*j;
				int end=start+i;
				String second=input.substring(start,end);
				System.out.println(first+"."+second);
				if(!first.equals(second)) {
					flag=false;
					break;
					
					
				}
				
					
					
					
				}
				if(flag) {
					return i;
				}
				
				
			}
			
		
		}
		
		return length;
	}
}
