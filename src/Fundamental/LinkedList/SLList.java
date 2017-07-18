package Fundamental.LinkedList;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by 51694 on 2017/7/6.
 */
public class SLList<Item> implements LinkedList<Item>
{
    private class Node
    {
        Item item;
        Node next;

        Node(Item item, Node next)
        {
            this.item = item;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    public SLList()
    {
        sentinel = new Node(null, null);
        size = 0;
    }

    public SLList(Item item)
    {
        sentinel = new Node(null, null);
        sentinel.next = new Node(item, null);
        size = 1;
    }

    @Override
    public boolean isEmpty()
    {
        return sentinel.next == null;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public void addFirst(Item item)
    {
        sentinel.next = new Node(item, sentinel.next);
        size += 1;
    }

    @Override
    public Item getFirst()
    {
        if (isEmpty()) return null;
        return sentinel.next.item;
    }

    @Override
    public void removeFirst()
    {
        if (isEmpty()) return;
        sentinel.next = sentinel.next.next;
        size -= 1;
    }

    @Override
    public void addLast(Item item)
    {
        Node p = sentinel;
        while (p.next != null) p = p.next;
        p.next = new Node(item, null);
        size += 1;
    }

    @Override
    public Item getLast()
    {
        Node p = sentinel;
        while (p.next != null) p = p.next;
        return p.item;
    }

    @Override
    public void removeLast()
    {
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
        if (i > size) i = size;
        int index = 0;
        Node p = sentinel;
        while (index < i)
        {
            p = p.next;
            index += 1;
        }
        p.next = new Node(item, p.next);
        size += 1;
    }

    @Override
    public SLLIterator iterator()
    {
        return new SLLIterator(sentinel.next);
    }

    private class SLLIterator implements Iterator<Item>
    {
        private Node current;

        SLLIterator(Node first)
        {
            current = first;
        }

        @Override
        public boolean hasNext()
        {
            return current != null;
        }

        @Override
        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args)
    {
        LinkedList<Integer> s = new SLList<>();
        s.addFirst(1);
        s.addFirst(2);
        s.addFirst(12);
        s.addFirst(5);
        for (int x:s)
        {
            System.out.println(x);
        }
    }
}
