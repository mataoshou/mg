package com.mg.empty.demo.alt.leetcode;

import com.mg.empty.demo.alt.data.TreeNode;
import jdk.nashorn.internal.ir.ReturnNode;
import org.jboss.marshalling.river.RiverMarshaller;

public class Mg2020100705 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return compare(root.right,root.left);
    }

    public boolean compare(TreeNode left, TreeNode right)
    {
        if(left==null&&right==null)return true;
        if(left==null||right==null||left.val!=right.val)return false;

        return compare(left.left,right.right)&&compare(left.right,right.left);
    }
}
