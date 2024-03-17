package com.levi.interview_me.thread.clh;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: Levi
 * @createTime: 2023年04月10日 12:14:01
 * @version: 1.0
 * @Description: clh 锁
 */
public class CLH {
    private final ThreadLocal<Node> node = ThreadLocal.withInitial(Node::new);
    private final AtomicReference<Node> tail = new AtomicReference<>();

    private static class Node{
        private volatile boolean locked;
    }

    public void lock(){
        Node node = this.node.get();
        node.locked=true;
        Node pre = this.tail.getAndSet(node);
        while (pre.locked);
    }

    public void unlock(){
        final Node node = this.node.get();
        node.locked=false;
        this.node.set(new Node());
    }

    public static void main(String[] args) {
        Byte b =127;
        ++b;

        System.out.println(b);
    }
}

