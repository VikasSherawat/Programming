package linkedList;

public class RemoveDuplicates {
	public static void main(String[] args) {
		int[] b = { 2,2,2, 4,4,4,4,5,5,5,5,5, 6, 8, 10 };
		CList bhead = null;

		for (int i = 0; i < b.length; i++) {
			bhead = CList.insert(bhead, b[i]);
		}

		bhead = removeDup(bhead);
		print(bhead);
	}

	private static CList removeDup(CList head) {
		// TODO Auto-generated method stub
		if (head == null)
			return null;

		CList temp = head;
		while (head.next != null) {
			if (head.data == head.next.data) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}
		return temp;
	}

	private static void print(CList h) {
		// TODO Auto-generated method stub
		while (h != null) {
			System.out.print(h.data + " ");
			h = h.next;
		}

	}
}
