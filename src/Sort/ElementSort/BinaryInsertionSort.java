package Sort.ElementSort;

import Sort.SequenceSort;

/**
 * Created by 51694 on 2017/7/13.
 */
public class BinaryInsertionSort<Item extends Comparable<Item>> extends SequenceSort<Item>
{
    public BinaryInsertionSort(Item[] x)
    {
        super(x);
    }

    @Override
    public Item[] sort(Item[] sequence)
    {
        int n = sequence.length;
        for (int i = 1; i < n; i += 1)
        {
            Item insertItem = sequence[i];
            int lo = 0, hi = i;
            while (lo < hi)
            {
                int mid = lo + (hi - lo) / 2;
                if (less(insertItem, sequence[mid]))
                    hi = mid;
                else
                    lo = mid + 1;
            }
            for (int j = i; j > lo; j -= 1)
                sequence[j] = sequence[j - 1];
            sequence[lo] = insertItem;
        }
        return sequence;
    }
}
