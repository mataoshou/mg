package com.mg.empty.demo.alt.data;

/**
 * 队列是线性存储结构
 * 允许在两端进行操作
 * 一端进行插入操作，另一端进行删除操作
 * 遵循先入先出原则（FIFO）
 * 操作包括 ： 入队列  和 出队列
 */
public class Queue {
    int head =0;
    int tag =0;

    QueueNode[] data = new QueueNode[50];


    public void enterQueue(QueueNode node)
    {
        tag++;
        data[tag] = node;
    }

    public QueueNode exitQueue()
    {
        head++;

        return data[head];

    }




}
