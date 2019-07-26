package Kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class OpenChat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] record= {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		OpenChatSolution ss= new OpenChatSolution();
		
		
		
		System.out.println(Arrays.toString(ss.solution(record)));
	}

}

class OpenChatSolution {
	static HashMap<String,String> commandInKor= new HashMap();
	static HashMap<String,String> nickNamePerId= new HashMap();
	
	OpenChatSolution(){
		commandInKor.put("Enter","���Խ��ϴ�.");
		commandInKor.put("Leave","�������ϴ�.");
	}
	
    public String[] solution(String[] record) {
    	
    	
    	List<String> answer= new ArrayList();
    	List<String> cmdlist=new ArrayList();
    	
    	
    	
    	for(int i=0;i<record.length;i++) {
    		
    		String[] input=record[i].split(" ");
    		//System.out.println(Arrays.toString(input));
    		String command=input[0];
    	
    		
    		if("Enter".equals(command)||"Change".equals(command)) {
    			String id=input[1];
        		String nickname=input[2];
    			nickNamePerId.put(id, nickname+"��");
    			
    			
    		}
    		
    		if("Enter".equals(command)||"Leave".equals(command)) {
    		cmdlist.add(record[i]);
    		}	
    	}
    	
    	for(String records:cmdlist) {
    		String[] input=records.split(" ");
    		String command=input[0];
    		String id=input[1];
    		
    		
    		if(!"Change".equals(command)) {
    			String tmpanswer=nickNamePerId.get(id)+"�� "+commandInKor.get(command);
    			
    			
    			
    			answer.add(tmpanswer);
    		
    		
    		}
    		
    	}
    	
    	
    	//System.out.println(Arrays.toString(answer.toArray()));
    	
       
        return answer.toArray(new String[answer.size()]);
    }
    
    
}
