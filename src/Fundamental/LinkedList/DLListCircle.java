package Fundamental.LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by 51694 on 2017/7/6.
 */
public class DLListCircle<Item> implements LinkedList<Item>
{
    private class Node
    {
        Item item;
        Node next;
        Node prior;

        Node(Item item, Node next, Node prior)
        {
            this.item = item;
            this.next = next;
            this.prior = prior;
        }
    }

    private Node sentinel;
    private int size;

    public DLListCircle()
    {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prior = sentinel;
        size = 0;
    }

    DLListCircle(Item item)
    {
        this();
        addFirst(item);
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return sentinel.next == sentinel;
    }

    @Override
    public void addFirst(Item item)
    {
        sentinel.next = new Node(item, sentinel.next, sentinel);
        sentinel.next.next.prior = sentinel.next;
        size += 1;
    }

    @Override
    public Item getFirst()
    {
        return sentinel.next.item;
    }

    @Override
    public void removeFirst()
    {
        if (isEmpty()) return;
        sentinel.next = sentinel.next.next;
        sentinel.next.prior = sentinel;
        size -= 1;
    }

    @Override
    public void addLast(Item item)
    {
        sentinel.prior = new Node(item, sentinel, sentinel.prior);
        sentinel.prior.prior.next = sentinel.prior;
        size += 1;
    }

    @Override
    public Item getLast()
    {
        return sentinel.prior.item;
    }

    @Override
    public void removeLast()
    {
        if (isEmpty()) return;
        sentinel.prior = sentinel.prior.prior;
        sentinel.prior.next = sentinel;
        size -= 1;
    }

    @Override
    public Item get(int i)
    {
        if (i < 0) throw new IllegalArgumentException();
        if (i >= size) return getLast();
        int index = 0;
        Node p = sentinel;
        while (index < i)
        {
            p = p.next;
            index += 1;
        }
        return p.next.item;
    }

    @Override
    public void insert(int i, Item item)
    {
        if (i < 0) throw new IllegalArgumentException();
        if (i >= size)
        {
            addLast(item);
            return;
        }
        int index = 0;
        Node p = sentinel;
        while (index < i)
        {
            p = p.next;
            index += 1;
        }
        p.next = new Node(item, p.next, p);
        p.next.next.prior = p.next;
        size += 1;
    }

    public Iterator<Item> iterator()
    {
        return new DLLIterator();
    }

    private class DLLIterator implements Iterator<Item>
    {
        Node current;
        DLLIterator()
        {
            current = sentinel.next;
        }

        @Override
        public boolean hasNext()
        {
            return current != sentinel;
        }

        @Override
        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item x = current.item;
            current = current.next;
            return x;
        }
    }

    public static void main(String[] args)
    {
        LinkedList<Integer> s = new DLListCircle<>();
        s.addFirst(1);
        s.addFirst(2);
        s.addFirst(2);
        s.addFirst(5);
        for (int x:s)
        {
            System.out.println(x);
        }
    }
}
