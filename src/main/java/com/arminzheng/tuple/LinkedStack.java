package com.arminzheng.tuple;

/**
 * Stack Structure
 *
 * @author zy
 * @version 2022/4/9
 */
public final class LinkedStack<T> {

    private Node top = new Node(); // End sentinel

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();
        for (String s : "Phaser's on stun!".split(" ")) lss.push(s);
        String s;
        while ((s = lss.pop()) != null) {
            System.out.println(s);
        }
    }

    public void push(T item) {
        top = new Node(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    /** 内部类可以访问其外部类的类型参数（去掉static静态内部类是独立的类） */
    private class Node {
        T item;
        Node next;

        Node() {
            item = null;
            next = null;
        }

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }
}
