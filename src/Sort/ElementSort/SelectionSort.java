package Sort.ElementSort;

import Sort.SequenceSort;

/**
 * Created by 51694 on 2017/7/12.
 */
public class SelectionSort<Item extends Comparable<Item>> extends SequenceSort<Item>
{
    public SelectionSort(Item[] sequence)
    {
        super(sequence);
    }

    @Override
    public Item[] sort(Item[] sequence)
    {
        for (int i = 0; i < sequence.length - 1; i += 1)
        {
            int min = i;
            for (int j = i + 1; j < sequence.length; j += 1)
            {
                if (less(sequence[j], sequence[min]))
                    min = j;
            }
            exchange(sequence, i, min);
        }
        return sequence;
    }


}
