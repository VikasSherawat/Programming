package linkedList;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MergeTwoList {
	public static void main(String[] args) {

		CList head = null;
		int[] a = { 1, 3, 5, 7, 9 };

		for (int i = 0; i < a.length; i++) {
			head = CList.insert(head, a[i]);
		}

		int[] b = { 2, 4, 5, 6, 8, 10 };
		CList bhead = null;

		for (int i = 0; i < b.length; i++) {
			bhead = CList.insert(bhead, b[i]);
		}

		CList mergedList = mergeList(head, bhead);
		printList(mergedList);
	}

	private static void printList(CList head) {
		// TODO Auto-generated method stub
		while(head!=null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		
		System.out.println();
	}

	private static CList mergeList(CList a, CList b) {
		// TODO Auto-generated method stub
		CList head = null, temp = null;
		while (a != null || b != null) {
			if (a != null && b != null) {
				if (a.data <= b.data) {
					temp = CList.insert(temp, a.data);
					a = a.next;
				} else {
					temp = CList.insert(temp, b.data);
					b = b.next;
				}
			} else if (a == null) {
				temp = CList.insert(temp, b.data);
				b = b.next;
			} else {
				temp = CList.insert(temp, a.data);
				a = a.next;
			}

			if (head == null)
				head = temp;
		}
		return head;
	}
}
