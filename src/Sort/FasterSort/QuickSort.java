package Sort.FasterSort;

import Sort.SequenceSort;

import java.util.Arrays;

/**
 * Created by 51694 on 2017/7/16.
 */
public class QuickSort<Item extends Comparable<Item>> extends SequenceSort<Item>
{
    public QuickSort(Item[] x)
    {
        super(x);
    }

    @Override
    public Item[] sort(Item[] sequence)
    {
        quickSort(sequence, 0, sequence.length - 1);
        return sequence;
    }

    void quickSort(Item[] x, int lo, int hi)
    {
        if (lo >= hi) return;
        int j = partition(x, lo, hi, lo);
        quickSort(x, lo, j - 1);
        quickSort(x, j + 1, hi);
    }

    int partition(Item[] x, int lo, int hi, int partitioning)
    {
        Item partitioningItem = x[partitioning];
        while (lo < hi)
        {
            if (!less(x[hi], partitioningItem))
            {
                hi -= 1;
                continue;
            }
            if (!less(partitioningItem, x[lo]))
            {
                lo += 1;
                continue;
            }
            exchange(x, lo, hi);
        }
        exchange(x, partitioning, lo);
        return lo;
    }

    public static void main(String[] args)
    {
        Integer[] s = new Integer[]{9,4,13,6,3,2,1,5,8,0};
        QuickSort<Integer> qs = new QuickSort<>(s);
        int j = qs.partition(s, 0, 9, 0);
        System.out.println(j);
        System.out.println(Arrays.toString(s));
    }
}
