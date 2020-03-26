package design;

import com.sun.tools.javac.util.Assert;

import java.util.HashMap;

class LFUCache {

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(0);
        cache.put(1,1);
        System.out.println(cache.get(1));
    }
    private class Node{
        int key;
        int val;
        int freq;
        Node next;
        Node prev;
    }

    HashMap<Integer,Node> cache ;
    int capacity;
    int count;
    Node head ;
    Node tail;

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        this.count =0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.freq++;
            remove(node);
            updateNode(node);
            return node.val;
        }

        return -1;
    }

    private void updateNode(Node node){
        Node prev = head;
        while(prev.next!=null){
            Node curr = prev.next;
            if(curr.freq <= node.freq){
                prev.next = node;
                node.next = curr;
                curr.prev = node;
                node.prev = prev;
                break;
            }
            prev = curr;
        }
    }

    private void updateToHead(Node node){
        Node oldHead = head.next;
        head.next = node;
        node.next = oldHead;
        node.prev = head;
        oldHead.prev = node;
    }

    private void remove(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void put(int key, int value) {
        if(this.capacity==0)
            return;
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.val = value;
            remove(node);
            updateNode(node);
        }else{
            if(this.count == this.capacity){
                Node node = tail.prev;
                node.prev.next = tail;
                tail.prev = node.prev;
                cache.remove(node.key);
                count--;
            }

            Node node = new Node();
            node.key = key;
            node.val = value;
            updateNode(node);
            cache.put(key, node);
            count++;


        }
    }
}

