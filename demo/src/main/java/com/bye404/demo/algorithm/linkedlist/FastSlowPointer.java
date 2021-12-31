package com.bye404.demo.algorithm.linkedlist;

import com.bye404.demo.algorithm.linkedlist.model.Node;

/**
 * FastSlowPointer
 *
 * @author liujia
 */
public class FastSlowPointer {

    // 通过快慢指针查找单链表的中间节点
    private static Node findIntermediateNode(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 检查链表是否含有环形（环形不仅仅是首尾相接，也有可能是尾部和中间某个节点相接）
    private static boolean hasCycle(Node head) {

        return false;
    }

    public static void main(String[] args) {
        Node n = Node.create(7);
        Node.print("快慢指针查找中间节点，原链表：", n);
        Node intermediateNode = findIntermediateNode(n);
        Node.printCurrent("快慢指针查找中间节点，中间节点：", intermediateNode);

        System.out.println("=======================================================");

        Node c1 = Node.create(2);
        Node c2 = Node.create(7);
        c1.next.next = c2;
        c2.next.next.next.next.next.next.next = c2;
        Node.printCycle("含有环形的链表：", c1, 9);
        System.out.println("检查该链表是否含有环形：" + hasCycle(c1));
    }

}
