package Sort.FasterSort;

import static Sort.ElementSort.InsertionSort.insertion;

/**
 * Created by 51694 on 2017/7/17.
 */
public class QuickSortInsert<Item extends Comparable<Item>> extends QuickSort<Item>
{
    public QuickSortInsert(Item[] x)
    {
        super(x);
    }

    @Override
    void quickSort(Item[] x, int lo, int hi)
    {
        if (hi - lo >= 5)
        {
            insertion(x, lo, hi);
            return ;
        }
        int j = partition(x, lo, hi, lo);
        quickSort(x, lo, j - 1);
        quickSort(x, j + 1, hi);
    }

}
