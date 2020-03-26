package array.list;

public class SwapNodes {

    public ListNode swapPairs(ListNode head) {
        ListNode newHead=null, prev = null, curr = head, rightNode = null;
        while(curr!=null && curr.next!=null){
            if(newHead==null){
                newHead = curr.next;
                rightNode = curr.next;
                curr.next = rightNode.next;
                rightNode.next = curr;
                prev = curr;
                curr = curr.next;
            }else{
                rightNode = curr.next;
                curr.next = rightNode.next;
                rightNode.next = curr;
                prev.next = rightNode;
                prev = curr;
                curr = curr.next;
            }
        }
        return newHead;
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
