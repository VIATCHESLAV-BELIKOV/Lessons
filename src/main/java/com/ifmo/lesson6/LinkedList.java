package com.ifmo.lesson6;

import java.util.Iterator;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList implements List, Stack, Queue {
    /** Ссылка на первый элемент списка. */
    private Item head;

    /** {@inheritDoc} */
    @Override
    public void add(Object val) {
        // TODO implement.
        Item iIter = head;
        if (head == null) {
            head = new Item(val);
            iIter = head;
        } else {
            while (iIter.next != null) iIter = iIter.next;
            iIter.next = new Item(val);
            iIter = iIter.next;
        }
        iIter.value = val;
        iIter.next = null;
    }

    /** {@inheritDoc} */
    @Override
    public Object take() {
        // TODO implement.

        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Object get(int i) {
        // TODO implement.

        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Object remove(int i) {
        // TODO implement.

        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Iterator iterator() {
        // TODO implement.

        return null;
    }

    /** {@inheritDoc} */
    @Override
    public void push(Object value) {
        // TODO implement.
    }

    /** {@inheritDoc} */
    @Override
    public Object pop() {
        // TODO implement.

        return null;
    }
}
