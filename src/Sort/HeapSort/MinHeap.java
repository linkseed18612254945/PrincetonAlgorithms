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
        if (k * 2 > n || notBiggerThan(pq[k], pq[minChild(pq, 2 * k, 2 * k + 1, n)]))
        {
            return;
        }
        int exchangeChild = minChild(pq, 2 * k, 2 * k + 1, n);
        exchange(k, exchangeChild);
        sink(exchangeChild);
    }

    static int minChild(Comparable[] sequence, int i, int j, int n)
    {
        if (j > n || notBiggerThan(sequence[i], sequence[j]))
            return i;
        return j;
    }
}
