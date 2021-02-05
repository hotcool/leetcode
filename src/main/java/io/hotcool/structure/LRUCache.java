package io.hotcool.structure;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DoubleLinkedList{
        int key;
        int val;
        DoubleLinkedList next;
        DoubleLinkedList prev;
    }

    private int capacity;
    private DoubleLinkedList dummyHead;
    private DoubleLinkedList dummyTail;
    private Map<Integer, DoubleLinkedList> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dummyHead = new DoubleLinkedList();
        this.dummyTail = new DoubleLinkedList();
        map = new HashMap<>();
        this.dummyHead.next = dummyTail;
        this.dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            DoubleLinkedList node = map.get(key);
            moveOrDelete(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        DoubleLinkedList node = map.getOrDefault(key, new DoubleLinkedList());
        node.key = key;
        node.val = value;
        map.put(key, node);
        moveOrDelete(node);
        //compare the size with the capacity
        if (map.size() > capacity) {  // drop the tail node
            DoubleLinkedList last = dummyTail.prev;
            last.prev.next = dummyTail;
            dummyTail.prev = last.prev;
            map.remove(last.key);
        }
    }

    private void moveOrDelete(DoubleLinkedList node){
        //not a new node, delete it
        if(null != node.next) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        //insert a new node to head
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
        node.prev = dummyHead;
    }
}
