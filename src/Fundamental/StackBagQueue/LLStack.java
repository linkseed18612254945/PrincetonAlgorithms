package Fundamental.StackBagQueue;

import Fundamental.LinkedList.LinkedList;
import Fundamental.LinkedList.SLList;

import java.util.Iterator;

/**
 * Created by 51694 on 2017/7/10.
 */
public class LLStack<Item extends Comparable<Item>> implements Stack<Item>
{
    LinkedList<Item> items;

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

    public Item popBottom()
    {
        Item top = pop();
        if (isEmpty())
            return top;
        else
        {
            Item bottom =  popBottom();
            push(top);
            return bottom;
        }
    }

    public void reverse()
    {
        if (isEmpty())
            return;
        Item bottom = popBottom();
        reverse();
        push(bottom);
    }

    public void sort()
    {
        int count;
        LLStack<Item> tempStack = new LLStack<>();
        while (!isEmpty())
        {
            count = 0;
            Item top = pop();
            while(!tempStack.isEmpty() && tempStack.peek().compareTo(top) > 0)
            {
                push(tempStack.pop());
                count += 1;
            }
            tempStack.push(top);
            for (int i = 0; i < count;i += 1)
                tempStack.push(pop());
        }
        items = tempStack.items;
    }

    public static void main(String[] args)
    {
        LLStack<Integer> s = new LLStack<>();
        s.push(11);
        s.push(2);
        s.push(7);
        s.push(3);
        s.push(15);
        s.print();
        s.sort();
        s.print();
    }

}
