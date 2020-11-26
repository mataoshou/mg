package com.mg.empty.demo.alt.util;

<<<<<<< Updated upstream
import com.mg.empty.demo.alt.data.LinkListNode;
import com.mg.empty.demo.alt.data.ListNode;
import com.mg.empty.demo.alt.data.TreeNode;

public class BuildData {

    public static LinkListNode buildLinkList(int[][] arrays)
    {
        LinkListNode head = new LinkListNode(-1,-1);
        LinkListNode tmp = head;
        for(int i=0;i<arrays.length;i++)
        {
            LinkListNode node = new LinkListNode(arrays[i][0],arrays[i][1]);
            tmp.next = node;
            tmp = node;
        }
        return head.next;

    }


    public static ListNode buildList(int[] arrays)
    {
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        for(int i=0;i<arrays.length;i++)
        {
            ListNode node = new ListNode(arrays[i]);
            tmp.next = node;
            tmp = node;
        }
        return head.next;

    }

    public static TreeNode buildTree(Integer[] arrays)
    {
        return buildTree(arrays,0);
    }

    public static TreeNode buildTree(Integer[] arrays,int index)
    {
        if(index>arrays.length-1)return null;
        if(arrays[index]==null)return null;
        TreeNode node = new TreeNode(-1);
        node.val = arrays[index];
        node.left = buildTree(arrays,2*index+1);
        node.right = buildTree(arrays,2*index+2);
        return node;
    }



=======
public class BuildData {
>>>>>>> Stashed changes
}
