package com.mg.empty.demo.today;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Cache<T,M> {

    ConcurrentHashMap<T,LinkNode<T,M>> cacheStore = new ConcurrentHashMap();
    int capacity =0;
    LinkNode<T,M> head;
    LinkNode<T,M> tail;

    public Cache(int capacity)
    {
        this.capacity =capacity;
        init();
    }

    public void init()
    {
        head = new LinkNode(-1,null);
        tail = new LinkNode(-1,null);
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 获取元素
     * 调整节点位置过程中需要保证链表线程安全
     * @param key
     * @return
     */
    public M get(T key)
    {
        LinkNode<T,M> node = cacheStore.get(key);
        if(node==null)return null;
        fixPosition(node);
        return node.value;
    }

    /**
     * 添加更新元素
     * 新增过程中需要保证链表线程安全
     * @param key
     * @return
     */
    public void put(T key, M value) {
        if(get(key)!=null)
        {
            LinkNode<T,M> node = cacheStore.get(key);
            node.value = value;
            return;
        }

        synchronized (this) {
            LinkNode node = new LinkNode(key, value);
            bringToTail(node);
            cacheStore.put(key, node);

            collectionByLRU();
        }
    }

    /**
     * 通过LRU算法回收节点
     */
    private void collectionByLRU()
    {
        if(cacheStore.size()>capacity)
        {
            cacheStore.remove(head.next.key);
            removeHead();
        }
    }

    /**
     * 移除头结点
     */
    private void removeHead()
    {
        head.next = head.next.next;
        head.next.pre = head;
    }

    /**
     * 添加到尾结点
     */
    public synchronized void bringToTail(LinkNode node)
    {
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
    }

    /**
     * 调整节点位置
     * @param node
     */
    public synchronized void fixPosition(LinkNode node)
    {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        bringToTail(node);
    }



    private class LinkNode<T,M>{
        public LinkNode(T key,M value)
        {
            this.key = key;
            this.value = value;
        }

        LinkNode pre;
        LinkNode next;

        T key;
        M value;
    }

    public void showList()
    {
        LinkNode node = head.next;
        System.out.println("....................begin...................");
        while(node!=null&&node.value!=null)
        {
            System.out.print(node.key +"  ");
            node = node.next;
        }
        System.out.println();
        System.out.println("....................end.....................");
    }

    public static void main(String[] args) {
        Cache<Integer,Integer> cache = new Cache(2);

        cache.put(1,1);
        cache.put(2,2);
        cache.showList();
        cache.get(1);
        cache.showList();
        cache.put(3,3);
        cache.showList();
        cache.put(4,4);
        cache.showList();
    }

}
