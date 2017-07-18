package Sort.ElementSort;

import Sort.SequenceSort;

/**
 * Created by 51694 on 2017/7/12.
 */
public class InsertionSort<Item extends Comparable<Item>> extends SequenceSort<Item>
{
    public InsertionSort(Item[] sequence)
    {
        super(sequence);
    }

    @Override
    public Item[] sort(Item[] sequence)
    {
        insertion(sequence, 0, sequence.length - 1);
        return sequence;
    }

    public static void insertion(Comparable[] a, int lo, int hi)
    {
        for (int i = lo + 1; i <= hi; i += 1)
        {
            int insertPos = i;
            Comparable insertItem = a[i];
            while (insertPos > lo && less(insertItem, a[insertPos - 1]))
            {
                a[insertPos] = a[insertPos - 1];
                insertPos -= 1;
            }
            a[insertPos] = insertItem;
        }
    }
}
