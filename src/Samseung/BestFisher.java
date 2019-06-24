package Samseung;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BestFisher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row=sc.nextInt();
		int col=sc.nextInt();
		int sharkNmb=sc.nextInt();
		ArrayList<shark> [] sharkBags = new ArrayList [col+1];
	
		for(int i=i;i<sharkNmb;i++) {
			shark tmpshark=new shark(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
			if(sharkBags[tmpshark.col]==null) {
				ArrayList<shark> tmpBags =new ArrayList();
				tmpBags.add(tmpshark);
				sharkBags[tmpshark.col]=tmpBags;
			}else {
				sharkBags[tmpshark.col].add(tmpshark);
			}
			
		
			
		}
		
		
		
		for(int i=i;i<col+1;i++) {
			if(sharkBags[i]==null) {
				System.out.println("ºñ¿üÀ½");
				continue;
			}
			
			sharkBags[i].sort(new SharkCompartor());
			for(shark a: sharkBags[i]) {
				System.out.println(a.toString()+"colnum"+i);
			}
		
			
		}
		
		BestFishSol sol= new BestFishSol(row,col,sharkNmb,sharkBags);
		System.out.println(sol.getCatchedSize());

	}

}

class BestFishSol{
	int row;
	int col;
	int sharkNmb;
	
	ArrayList<shark> [] sharkBags;
	
	BestFishSol(int row,int col,int sharkNmb,ArrayList<shark> [] sharkBags){
		
		this.row=row;
		this.col=col;
		this.sharkNmb=sharkNmb;
		this.sharkBags=sharkBags;
		
		
		
	}
	
	public int getCatchedSize() {
		int size=0;
		
		for(int i=1;i<=col;i++) {
			if(sharkBags[i]!=null) {
				sharkBags[i].sort(new SharkCompartor());
				size+= sharkBags[i].get(0).size;
			}

			sharkBags=sharkMove();
		}
		
		return size;
	}
	
	public ArrayList<shark> [] sharkMove() {
		ArrayList<shark> [] tmpsharkBags = new ArrayList [col+1];
		
		for(int i=1;i<sharkBags.length;i++) {
			
			
			for(shark a:sharkBags[i]) {
				
			a
			
			
			
			
			
			}
			
			
			
			
			
			
			shark newShark=new shark();
			
			
			if(tmpsharkBags[newShark.col]==null) {
				ArrayList<shark> tmpBags =new ArrayList();
				tmpBags.add(newShark);
				tmpsharkBags[newShark.col]=tmpBags;
				
			}else {
				if(tmpsharkBags[newShark.col].contains(newShark)) {
					shark firstShark=tmpsharkBags[newShark.col].get(index);
					if(firstShark.size<newShark.size) {
						tmpsharkBags[newShark.col].add(newShark)
					}
					
				}
				tmpsharkBags[newShark.col].add(newShark);
			}
			
			
		}
		
		return tmpsharkBags;
		
	}
	
	
	
}
class SharkCompartor implements Comparator<shark>{

	@Override
	public int compare(shark x, shark y) {
		  if(x.row>y.row) {
			  return 1;
		  }else if(x.row<y.row) {
			  return -1;
		  }
		  
		  return 0;
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
		return "row"+row+"col"+col+"speed"+speed+"dir"+dir+"size"+size;
	}
	
}
//class SharkCor{
//	int row;
//	int col
//@Override
//public int compare(Object arg0, Object arg1) {
//	// TODO Auto-generated method stub
//	return 0;
//};
//	
//}
