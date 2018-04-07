package com.example.demo_24_chain_reversed;

public class MyClass {
    public static void main(String[] args){
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.nextNode = b;
        b.nextNode = c;
        c.nextNode = d;
        //reverseChainRecursive(a);
        reverseChainNotRecursive(a);
    }

    private static Node reverseChainRecursive(Node head){
        System.out.println("before "+ head);
        if(head == null || head.nextNode == null){
            System.out.println("after " + head);
            return head;
        }
        Node headOfReverseChain = reverseChainRecursive(head.nextNode);
        head.nextNode.nextNode = head;
        head.nextNode = null;
        System.out.println("after "+ headOfReverseChain);
        return headOfReverseChain;
    }

    private static Node reverseChainNotRecursive(Node head) {
        Node pre = head;
        Node cur = head.nextNode;
        Node tmp;
        // 头结点的nextNode应该要置空
        pre.nextNode = null;
        while (cur != null) {
            // 先存放nex结点
            tmp = cur.nextNode;
            // 修改next结点指向pre
            cur.nextNode = pre;
            System.out.println("not ready "+ tmp);
            System.out.println("already "+ cur);
            System.out.println("---------");
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
