package Samseung;


import java.util.Comparator;
import java.util.HashMap;

import java.util.Map;
import java.util.Map.Entry;

import java.util.Scanner;


public class BestFisher {
	
	//sharkBags �迭�� �����ҽ�
		//�ε��������� ���� ��ġ�� �ִ� �� ���� ã�����־� ���� 
		//������ ������ �ѹ��� �̵���ų�� �迭��ü�� �ٽ� Ž���ؾ���
		//��ΰ� ���� ����� �� �����۵� �ش� ���� ���鼭 ã�ƾ���
	
	
	
	//sharkBags HashMap
		//�� �̵��� ������ ��ġ���ִ� ����� ������ ��ü�� ����
		//������ ���ò��� ��ƾ��� �� ã�����ؼ��� �ٽ� ��ü ����Ʈ Ž��
	
	
	//LinkedHashMap
	//
	
	
	//ArrayList �迭
	
	//priorityque �迭
		//���ò��� ���� ��� ã�Ⱑ ���� ������ ��� �̵��� ��ġ������ ��ü���� �Ҷ� ��ü�ϱ� 
	
		

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row=sc.nextInt();
		int col=sc.nextInt();
		int sharkNmb=sc.nextInt();
		Map<SharkCor,shark> [] sharkBags = new HashMap [col+1];
	
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
		
		
		
//		for(int i=1;i<col+1;i++) {
//			if(sharkBags[i]==null) {
//				System.out.println("�����");
//				continue;
//			}
//			
//		     for (Entry<SharkCor, shark> entry : sharkBags[i].entrySet()) {
//		            System.out.println("Key : " + entry.getKey() 
//						+ " Value : " + entry.getValue());
//		        }
//			
////			Map<SharkCor,shark> treeMap = new TreeMap(new SharkCompartor());
////			
////		treeMap
////			//sharkBags[i].sort(new SharkCompartor());
////			for(shark a: sharkBags[i]) {
////				System.out.println(a.toString()+"colnum"+i);
////			}
//		
//			
//		}
//		
		BestFishSol sol= new BestFishSol(row,col,sharkNmb,sharkBags);
		System.out.println(sol.getCatchedSize());

	}

}

class BestFishSol{
	int row;
	int col;
	int sharkNmb;
	
	Map<SharkCor,shark> [] sharkBags;
	
	BestFishSol(int row,int col,int sharkNmb,Map<SharkCor,shark> [] sharkBags){
		
		this.row=row;
		this.col=col;
		this.sharkNmb=sharkNmb;
		this.sharkBags=sharkBags;
		
		
		
	}
	
	public int getCatchedSize() {
		int size=0;
		if(sharkNmb==0) {
			return size;
		}
		for(int i=1;i<=col;i++) {
			if(sharkBags[i]!=null) {
				
				shark catchedShark=catchingShark(sharkBags[i]);
//				sharkBags[i].sort(new SharkCompartor());
				
				if(catchedShark!=null) {
					//System.out.println(catchedShark);
					size+=catchedShark.size;
				}
				
			}

			sharkBags=getNewSharkBags();
		System.out.println("-----"+i+"��");
			
			for(int k=0;k<sharkBags.length;k++) {
				System.out.println("-----"+k+"��");
				if(sharkBags[k]!=null) {
					  for (Entry<SharkCor, shark> entry : sharkBags[k].entrySet()) {
					    	
					    	
				            System.out.println("Key : " + entry.getKey() 
								+ " Value : " + entry.getValue());
				        }	
				}
			
					System.out.println("-----"+k+"��");
			}
		  
		 System.out.println("-----"+i+"��");
		
		}
		
		return size;
	}
	
	private shark catchingShark(Map<SharkCor, shark> map) {
		shark catchableShark=null;
		SharkCor catchableSharkKey=null;
			int closestRow=Integer.MAX_VALUE;
			
			 for (Entry<SharkCor, shark> entry : map.entrySet()) {
				if(entry.getKey().row<closestRow) {
					catchableSharkKey=entry.getKey();
					catchableShark=entry.getValue();
				}
				 
//				 System.out.println("Key : " + entry.getKey() 
//						+ " Value : " + entry.getValue());
		        }
			
				if(catchableSharkKey!=null) {
					map.remove(catchableSharkKey);
				}
				
		
		return catchableShark;
	}

	public Map<SharkCor,shark> [] getNewSharkBags() {
		Map<SharkCor,shark> [] tmpsharkBags = new HashMap [col+1];
		
		for(int i=1;i<sharkBags.length;i++) {
			
			if(sharkBags[i]!=null) {
			 for (Entry<SharkCor, shark> entry : sharkBags[i].entrySet()) {
				
			
				 
				 
			
			
			
		
			
			
			putToNewBags(tmpsharkBags,moveShark(entry.getValue()));
			
			
			
			
			
			
			
			
				
			 
			 }
		}
			//System.out.println();
		}
		return tmpsharkBags;
		
	}
	
	private shark moveShark(shark shrk) {
		int add=0;
		int crtP=0;
		int maxlength=0;
		
		//�� ��
		if(shrk.dir<=2) {
			crtP=shrk.row;
			maxlength=row;
		}else {
			//�¿� 
			crtP=shrk.col;
			maxlength=col;
			
		}
		
		if(shrk.dir==2||shrk.dir==3) {
			add=1;
		}else {
			add=-1;
		}
		
		for(int i=0;i<shrk.speed;i++) {
			if(crtP+add==0||crtP+add>maxlength) {
				//shrk.dir=shrk.dir+add;
				add=add*(-1);
				
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
				
				
			crtP=crtP+add;
		}
		
		
		if(shrk.dir<=2) {
		shrk.row=crtP;
		
	}else {
		//�¿�
		shrk.col=crtP;
	
		
	}
		
		
		
	
		
		return shrk;
	}

//	private shark moveShark(shark shrk) {
//		
//		int crtP=0;
//		int maxlength=0;
//		
//		int nxtP=0;
//		//�� ��
//		if(shrk.dir<=2) {
//			crtP=shrk.row;
//			maxlength=row;
//		}else {
//			//�¿� 
//			crtP=shrk.col;
//			maxlength=col;
//			
//		}
//		//�� ��
//		if(shrk.dir==1||shrk.dir==4) {
//			crtP=(maxlength+1)-crtP;
//			
//		}
//		
//		if(maxlength==1) {
//			nxtP=1;
//		}else if(maxlength==2){
//			nxtP=crtP+shrk.speed;
//			nxtP=1;
//			if(nxtP%2==0) {
//				nxtP=2;
//			}
//		}else {
//			
//			
//			
//			nxtP=crtP+shrk.speed;
//			//�̵��� ��ġ ���ϱ� maxlength*2�� �պ��ѹ��̴�.
//			if(nxtP>=maxlength*2) {
//				nxtP=nxtP-( ( (maxlength-1)*2 )*( nxtP/((maxlength*2)-1)) );
//			}
//			
//			if(nxtP>maxlength) {
//				nxtP=(maxlength)-(nxtP-maxlength);
//				//���� �ݴ���ϱ�
//				if(shrk.dir==1) {
//					shrk.dir=2;
//				}else if(shrk.dir==2) {
//					shrk.dir=1;
//				}else if(shrk.dir==3) {
//					shrk.dir=4;
//			}else if(shrk.dir==4) {
//				shrk.dir=3;
//				
//		}
//			}
//		
//		}
//		
//		//�� �� �ϋ� �ٽÿùٸ� ������ �ǵ�����
//		if(shrk.dir==1||shrk.dir==4) {
//			nxtP=(maxlength+1)-nxtP;
//			
//		}
//		
//		
//		
//		
//		//�̵��� �������ϱ�
//		
//		if(shrk.dir<=2) {
//			shrk.row=nxtP;
//			
//		}else {
//			//�¿�
//			shrk.col=nxtP;
//		
//			
//		}
//		//System.out.println(shrk);
//		return shrk;
//	}

	private void putToNewBags(Map<SharkCor, shark>[] tmpsharkBags, shark newShark) {
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
		
		//return tmpsharkBags;
		
	}
	
	
	
}

class shark{
	int row;
	int col;
	int size;
	int speed;
	int dir;
	
	shark(int row,int col,int speed,int dir,int size){
		this.row=row;
		this.col=col;
		this.size=size;
		this.speed=speed;
		this.dir=dir;
		
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof shark) {
			shark obj1=(shark)obj;
			if(obj1.row==this.row&&obj1.col==this.col) {
				return true;
			}
		}
		return false;
		
	}
	public int hashCode() {
		String result="row"+row+","+"col"+col;
		return result.hashCode();
		
		
	}
	public String toString() {
		return "shark--row"+row+"col"+col+"speed"+speed+"dir"+dir+"size"+size;
	}
	
}
class SharkCor{
	int row;
	int col;
	SharkCor(int row,int col){
		this.row=row;
		this.col=col;
		
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SharkCor) {
			SharkCor obj1=(SharkCor)obj;
			if(obj1.row==this.row&&obj1.col==this.col) {
				return true;
			}
		}
		return false;
		
	}
	public int hashCode() {
		String result="row"+row+","+"col"+col;
		return result.hashCode();
		
		
	}
	
	public String toString() {
		return "row"+row+"col"+col;
	
}
}
