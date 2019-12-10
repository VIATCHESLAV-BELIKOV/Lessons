package com.ifmo.lesson24;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {

    private Queue<T> queue = new LinkedList<T>();
    private String qName;
    private int cN;

    public BlockingQueue(int cN, String qName) {
        this.cN = cN;
        this.qName = qName;
    }

    public synchronized void put(T Item) throws InterruptedException {
        while(queue.size() == cN) {
            System.out.printf("Очередь %s заполнена, Ждем ...\n", this.qName);
            wait();
        }
        queue.add(Item);
        System.out.printf("Добавляем элемент %s в очередь %s" + Item.toString(), this.qName );
        notifyAll();
    }

    public synchronized T take() throws InterruptedException {
        while (queue.isEmpty()){
            System.out.printf("Очередь %s пуста, Ждем ...\n", this.qName);
            wait();
        }
        T item = queue.remove();
        System.out.printf("Удаляем элемент %s из очереди %s" + item.toString(), this.qName );
        notifyAll();
        return item;
    }
}
