package Fundamental.StackBagQueue;

import Fundamental.LinkedList.LinkedList;
import Fundamental.LinkedList.SLList;

import java.util.Iterator;

/**
 * Created by 51694 on 2017/7/7.
 */
public class LLBag<Item> implements Bag<Item>
{
    private LinkedList<Item> items;

    public LLBag()
    {
        items = new SLList<>();
    }

    @Override
    public void add(Item item)
    {
        items.addFirst(item);
    }

    @Override
    public boolean isEmpty()
    {
        return items.isEmpty();
    }

    @Override
    public int size()
    {
        return items.size();
    }

    @Override
    public Iterator<Item> iterator()
    {
        return items.iterator();
    }

    public static void main(String[] args)
    {
        Bag<Integer> b = new LLBag<>();
        b.add(1);
        b.add(12);
        b.add(43);
        for (int x: b)
        {
            System.out.println(x);
        }
    }
}
