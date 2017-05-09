package thirtyDaysChallenge;

import java.util.*;
class Node2{
	int data;
	Node2 next;
	Node2(int d){
        data=d;
        next=null;
    }
	
}

public class Day15 {
	public static  Node2 insert(Node2 head,int data)
	{
  	//Complete this method
		if(head==null){
			Node2 start = new Node2(data);
	        return start;
		}else{
		Node2 start  = head;
        while(head.next!=null){
        	head = head.next;
        }
        Node2 tail = new Node2(data);
        head.next = tail;
        //head.data = data;
        return start;
		}
	}
	
	public static void display(Node2 head)
    {
          Node2 start=head;
          while(start!=null)
          {
              System.out.print(start.data+" ");
              start=start.next;
          }
    }
    public static void main(String args[])
    {
          Scanner sc=new Scanner(System.in);
          Node2 head=null;
          int N=sc.nextInt();
          while(N-->0){
              int ele=sc.nextInt();
              head=insert(head,ele);
              
          }
          display(head);

   }
}
