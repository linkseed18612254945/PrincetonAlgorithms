package Fundamental.StackBagQueue;

import Fundamental.LinkedList.AList;

import java.util.Iterator;

/**
 * Created by 51694 on 2017/7/10.
 */
public class ALStack<Item> implements Stack<Item>
{
    private AList<Item> items;

    public ALStack()
    {
        items = new AList<>();
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
    public void push(Item item)
    {
        items.addLast(item);
    }

    @Override
    public Item pop()
    {
        Item top = items.getLast();
        items.removeLast();
        return top;
    }

    @Override
    public Item peek()
    {
        return items.getLast();
    }

    @Override
    public Iterator<Item> iterator()
    {
        return items.iterator();
    }

    public static void main(String[] args)
    {
        Stack<String> s = new ALStack<>();
        s.push("po");
        s.push("ui");
        s.push("mn");
        for (String i : s)
        {
            System.out.println(i);
        }
    }
}
