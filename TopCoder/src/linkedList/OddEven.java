package linkedList;

public class OddEven {
	public static void main(String[] args) {
		int[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		CList bhead = null;

		for (int i = 0; i < b.length; i++) {
			bhead = CList.insert(bhead, b[i]);
		}
		new OddEven().printOddEven(bhead);
	}

	public void printOddEven(CList head) {
		if (head == null)
			return;

		CList temp = head.next;
		while (head != null) {
			System.out.print(head.data + " ");
			if (head.next != null) {
				head = head.next.next;
			} else {
				break;
			}
		}
		
		head = temp;
		while (head != null) {
			System.out.print(head.data + " ");
			if (head.next != null) {
				head = head.next.next;
			} else {
				break;
			}
		}
	}
}
