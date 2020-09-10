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
 * 平衡二叉树  左右子树高度差距不超过1
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
     * 先序遍历  递归方式
     *先访问根节点  然后先序遍历左子树  最后先序遍历右子树
     * 称为DLR遍历
     * @param node
     */
    public void DLROrderTree(BinaryTreeNode node)
    {
        if(node==null)return;

        System.out.println(node.value);

        if(node.lNode!=null)DLROrderTree(node.lNode);
        if(node.rNode!=null)DLROrderTree(node.rNode);
    }


    /**
     * 先序遍历  非递归方式  需要借助栈（后进先出）实现
     *先访问根节点  然后先序遍历左子树  最后先序遍历右子树
     * 称为DLR遍历
     * @param node
     */
    public void DLROrderTree2(BinaryTreeNode node)
    {

        Stack<BinaryTreeNode> stack = new Stack<>();
        if(node==null)return;
        stack.push(node);
        while(!stack.isEmpty())
        {
            BinaryTreeNode cur = stack.pop();
            if(cur.rNode!=null)
            {
                stack.push(cur.rNode);
            }

            if(cur.lNode!=null)
            {
                stack.push(cur.lNode);
            }

            System.out.println(cur.value);
        }
    }



    /**
     * 中序遍历 递归方式
     *先访中序遍历左子树  再访问根节点  最后中序遍历右子树
     * 称为LDR遍历
     * @param node
     */
    public void LDROrderTree(BinaryTreeNode node) {
        if(node == null) return;
        LDROrderTree(node.lNode);
        System.out.println(node.value);
        LDROrderTree(node.rNode);
    }

    /**
     * 中序遍历 非递归方式
     *先访中序遍历左子树  再访问根节点  最后中序遍历右子树
     * 称为LDR遍历
     * @param node
     */
    public void LDROrderTree2(BinaryTreeNode node) {
        if(node == null) return;

        Stack<BinaryTreeNode> stack = new Stack<>();


        while(!stack.isEmpty()&&node!=null)
        {

        }

        LDROrderTree(node.lNode);
        System.out.println(node.value);
        LDROrderTree(node.rNode);
    }


    /**
     * 后序遍历 递归方式
     *先访后序遍历左子树 再后序遍历右子树 最后访问根节点
     * 称为LRD遍历
     * @param node
     */
    public void LRDOrderTree(BinaryTreeNode node) {
        if(node == null) return;
        LDROrderTree(node.lNode);
        LDROrderTree(node.rNode);
        System.out.println(node.value);
    }
}
