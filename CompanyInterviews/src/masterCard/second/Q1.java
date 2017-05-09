package masterCard.second;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



class LinkedListNode {
    int val;
    LinkedListNode next;

    LinkedListNode(int node_value) {
        val = node_value;
        next = null;
    }
}

public class Q1 {
	static Node removeNodes(Node list, int x) {
		System.out.println("Inside Remove head");
		if(list == null)
			return null;
		else{
			Node prev = list;
			Node head = null;
			while(list!=null){
				if(list.val>x){
					if(list.next==null){
						prev.next = null;
					}else{					
						prev.next = list.next;
					}
					list = list.next;
				}else{
					if(head == null){
						head = list;
					}
					prev = list;
					list = list.next;
					
				}
			}
		printList(head);
		return head;
		}
    }
	
	
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int[] arr = {34,2,334,289,1,23,33,77};
    	int[] arr1 = {2,4,6,8};
    	Node headA =null;
    	System.out.println("starting");
    	for (int i = 0; i < arr.length; i++) {
    		headA = InsertAtEnd(headA,arr[i]);
    	}
    	printList(headA);
    	removeNodes(headA, 23);
    	printList(headA);
    }
	private static Node InsertAtEnd(Node head, int data) {
		// TODO Auto-generated method stub
		if(head==null){
			Node node = new Node();
			node.val = data;
			node.next = null;
			return node;
		}else{
			Node node = head;
			while(node.next!=null){
				node = node.next;
			}
			Node tail = new Node();
			tail.val=data;
			tail.next = null;
			node.next = tail;
		
		return head;
		}
	}
	private static void printList(Node head) {
		// TODO Auto-generated method stub
		if(head!=null){
			while(head!=null){
				System.out.print(head.val+" ");
				head = head.next;
			}
			System.out.println();
		}
		
	}
	
}
 class Node {
    int val;
    Node next;
 }
