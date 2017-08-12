package Sort.HeapSort;

import static Sort.HeapSort.Heap.notBiggerThan;
import static Sort.HeapSort.MaxHeap.*;

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
        buildMaxHeap(sequence);
        for (int i = sequence.length - 1; i >= 0; i -= 1)
        {
            exchange(sequence, i, 0);
            sink(sequence, 0, i);
        }
        return sequence;
    }

    private  void buildMaxHeap(Item[] sequence)
    {
        for (int i = sequence.length / 2 - 1; i >= 0; i -= 1)
        {
            sink(sequence, i, sequence.length);
        }
    }

    
    private void sink(Item[] pq, int k, int n)
    {
        if (k >= n / 2)
        {
            return;
        }
        int maxChild = maxChild(pq, k , n);
        if (bigThan(pq[k], pq[maxChild]))
            return;
        exchange(pq, k, maxChild);
        sink(pq, maxChild, n);
    }

    private int maxChild(Item[] sequence, int k, int n)
    {
        int left = (k + 1) * 2 - 1;
        int right = (k + 1) * 2;
        if (right >= n)
            return left;
        return bigThan(sequence[left], sequence[right]) ? left: right;
    }

    private boolean bigThan(Item a, Item b)
    {
        int cmp = a.compareTo(b);
        return cmp >= 0;
    }
}
