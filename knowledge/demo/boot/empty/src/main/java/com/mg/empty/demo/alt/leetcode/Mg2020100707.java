package com.mg.empty.demo.alt.leetcode;

import com.mg.empty.demo.alt.data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Mg2020100707 {
    public int[] levelOrder(TreeNode root) {

        if(root==null)return new int[0];

        List<Integer> list = new ArrayList();

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if(node==null)continue;
            list.add(node.val);
            queue.add(node.left);
            queue.add(node.right);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
