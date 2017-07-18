package Sort.HeapSort;


/**
 * Created by 51694 on 2017/7/12.
 */
abstract class Heap<Item extends Comparable<Item>> implements PriorityQueue<Item>
{
    Item[] pq;
    int n;
    private static final int REFACTOR = 2;

    public Heap(int initCapacity)
    {
        pq = (Item[]) new Comparable[initCapacity + 1];
        n = 0;
    }

    public Heap(Item[] source)
    {
        pq = (Item[]) new Comparable[source.length + 1];
        for (Item x: source)
            add(x);
    }

    @Override
    public boolean isEmpty()
    {
        return n == 0;
    }

    @Override
    public int size()
    {
        return n;
    }

    @Override
    public void add(Item item)
    {
        if (n == pq.length - 1) resize(pq.length * REFACTOR);
        n += 1;
        pq[n] = item;
        swim(n);
    }


    @Override
    public Item peekTop()
    {
        return pq[1];
    }

    @Override
    public Item removeTop()
    {
        Item top = pq[1];
        exchange(1, n);
        pq[n] = null;
        n -= 1;
        sink(1);
        if (n >= 1 && n < (pq.length - 1) / 4) resize(pq.length / 2);
        return top;
    }

    abstract void swim(int k);

    abstract void sink(int k);


    boolean notBiggerThan(Item x, Item y)
    {
        int cmp = x.compareTo(y);
        return cmp <= 0;
    }

    void exchange(int i, int j)
    {
        Item temp = pq[i];
        pq[i] = pq[j];
        pq[j]= temp;
    }

    private void resize(int capacity)
    {
        Item[] newpq = (Item[]) new Comparable[capacity];
        System.arraycopy(pq, 1, newpq, 1, n);
        pq = newpq;
    }

}
