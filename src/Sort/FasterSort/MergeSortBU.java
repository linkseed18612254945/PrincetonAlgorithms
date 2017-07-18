package Sort.FasterSort;

/**
 * Created by 51694 on 2017/7/15.
 */
public class MergeSortBU<Item extends Comparable<Item>> extends MergeSort<Item>
{
    public MergeSortBU(Item[] x)
    {
        super(x);
    }

    @Override
    public Item[] sort(Item[] sequence)
    {
        Item[] sequence_temp = (Item[]) new Comparable[sequence.length];
        int n = sequence.length;
        for (int len = 1; len < n; len *= 2)
        {
            for (int lo = 0; lo < n - len; lo += 2 * len)
            {
                int mid = lo + len - 1;
                int hi = Math.min(n - 1, mid + len);
                mergeArray(sequence, sequence_temp, lo, mid, hi);
            }
        }
        return sequence;
    }
}
