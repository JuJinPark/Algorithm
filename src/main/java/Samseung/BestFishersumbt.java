package main.java.Samseung;
import java.util.HashMap;

import java.util.Map;
import java.util.Map.Entry;

import java.util.Scanner;
public class BestFishersumbt {
	static int row;
	static int col;
	static int sharkNmb;
	
	static Map<SharkCor,shark> [] sharkBags;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	row=sc.nextInt();
	 col=sc.nextInt();
	sharkNmb=sc.nextInt();
		sharkBags = new HashMap [col+1];
		
		for(int i=0;i<sharkNmb;i++) {
			shark tmpshark=new shark(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
			SharkCor tmpSharkcor=new SharkCor(tmpshark.row,tmpshark.col);
			if(sharkBags[tmpshark.col]==null) {
				Map<SharkCor,shark> tmpBags =new HashMap();
				
				tmpBags.put(tmpSharkcor,tmpshark);
				
				sharkBags[tmpshark.col]=tmpBags;
			}else {
				sharkBags[tmpshark.col].put(tmpSharkcor,tmpshark);
			}
			
		
			
		}
		
		System.out.println(getCatchedSize());

	}
	public static int getCatchedSize() {
		int size=0;
		if(sharkNmb==0) {
			return size;
		}
		for(int i=1;i<=col;i++) {
			if(sharkBags[i]!=null) {
				
				shark catchedShark=catchingShark(sharkBags[i]);

				
				if(catchedShark!=null) {
				
					size+=catchedShark.size;
				}
				
			}

			sharkBags=getNewSharkBags();
	

		
		}
		
		return size;
	}
	public static shark catchingShark(Map<SharkCor, shark> map) {
		shark catchableShark=null;
		SharkCor catchableSharkKey=null;
			int closestRow=Integer.MAX_VALUE;
			
			 for (Entry<SharkCor, shark> entry : map.entrySet()) {
				if(entry.getKey().row<closestRow) {
					catchableSharkKey=entry.getKey();
					catchableShark=entry.getValue();
				}

		        }
			
				if(catchableSharkKey!=null) {
					map.remove(catchableSharkKey);
				}
				
		
		return catchableShark;
	}
	public static Map<SharkCor,shark> [] getNewSharkBags() {
		Map<SharkCor,shark> [] tmpsharkBags = new HashMap [col+1];
		
		for(int i=1;i<sharkBags.length;i++) {
			
			if(sharkBags[i]!=null) {
			 for (Entry<SharkCor, shark> entry : sharkBags[i].entrySet()) {

		
			putToNewBags(tmpsharkBags,moveShark(entry.getValue()));

				
			 
			 }
		}
			
		}
		return tmpsharkBags;
		
	}
public static shark moveShark(shark shrk) {
		
		int crtP=0;
		int maxlength=0;
		
		int nxtP=0;
		//상 하
		if(shrk.dir<=2) {
			crtP=shrk.row;
			maxlength=row;
		}else {
			//좌우 
			crtP=shrk.col;
			maxlength=col;
			
		}
		//상 좌
		if(shrk.dir==1||shrk.dir==4) {
			crtP=(maxlength+1)-crtP;
			
		}
		
		if(maxlength==1) {
			nxtP=1;
		}else if(maxlength==2){
			nxtP=crtP+shrk.speed;
			nxtP=1;
			if(nxtP%2==0) {
				nxtP=2;
			}
		}else {
			
			
			
			nxtP=crtP+shrk.speed;
			//이동할 위치 구하기 maxlength*2는 왕복한번이다.
			if(nxtP>=maxlength*2) {
				nxtP=nxtP-( ( (maxlength-1)*2 )*( nxtP/((maxlength*2)-1)) );
			}
			
			if(nxtP>maxlength) {
				nxtP=(maxlength)-(nxtP-maxlength);
				//뱡향 반대로하기
				if(shrk.dir==1) {
					shrk.dir=2;
				}else if(shrk.dir==2) {
					shrk.dir=1;
				}else if(shrk.dir==3) {
					shrk.dir=4;
			}else if(shrk.dir==4) {
				shrk.dir=3;
				
		}
			}
		
		}
		
		//상 좌 일떄 다시올바른 값으로 되돌리기
		if(shrk.dir==1||shrk.dir==4) {
			nxtP=(maxlength+1)-nxtP;
			
		}
		
		
		
		
		//이동한 값적용하기
		
		if(shrk.dir<=2) {
			shrk.row=nxtP;
			
		}else {
			//좌우
			shrk.col=nxtP;
		
			
		}
		//System.out.println(shrk);
		return shrk;
	}

public static void putToNewBags(Map<SharkCor, shark>[] tmpsharkBags, shark newShark) {
	SharkCor newSharkCor= new SharkCor(newShark.row,newShark.col);
	if(tmpsharkBags[newShark.col]==null) {
		Map<SharkCor,shark> tmpBags =new HashMap();
		
		
		tmpBags.put(newSharkCor,newShark);
		tmpsharkBags[newShark.col]=tmpBags;
		
	}else {
		
		if(tmpsharkBags[newShark.col].containsKey(newSharkCor)) {
			shark firstShark=tmpsharkBags[newShark.col].get(newSharkCor);
			
			if(firstShark.size<newShark.size) {
				tmpsharkBags[newShark.col].put(newSharkCor,newShark);
				
			}
			
		}else {
			tmpsharkBags[newShark.col].put(newSharkCor,newShark);
		}
		
		
	
	}

}
}
