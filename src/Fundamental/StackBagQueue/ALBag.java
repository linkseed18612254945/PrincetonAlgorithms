package Fundamental.StackBagQueue;

import Fundamental.LinkedList.AList;

import java.util.Iterator;

/**
 * Created by 51694 on 2017/7/10.
 */
public class ALBag<Item> implements Bag<Item>
{
    private AList<Item> bag;

    public ALBag(){ bag = new AList<>(); }

    @Override
    public void add(Item item)
    {
        bag.addLast(item);
    }

    @Override
    public boolean isEmpty()
    {
        return bag.isEmpty();
    }

    @Override
    public int size()
    {
        return bag.size();
    }

    @Override
    public Iterator<Item> iterator()
    {
        return bag.iterator();
    }
}
