package com.mg.empty.demo.alt.leetcode;

import java.sql.Time;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeSet;

public class LFUCache {

    int capacity =0;
    TreeSet<LinkNode> set = new TreeSet<>();
    HashMap<Integer,LinkNode> map = new HashMap();

    int mod =0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        mod++;
        if (map.get(key)!=null)
        {
            LinkNode node = map.get(key);
            set.remove(node);
            node.count++;
            node.lastTime=mod;
            set.add(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(capacity==0)return;
        mod++;
        if(map.get(key)!=null)
        {
            LinkNode node = map.get(key);
            set.remove(node);
            node.count++;
            node.lastTime=mod;
            node.value = value;
            set.add(node);
            return;
        }

        LinkNode node = new LinkNode(key,value);
        node.lastTime = mod;



        if(set.size()==capacity)
        {
            LinkNode rmNode =set.first();
            map.remove(rmNode.key);
            set.remove(rmNode);
        }
        map.put(node.key,node);
        set.add(node);

    }

    private class LinkNode implements Comparable<LinkNode>{
        public LinkNode(int key,int value)
        {
            this.key = key;
            this.value = value;
            this.count=1;
            this.lastTime = mod;
        }

        LinkNode pre;
        LinkNode next;

        int key=0;
        int value=0;
        int count =0;
        int lastTime =0;

        @Override
        public int compareTo(LinkNode node) {
            if(this.count==node.count){

                return this.lastTime-node.lastTime;
            }
            return this.count-node.count;
        }

    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );

        cache.put(2,1);
        cache.put(1, 1);
        cache.put(2, 3);    // 去除 key 2
        cache.put(4,1);    // 去除 key 2
        cache.get(1);       // 返回 3
        cache.get(2);    // 去除 key 1
    }
}
