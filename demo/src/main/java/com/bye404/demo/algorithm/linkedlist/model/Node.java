package com.bye404.demo.algorithm.linkedlist.model;

/**
 * Node
 *
 * @author liujia
 */
public class Node {

    public String value;
    public Node next;

    public Node(String value, Node next) {
        this.value = value;
        this.next = next;
    }

    public static Node create(int size) {
        Node temp = null;
        for (int i = size; i > 0; i--) {
            temp = new Node(String.valueOf(i), temp);
        }
        return temp;
    }

    public static Node createWithPrefix(int size, String prefix) {
        Node temp = null;
        for (int i = size; i > 0; i--) {
            temp = new Node(prefix+i, temp);
        }
        return temp;
    }

    // 打印给定的链表
    public static void print(String message, Node head) {
        System.out.println(message);
        while(head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println();
    }

    // 只打印给定的节点
    public static void printCurrent(String message, Node node) {
        System.out.println(message);
        if (node != null) {
            System.out.println(node.value);
        }
    }

    // 打印含有环形的链表
    public static void printCycle(String message, Node head, int size) {
        System.out.println(message);
        int i = 0;
        while(head != null && i++ <= size) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println();
    }
}
