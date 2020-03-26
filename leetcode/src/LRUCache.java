import java.util.HashMap;

public class LRUCache {

    private class DNode{
        int key;
        int value;
        DNode next;
        DNode prev;
    }

    private HashMap<Integer,DNode> cache = new HashMap<>();
    private int capacity;
    private int count;
    private DNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.head = new DNode();
        this.tail = new DNode();
        this.head.next = tail;
        this.tail.prev = this.head;
    }
    private void remove(DNode node){
        DNode prev = node.prev;
        DNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void updateToHead(DNode node){
        DNode oldHead = head.next;
        head.next = node;
        node.next = oldHead;
        node.prev = head;
        oldHead.prev = node;
    }
    public void put(int key, int value){
        if(cache.containsKey(key)){
            DNode node = cache.get(key);
            node.value = value;
            cache.put(key,node);
            remove(node);
            updateToHead(node);
        }else{
            DNode node = new DNode();
            node.key = key;
            node.value = value;
            updateToHead(node);
            cache.put(key,node);
            count++;
        }
        if(count>capacity){
            DNode node = tail.prev;
            node.prev.next = tail;
            tail.prev = node.prev;
            cache.remove(node.key);
            count--;
        }
    }

    public int get(int key){
        if(cache.containsKey(key)){
            DNode node = cache.get(key);
            remove(node);
            updateToHead(node);
            return node.value;
        }
        return -1;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        int[][] arr = {{1,11},{2,12},{3,13},{1,23},{4,14}};
        for(int[] a: arr){
            cache.put(a[0],a[1]);
        }
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(1));
        System.out.println(cache.get(4));
        cache.put(5,15);
        System.out.println(cache.get(3));
        System.out.println(cache.get(5));
    }
}
