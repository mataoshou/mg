package com.mg.empty.demo.alt.leetcode;

import com.mg.empty.demo.alt.data.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Mg2020100706 {

    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)return null;
        Queue<TreeNode> queue = new LinkedList();

        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if(node==null)continue;
            queue.add(node.left);
            queue.add(node.right);
            TreeNode left = node.left;
            node.left = node.right;
            node.right=left;
        }

        return root;

    }
}
