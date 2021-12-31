package com.bye404.demo.algorithm.linkedlist;

import com.bye404.demo.algorithm.linkedlist.model.Node;

/**
 * ReverseLinkedList
 *
 * @author liujia
 */
public class ReverseLinkedList {

    // 普通反转
    private static Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // 分组反转（递归方式）
    private static Node reverse(Node head, int k) {
        Node prev = null;
        Node groupPrev = head;
        int i = 0;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            if (++i % k == 0) {
                groupPrev.next = reverse(head, k);
                break;
            }
        }
        return prev;
    }

    // 分组反转（非递归方式）
    private static Node reverse2(Node head, int k) {
        Node prev = null;
        Node groupPrev = head;
        int i = 0;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            if (++i % k == 0) {
                groupPrev.next = reverse(head, k);
                break;
            }
        }
        return prev;
    }

    public static void main(String[] args) {
        Node a = Node.create(10);
        Node.print("反转链表前：", a);
        Node r = reverse(a);
        Node.print("反转链表后", r);

        System.out.println("=======================================================");

        Node b = Node.create(10);
        Node.print("K个一组反转链表前", b);
        Node r1 = reverse(b, 2);
        Node.print("K个一组反转链表后", r1);
    }

}

