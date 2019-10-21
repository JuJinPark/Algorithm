package main.java.DP;

public class 시간차이 {
	public static void main(String[] args) {
		solsssas ss= new solsssas();
		System.out.println(ss.solution("AM 00:00:59", "PM 11:59:59"));
	}
}

class solsssas{
	public String solution(String start, String end) {
		return TimetoString(StrintoTime(end) - StrintoTime(start));
	}
	
	public int StrintoTime(String time) {
		int result = 0;
		
		String[] tmptime=time.substring(3).split(":");
			result+=Integer.parseInt(tmptime[0])*3600;
			result+=Integer.parseInt(tmptime[1])*60;
			result+=Integer.parseInt(tmptime[2]);
		
		if("PM".equals(time.substring(0,2))) {
			result+=(12*3600);
		}
		return result;
	}
	
	public String TimetoString(int time) {
		if(time<0) {
			time=time+(24*3600);
		}
	
		StringBuilder sb= new StringBuilder();
		
		int timestand=3600;
		
		int times[] = new int[3];
		int idx=0;
		while(time!=0) {
			int tmprslt=time/timestand;
			times[idx]=tmprslt;
			time=time-(timestand*tmprslt);
			timestand=timestand/60;
		idx++;
			
		}
		
		for(int i=0;i<times.length;i++) {
				if(times[i]<10) {
					sb.append("0");	
					sb.append(times[i]);
				}else {
					sb.append(times[i]);	
				}
			if(i<2) {
				sb.append(":");
			}
		}
		
		return sb.toString();
				
	}
}
