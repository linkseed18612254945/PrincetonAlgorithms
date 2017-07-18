package Sort.FasterSort;

/**
 * Created by 51694 on 2017/7/17.
 */
public class QuickSortMedianOfTree<Item extends Comparable<Item>> extends QuickSort<Item>
{
    public QuickSortMedianOfTree(Item[] x)
    {
        super(x);
    }

    @Override
    void quickSort(Item[] x, int lo, int hi)
    {

        if (lo >= hi) return;
        int partPos = lo;
        if (hi - lo == 2) partPos = treeMedian(x, lo, hi);
        int j = partition(x, lo, hi, partPos);
        quickSort(x, lo, j - 1);
        quickSort(x, j + 1, hi);
    }

    private static int treeMedian(Comparable[] x, int lo, int hi)
    {
        int max = lo, min = lo;
        for (int i = lo + 1; i <= hi; i += 1)
        {
            if (less(x[max], x[i])) max = i;
            if (less(x[i], x[min])) min = i;
        }
        return lo * 3 + 3 - max - min;
    }

    public static void main(String[] args)
    {
        Integer[] x = new Integer[]{1, 3, 5, 6, 8, 2, 4, 1};
        int m = treeMedian(x, 4, 6);
        System.out.println(m);
    }
}
