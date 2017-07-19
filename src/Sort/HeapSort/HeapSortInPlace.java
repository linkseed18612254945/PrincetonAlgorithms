package Sort.HeapSort;

import static Sort.HeapSort.Heap.notBiggerThan;
import static Sort.HeapSort.MinHeap.minChild;

/**
 * Created by 51694 on 2017/7/18.
 */
public class HeapSortInPlace<Item extends Comparable<Item>> extends HeapSort<Item>
{
    public HeapSortInPlace(Item[] x)
    {
        super(x);
    }

    @Override
    public Item[] sort(Item[] sequence)
    {
        int n = sequence.length;
        for (int k = n / 2; k >= 1; k-=1)
            sink(sequence, k, n);
        while (n > 1)
        {
            exchange(sequence, 1, n);
            n -= 1;
            sink(sequence, 1, n);
        }
        return sequence;
    }
    
    private void sink(Item[] pq, int k, int n)
    {
        if (k * 2 > n || notBiggerThan(pq[k], pq[minChild(pq, 2 * k, 2 * k + 1, n)]))
        {
            return;
        }
        int exchangeChild = minChild(pq, 2 * k, 2 * k + 1, n);
        exchange(pq, k, exchangeChild);
        sink(pq, exchangeChild, n);
    }

}
