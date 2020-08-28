package com.mg.empty.demo.alt.data;


/**
 * 栈为一种线性结构
 * 存在栈顶和栈底
 * 执行操作栈顶 （入栈和出栈都是在栈顶）
 * 所以可以操作的一端是栈顶，另一端为栈底
 * 栈的数据的存取只能在一端进行
 * 包含进本操作  入栈 push  出栈 pop
 */
public class Heap {

    final int MAX_LENGTH =50;
    //入栈数据，顺序往后排列，然后通过栈顶指向变量top  来记录具体的栈顶元素
    HeapNode[] data = new HeapNode[MAX_LENGTH];
    //用来记录栈顶位置
    int top =0;

    public HeapNode pop()
    {
        top--;
        return data[top];
    }

    public void push(HeapNode node)
    {
        top++;
        data[top] =node;
    }
}
