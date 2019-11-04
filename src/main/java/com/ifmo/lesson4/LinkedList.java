package com.ifmo.lesson4;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList {
    /** Ссылка на первый элемент списка. */
    private Item head;

    /**
     * Добавляет значение в конец списка.
     *
     * @param val Значение, которое будет добавлено.
     */
    public void add(Object val) {
        // TODO implement

        if (head == null) {
            head = new Item(val);
        }
        else
        {
          Item hCurr = head;
          while (hCurr.next != null)
              hCurr = hCurr.next;
          hCurr.next = new Item(val);
        }
    }

    /**
     * Извлекает значение из списка по индексу.
     *
     * @param i Индекс значения в списке.
     * @return Значение, которое находится по индексу
     * или {@code null}, если не найдено.
     */
    public Object get(int i) {
        // TODO implement
        Item hCurr = head;
        int j = 0;
        while (hCurr != null)
        {
            if (j == i)
                return hCurr.value;
            j++;
            hCurr = hCurr.next;
        }
        return null;
    }

    /**
     * Удаляет значение по индексу и возвращает
     * удаленный элемент.
     *
     * @param i Индекс, по которому будет удален элемент.
     * @return Удаленное значение или {@code null}, если не найдено.
     */
    public Object remove(int i) {
        // TODO implement
        Item hPrev = null;
        Item hCurr = head;
        int j = 0;
        while (hCurr != null)
        {
          if (j == i)
          {
            if (hPrev == null)
                head = hCurr.next;
            else
                hPrev.next = hCurr.next;
            return hCurr.value;
          }
          j++;
          hPrev = hCurr;
          hCurr = hCurr.next;
        }
        return null;
    }
}
