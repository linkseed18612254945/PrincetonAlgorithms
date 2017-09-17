package Fundamental.StackBagQueue;

import java.util.Iterator;

public class QueueByTwoStack<Item extends Comparable<Item>> implements Queue<Item>
{
    private Stack<Item> stackIn;
    private Stack<Item> stackOut;

    @Override
    public boolean isEmpty()
    {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    @Override
    public int size()
    {
        return stackIn.size() + stackOut.size();
    }

    public QueueByTwoStack()
    {
        stackIn = new LLStack<>();
        stackOut = new LLStack<>();
    }

    @Override
    public void enqueue(Item item)
    {
        stackIn.push(item);
    }

    @Override
    public Item dequeue()
    {
        if (stackOut.isEmpty())
            pullDataToOutStack();
        return stackOut.pop();
    }

    @Override
    public Item peek()
    {
        return stackOut.peek();
    }

    @Override
    public Iterator<Item> iterator()
    {
        return stackOut.iterator();
    }

    private void pullDataToOutStack()
    {
        while (!stackIn.isEmpty())
        {
            Item data = stackIn.pop();
            stackOut.push(data);
        }
    }
}
