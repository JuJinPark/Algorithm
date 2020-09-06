package main.java.leetcode.medium;

public class AddTwoNumber_2 {

    public String testSolution(int [] l1,int [] l2){

        ListNode listNode = addTwoNumbers(covertIntoNode(l1), covertIntoNode(l2));
        return convertIntoString(listNode);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

//        double numb1=convertIntoNum(l1);
//        double numb2=convertIntoNum(l2);
//        double result=numb1+numb2;

        
        ListNode currentL1=l1;
        ListNode currentL2=l2;
        ListNode root = null;
        ListNode prev = null;
        int upNum=0;
        while(currentL1!=null || currentL2 !=null ){
            ListNode current = new ListNode();
            int sum=0;
            int value1=0;
            if(currentL1!=null){
                value1 = currentL1.val;
            }
            int value2=0;
            if(currentL2!=null){
                value2 = currentL2.val;
            }
            sum=value1+value2+upNum;

            upNum=sum/10;
            current.val=sum%10;
            if(prev==null){
                root=current;
            }else{
                prev.next=current;
            }
            prev=current;
            if(currentL1!=null){
                currentL1=currentL1.next;
            }
            if (currentL2!=null){
                currentL2=currentL2.next;
            }
        }
        if(upNum>0){
            prev.next=new ListNode(upNum);
        }

        return root;


    }

    private String convertIntoString(ListNode node){

        String num=node.val+"";

        ListNode next= node.next;
        while(next!=null){
            ListNode current = next;
            num+=current.val;
            next=current.next;


        }
        return num;
    }

    private ListNode covertIntoNode(int[] num){
        ListNode root=null;
        ListNode prev= null;
        for (int i : num) {
            ListNode current = new ListNode();
            current.val=i;
            if(prev==null){
                root=current;
            }else {
                prev.next=current;
            }
            prev=current;
        }
        return root;
//        double number= num;
//        ListNode head=null;
//        ListNode prev= null;
////        int count=1;
//        while(number>1){
//
//            int value= (int) (number/10);
//            double leftover =(number%10);
//            ListNode current = new ListNode((int) leftover);
//            if(prev==null){
//                head=current;
//            }else {
//                prev.next=current;
//            }
//
//            prev=current;
//
//            number=value;
//        }
//
////        String numberInString=Integer.toString(num);
////        ListNode prev= null;
////        for (int i = 0; i < numberInString.length() ; i++) {
////            ListNode current = new ListNode();
////            current.next=prev;
////            current.val=Character.getNumericValue(numberInString.charAt(i));
////            prev=current;
////        }
//
//        return head;

    }
}
  class ListNode {
     int val;
     ListNode next;
    ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
