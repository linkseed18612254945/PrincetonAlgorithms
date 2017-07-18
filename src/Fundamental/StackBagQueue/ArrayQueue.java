package Fundamental.StackBagQueue;

import Fundamental.LinkedList.AList;

import java.util.Iterator;

/**
 * Created by 51694 on 2017/7/12.
 */
public class ArrayQueue<Item> implements Queue<Item>
{
    private AList<Item> queue;

    public ArrayQueue()
    {
        queue = new AList<>();
    }

    @Override
    public void enqueue(Item item)
    {
        queue.addLast(item);
    }

    @Override
    public Item dequeue()
    {
        Item first = queue.getFirst();
        queue.removeFirst();
        return first;
    }

    @Override
    public Item peek()
    {
        return queue.getFirst();
    }

    @Override
    public int size()
    {
        return queue.size();
    }

    @Override
    public boolean isEmpty()
    {
        return queue.isEmpty();
    }

    @Override
    public Iterator<Item> iterator()
    {
        return queue.iterator();
    }
}
