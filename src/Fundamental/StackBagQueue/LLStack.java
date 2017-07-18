package Fundamental.StackBagQueue;

import Fundamental.LinkedList.LinkedList;
import Fundamental.LinkedList.SLList;

import java.util.Iterator;

/**
 * Created by 51694 on 2017/7/10.
 */
public class LLStack<Item> implements Stack<Item>
{
    private LinkedList<Item> items;

    public LLStack()
    {
        items = new SLList<>();
    }

    @Override
    public int size()
    {
        return items.size();
    }

    @Override
    public boolean isEmpty()
    {
        return items.isEmpty();
    }

    @Override
    public void push(Item item)
    {
        items.addFirst(item);
    }

    @Override
    public Item pop()
    {
        Item top = items.getFirst();
        items.removeFirst();
        return top;
    }

    @Override
    public Item peek()
    {
        return items.getFirst();
    }

    @Override
    public Iterator<Item> iterator()
    {
        return items.iterator();
    }

    public static void main(String[] args)
    {
        Stack<String> s = new LLStack<>();
        s.push("po");
        s.push("ui");
        s.push("mn");
        for (String i : s)
        {
            System.out.println(i);
        }
    }

}
