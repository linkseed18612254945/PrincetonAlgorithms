package Sort.HeapSort;

import Sort.SequenceSort;

/**
 * Created by 51694 on 2017/7/17.
 */
public class HeapSort<Item extends Comparable<Item>> extends SequenceSort<Item>
{
    private Heap<Item> heap;
    public HeapSort(Item[] x)
    {
        super(x);
    }

    @Override
    public Item[] sort(Item[] sequence)
    {
        heap = new MinHeap<>(sequence);
        for (int i = 0; i < sequence.length; i += 1)
            sequence[i] = heap.removeTop();
        return sequence;
    }

}
