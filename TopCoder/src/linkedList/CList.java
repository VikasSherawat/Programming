package linkedList;

public class CList {
	int data;
	CList next;

	public CList(int data, CList next) {
		super();
		this.data = data;
		this.next = next;
	}
	
	public static CList insert(CList head, int data) {
		if (head == null) {
			return new CList(data, null);
		} else {
			CList prev = head;
			while (prev != null && prev.next != null) {
				prev = prev.next;
			}
			CList CList = new CList(data, null);
			prev.next = CList;
			return head;
		}
	}
}
