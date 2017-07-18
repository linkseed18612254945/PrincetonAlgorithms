package Sort.ElementSort;

import Sort.SequenceSort;

/**
 * Created by 51694 on 2017/7/13.
 */
public class ShellSort<Item extends Comparable<Item>> extends SequenceSort<Item>
{
    public ShellSort(Item[] x)
    {
        super(x);
    }

    @Override
    public Item[] sort(Item[] sequence)
    {
        int n = sequence.length;
        for (int gap = stepChoose(n); gap > 0; gap = stepChoose(gap))
        {
            for (int i = 0; i < gap; i += 1)
            {
                for (int j = i + gap; j < n; j += gap)
                {
                    int insertPos = j;
                    Item insertItem = sequence[j];
                    while (insertPos >= gap && less(insertItem, sequence[insertPos - gap]))
                    {
                        sequence[insertPos] = sequence[insertPos - gap];
                        insertPos -= gap;
                    }
                    sequence[insertPos] = insertItem;
                }
            }
        }
        return sequence;
    }

    private int stepChoose(int n)
    {
        return n / 2;
    }
}
