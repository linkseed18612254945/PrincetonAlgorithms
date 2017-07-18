package Sort.FasterSort;

import Sort.SequenceSort;

/**
 * Created by 51694 on 2017/7/13.
 */
public class MergeSort<Item extends Comparable<Item>> extends SequenceSort<Item>
{
    public MergeSort(Item[] x)
    {
        super(x);
    }

    @Override
    public Item[] sort(Item[] sequence)
    {
        Item[] sequence_temp = (Item[]) new Comparable[sequence.length];
        mergeSort(sequence, sequence_temp, 0, sequence.length - 1);
        return sequence;
    }


    void mergeSort(Item[] a, Item[] aux, int lo, int hi)
    {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, aux, lo, mid);
        mergeSort(a, aux, mid + 1, hi);
        mergeArray(a, aux, lo, mid, hi);
    }

    void mergeArray(Item[] a, Item[] aux, int lo, int mid, int hi)
    {
        int i = lo;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= hi)
        {
            if (less(a[i], a[j]))
            {
                aux[k] = a[i];
                i += 1;
            }
            else
            {
                aux[k] = a[j];
                j += 1;
            }
            k += 1;
        }

        while (i <= mid)
        {
            aux[k] = a[i];
            i += 1;
            k += 1;
        }

        while (j <= hi)
        {
            aux[k] = a[j];
            j += 1;
            k += 1;
        }
        System.arraycopy(aux, 0, a, lo, k);
    }
}
