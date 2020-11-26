package com.mg.empty.demo.alt.leetcode;
import java.util.HashMap;

public class LRUCache {

    int capacity =0;
    HashMap<Integer,LinkNode> map = new HashMap<>();

    LinkNode head;
    LinkNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LinkNode(-1,-1);
        tail = new LinkNode(-1,-1);
        head.next=tail;
        tail.pre = head;
    }

    public int get(int key) {
            LinkNode node =map.get(key);
            if(node==null)return -1;

            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = tail;
            node.pre = tail.pre;
            tail.pre.next = node;
            tail.pre = node;

            return node.value;
    }

    public void put(int key, int value) {
        if(get(key)!=-1)
        {
            map.get(key).value = value;
            return;
        }

        LinkNode node = new LinkNode(key,value);
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
        map.put(key,node);

        if(map.size()>capacity)
        {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
    }


    private class LinkNode{
        public LinkNode(int key,int value)
        {
            this.key = key;
            this.value = value;
        }

        LinkNode pre;
        LinkNode next;

        int key=0;
        int value=0;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回 1
        cache.put(3, 3);    // 去除 key 2
    }

}
