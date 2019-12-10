package com.ifmo.lesson24;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {

    private Queue<T> queue = new LinkedList<T>();
    private int cN;

    public BlockingQueue(int cN) {
        this.cN = cN;
    }

    public synchronized void put(T element) throws InterruptedException {
        while(queue.size() == cN) wait();
        queue.add(element);
        notify();
    }

    public synchronized T take() throws InterruptedException {
        while(queue.isEmpty()) wait();
        T item = queue.remove();
        notify();
        return item;
    }
}
