package thirtyDaysChallenge;

import java.util.*;


class List{
	int data;
	List next;
	List(int d){
        data=d;
        next=null;
    }
	
}

public class Day24 {
	
	static List removeDuplicates(List head) {
	      //Write your code here
		 if(head == null)
		        return head;

		 List mainHead =head;
			while(head.next!=null){
					 if(head.next.data==head.data){
						 head.next= head.next.next;
				 		}//inner if closed here
					 else{
						 head = head.next;
					 }
			}
			return mainHead;
	    }
	
	public static  List insert(List head,int data)
    {
		
        List p=new List(data);			
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            List start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(List head)
        {
              List start=head;
              while(start!=null)
              {
                  System.out.print(start.data+" ");
                  start=start.next;
              }
        }
         public static void main(String args[])
        {
              Scanner sc=new Scanner(System.in);
              List head=null;
              int T=sc.nextInt();
              while(T-->0){
                  int ele=sc.nextInt();
                  head=insert(head,ele);
              }
              head=removeDuplicates(head);
              display(head);

       }
}
