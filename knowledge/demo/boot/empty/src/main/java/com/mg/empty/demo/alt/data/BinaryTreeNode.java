package com.mg.empty.demo.alt.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树  每个节点最多有两个子节点
 * 有左节点和右节点的区分  二叉树是有序树
 *
 * 满二叉树  除了最后一层，所有的节点都有两个子节点
 * 完全二叉树  除最后一层所有节点都是满的
 * 完全二叉树  一个子节点m  父节点为m/2  左子节点为2*m  右子节点为 2*m+1  书的最大深度 logn+1
 */
public class BinaryTreeNode {

    String value;
    BinaryTreeNode lNode;
    BinaryTreeNode rNode;

    public BinaryTreeNode findNode(String val)
    {
        BinaryTreeNode result = null;
        if(this.value.equals(val))
        {
            return result = this;
        }else{
            if(this.lNode!=null)
            {
                result = this.lNode.findNode(val);
            }
            if(this.lNode!=null&&result==null){
                result = this.rNode.findNode(val);
            }
        }

        return result;
    }

    public int getDepth(BinaryTreeNode node)
    {
        if(node==null) return 0;

        int left = 0;
        int right = 0;

        int depth = 0;

        left = getDepth(this.lNode);
        right = getDepth(this.rNode);

        if(left>right)
        {
            depth = left;
        }else{
            depth = right;
        }

        depth++;
        return depth;
    }


    /**
     * 前序遍历
     * @param node
     */
    public void preOrderTree(BinaryTreeNode node)
    {
        if(node==null)return;

        System.out.println(node.value);

        if(node.lNode!=null)preOrderTree(node.lNode);
        if(node.rNode!=null)preOrderTree(node.rNode);
    }


    /**
     * 前序遍历
     * @param node
     */
    public void preOrderTree2(BinaryTreeNode node)
    {

        Stack<BinaryTreeNode> stack = new Stack<>();
        if(node==null)return;
        stack.push(node);

        if(node.lNode!=null)preOrderTree(node.lNode);
        if(node.rNode!=null)preOrderTree(node.rNode);
    }
}
