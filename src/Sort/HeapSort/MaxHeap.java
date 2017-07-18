package Sort.HeapSort;

import static Sort.SequenceSort.exchange;

/**
 * Created by 51694 on 2017/7/17.
 */
public class MaxHeap<Item extends Comparable<Item>> extends Heap<Item>
{
    public MaxHeap(int capacity) { super(capacity);}
    public MaxHeap(Item[] sequence) { super(sequence);}

    @Override
    void swim(int k)
    {
        if (k == 1 || notBiggerThan(pq[k], pq[k / 2]))
            return;
        exchange(k, k / 2);
        swim(k / 2);
    }

    @Override
    void sink(int k)
    {
        if (k * 2 > n || notBiggerThan(pq[maxChild(k * 2, k * 2 + 1)], pq[k]))
            return;
        int exchangeChild = maxChild(k * 2, k * 2 + 1);
        exchange(k, exchangeChild);
        sink(exchangeChild);
    }

    private int maxChild(int i, int j)
    {
        if (j > n || notBiggerThan(pq[j], pq[i]))
            return i;
        return j;
    }
}
