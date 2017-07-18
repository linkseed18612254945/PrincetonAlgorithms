package Sort.HeapSort;


/**
 * Created by 51694 on 2017/7/17.
 */
public class MinHeap<Item extends Comparable<Item>> extends Heap<Item>
{
    public MinHeap(int capacity) { super(capacity);}
    public MinHeap(Item[] sequence) { super(sequence);}

    @Override
    void swim(int k)
    {
        if (k == 1 || notBiggerThan(pq[k / 2], pq[k]))
            return;
        exchange(k, k / 2);
        swim(k / 2);
    }

    @Override
    void sink(int k)
    {
        if (k * 2 > n || notBiggerThan(pq[k], pq[minChild(2 * k, 2 * k + 1)]))
        {
            return;
        }
        int exchangeChild = minChild(2 * k, 2 * k + 1);
        exchange(k, exchangeChild);
        sink(exchangeChild);
    }

    private int minChild(int i, int j)
    {
        if (j > n || notBiggerThan(pq[i], pq[j]))
            return i;
        return j;
    }
}
