package Fundamental.StackBagQueue;

import java.util.Iterator;

public class GetMinStack<Item extends Comparable<Item>> implements Stack<Item>
{
    private Stack<Item> dataStack;
    private Stack<Item> minStack;

    public GetMinStack()
    {
        dataStack = new LLStack<>();
        minStack = new LLStack<>();
    }

    @Override
    public boolean isEmpty()
    {
        return dataStack.isEmpty();
    }

    @Override
    public int size()
    {
        return dataStack.size();
    }

    @Override
    public void push(Item item)
    {
        dataStack.push(item);
        if (minStack.isEmpty())
            minStack.push(item);
        else
        {
            int cmp = item.compareTo(minStack.peek());
            if (cmp <= 0)
                minStack.push(item);
            else
                minStack.push(minStack.peek());
        }
    }

    @Override
    public Item pop()
    {
        minStack.pop();
        return dataStack.pop();
    }

    @Override
    public Item peek()
    {
        return dataStack.peek();
    }

    public Item min()
    {
        return minStack.peek();
    }

    @Override
    public Iterator<Item> iterator()
    {
        return dataStack.iterator();
    }
}
