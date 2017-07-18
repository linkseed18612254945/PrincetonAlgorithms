package Fundamental.LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by 51694 on 2017/7/7.
 */
public class AList<Item> implements Iterable<Item>
{
    private Item[] items;
    private int end;
    private int head;
    private static final int REFACTOR = 2;
    private static final int INITIATE_CAPACITY = 8;

    public AList()
    {
        items = (Item[]) new Object[INITIATE_CAPACITY];
        head = 0;
        end = 0;
    }

    public int size()
    {
        return end - head;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public Item getFirst()
    {
        return get(0);
    }


    public void addLast(Item item)
    {
        if (end == items.length) resize(items.length * REFACTOR);
        items[end] = item;
        end += 1;
    }

    public Item getLast()
    {
        if (isEmpty()) return null;
        return get(end - 1);
    }

    public void removeLast()
    {
        if (isEmpty()) return;
        if (end / items.length <= 1 / (REFACTOR * 2)) resize(items.length / REFACTOR);
        end -= 1;
    }

    public void removeFirst()
    {
        if (isEmpty()) return;
        head += 1;
        if (head == end)
        {
            head = 0;
            end = 0;
            resize(INITIATE_CAPACITY);
        }
    }

    public Item get(int i)
    {
        return items[i];
    }

    private void resize(int capacity)
    {
        Item[] newItems = (Item[]) new Object[capacity];
        System.arraycopy(items, head, newItems, head, size());
        items = newItems;
    }

    @Override
    public Iterator<Item> iterator()
    {
        return new ALIterator();
    }

    private class ALIterator implements Iterator<Item>
    {
        int i;
        ALIterator(){ i = end - 1;}

        @Override
        public boolean hasNext()
        {
            return i >= head;
        }

        @Override
        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item current = items[i];
            i -= 1;
            return current;
        }
    }

    public static void main(String[] args)
    {
        AList<String> a = new AList<>();
        a.addLast("mm");
        a.addLast("lp");
        a.addLast("lkk");
        a.removeLast();
        for (String x: a)
        {
            System.out.println(x);
        }
    }
}
