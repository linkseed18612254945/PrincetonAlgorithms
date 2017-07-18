package Fundamental.StackBagQueue;

import Fundamental.LinkedList.DLListCircle;
import Fundamental.LinkedList.LinkedList;

import java.util.Iterator;

/**
 * Created by 51694 on 2017/7/10.
 */
public class LLQueue<Item> implements Queue<Item>
{
    private LinkedList<Item> queue;

    public LLQueue()
    {
        queue = new DLListCircle<Item>();
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
    public void enqueue(Item item)
    {
        queue.addLast(item);
    }

    @Override
    public Item dequeue()
    {
        Item x = queue.getFirst();
        queue.removeFirst();
        return x;
    }

    @Override
    public Item peek()
    {
        return queue.getFirst();
    }

    @Override
    public Iterator<Item> iterator()
    {
        return queue.iterator();
    }

    public static void main(String[] args)
    {
        Queue<String> t = new LLQueue<>();
        t.enqueue("oo");
        t.enqueue("qw");
        t.enqueue("mm");
        t.dequeue();
        t.print();
    }
}
