package com.mg.empty.demo.alt.leetcode;

public class Mg20200922 {

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int no)
        {
            this.val= no;
        }
        public ListNode()
        {
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode node = result;
        int index =0;
        while(l1!=null&&l2!=null)
        {
            int tmp = l1.val +l2.val +index;
            index=0;
            if(tmp>=10)
            {
                index=1;
                tmp = tmp-10;

            }
            ListNode tmpNode = new ListNode();
            tmpNode.val = tmp;
            node.next= tmpNode;
            node=node.next;
            l1 =l1.next;
            l2 = l2.next;
        }
        ListNode tail =null;
        if(l1!=null)
        {
            tail =l1;
        }
        if(l2!=null)
        {
            tail =l2;
        }
        while(tail!=null) {
            int tmp = tail.val + index;
            index=0;
            if(tmp>=10)
            {
                index=1;
                tmp = tmp-10;
            }

            tail.val= tmp;
            node.next = tail;
            node=node.next;
            tail =tail.next;
        }

        if(index==1)
        {
            ListNode tmpNode = new ListNode();
            tmpNode.val = 1;
            node.next= tmpNode;
        }
        return result.next;
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode node = result;
        int carry =0;
        while(l1!=null||l2!=null)
        {
            int x=0,y=0;
            if(l1!=null)
            {x=l1.val;l1=l1.next;}
            if(l2!=null)
            {x=l2.val;l2=l2.next;}

            int tmp = x +y +carry;
            carry=0;
            carry =tmp/10;
            ListNode tmpNode = new ListNode();
            tmpNode.val = tmp%10;
            node.next= tmpNode;
            node=node.next;
        }
        if(carry!=0)
        {
            ListNode tmpNode = new ListNode();
            tmpNode.val = carry;
            node.next= tmpNode;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(9);
        node2.next = new ListNode(9);
        Mg20200922 mg20200922= new Mg20200922();
        mg20200922.addTwoNumbers2(node1,node2);

    }

}
