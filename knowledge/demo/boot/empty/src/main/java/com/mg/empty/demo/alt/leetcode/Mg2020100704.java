package com.mg.empty.demo.alt.leetcode;
import com.mg.empty.demo.alt.data.TreeNode;
import com.mg.empty.demo.alt.util.BuildData;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Mg2020100704 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root==null)return "[]";

        int depth = getDepath(root,0);

        int count = 2*depth+1;
        int index=0;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        String result ="";
        while(index<count)
        {
            TreeNode node = queue.poll();
            if(result.length()!=0)result+=",";
            if(node==null)
            {
//                queue.add(null);
//                queue.add(null);
                result+="null";
            }else {
                queue.add(node.left);
                queue.add(node.right);
                result+=node.val;
            }
            index++;
        }
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.length()==0||data.trim().equals("[]"))return null;
        data = data.substring(1,data.length()-1);

        String[] datas =  data.split(",");
        Queue<TreeNode> queue = new LinkedList();
        String tmp =datas[0];
        TreeNode root = new TreeNode(convert(tmp));
        queue.add(root);
        int index =1;
        while(index<datas.length)
        {

            TreeNode node= queue.poll();
            if(node==null)
            {
//                index++;
//                index++;
//                queue.add(null);
//                queue.add(null);
                continue;
            }
            tmp = datas[index++].trim();
            System.out.println(tmp);
            if(convert(tmp)!=null) {
                node.left= new TreeNode(convert(tmp));
            }
            queue.add(node.left);
            tmp = datas[index++].trim();
            if(convert(tmp)!=null) {
                node.right= new TreeNode(convert(tmp));
            }
            queue.add(node.right);
        }
        return root;
    }


    public int getDepath(TreeNode root,int current)
    {
        if(root==null)return current;
        current++;
        return Math.max(getDepath(root.left,current),getDepath(root.right,current));
    }

    public Integer convert(String str)
    {
        System.out.println(str);
        try {
            if (str == null || str.length() == 0 ||str.equals("null")) return null;
            return Integer.valueOf(str);
        }
        catch (Exception e)
        {
            return null;
        }
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

    public static void main(String[] args) {
        Mg2020100704 mg2020100704 = new Mg2020100704();
        TreeNode node = BuildData.buildTree(new Integer[]{5,2,3,null,null,2,4,3,1});
        node.right.left.left = new TreeNode(3);
        node.right.left.right = new TreeNode(1);
        System.out.println( mg2020100704.serialize(node));
        mg2020100704.deserialize("[5,2,3,null,null,2,4,3,1]");

    }
}
