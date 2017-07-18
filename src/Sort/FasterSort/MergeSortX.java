package Sort.FasterSort;

import static Sort.ElementSort.InsertionSort.insertion;

/**
 * Created by 51694 on 2017/7/13.
 */
public class MergeSortX<Item extends Comparable<Item>> extends MergeSort<Item>
{
    private final static int CUTOFF = 3;
    public MergeSortX(Item[] x)
    {
        super(x);
    }

    @Override
    void mergeSort(Item[] a, Item[] aux, int lo, int hi)
    {
        if (hi - lo <= CUTOFF)
        {
            insertion(a, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, aux, lo, mid);
        mergeSort(a, aux, mid + 1, hi);
        if (less(a[mid + 1], a[mid]))
            mergeArray(a, aux, lo , mid, hi);
    }

}
