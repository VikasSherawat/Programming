package linkedList;

public class RemoveDuplicates2 {
	public static void main(String[] args) {
		int[] b = {1,1,1,2,3};
		CList bhead = null;

		for (int i = 0; i < b.length; i++) {
			bhead = CList.insert(bhead, b[i]);
		}

		removeDup(bhead);
		//print(bhead);
	}

	private static void removeDup(CList head) {
		// TODO Auto-generated method stub
		if (head == null)
			return;

		CList temp = head;
		while (head.next != null) {
			if (head.data == head.next.data) {
				while(head.data==head.next.data){
					head.next = head.next.next;
				}
				head = head.next;
				
			} else {
				System.out.print(head.data + " ");
				head = head.next;
			}
			
			if(head.next==null){
				System.out.print(head.data);
			}
		}
	}

	private static void print(CList h) {
		// TODO Auto-generated method stub
		while (h != null) {
			System.out.print(h.data + " ");
			h = h.next;
		}

	}
}
