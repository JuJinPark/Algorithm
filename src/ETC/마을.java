package ETC;



public class ¸¶À» {

	public static void main(String[] args) {
		
		dd ss= new dd();
		System.out.println(ss.solution(5,new int[] {3,5,4,1,2}));
		
		System.out.println(ss.solution(5,new int[] {1,2,3,4,5}));

	}
	
	

}

class dd{
	public int solution(int N, int[] sequence) {
		int rslt=0;
		int start=1;
		
		for(int i=0;i<N;i++) {
			int a=sequence[i]-start;
			if(a<0) {
				a=N+a;
			}
			int b=start-sequence[i];
			if(b<0) {
				b=N+b;
			}
			
			
			rslt+=Math.min(a, b);
			start=sequence[i];
		/*	System.out.println(rslt);*/
		}
		
		
		return rslt;
		}
	
	
	}