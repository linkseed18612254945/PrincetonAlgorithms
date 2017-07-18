package Sort.NotCompareSort;

import Sort.Sort;

/**
 * Created by 51694 on 2017/7/17.
 */
public class CountingSort implements Sort
{
    private Integer[] sequence;
    public CountingSort(Integer[] sequence)
    {
        this.sequence = sequence;
    }

    @Override
    public Integer[] sourceSequence()
    {
        return sequence;
    }

    @Override
    public Integer[] sortedSequence()
    {
        int max = sequence[0];
        int min = sequence[0];
        for (int x: sequence)
        {
            if (x > max) max = x;
            if (x < min) min = x;
        }
        int[] count = new int[max - min + 1];
        for (int x: sequence)
            count[x - min] += 1;
        Integer[] sorted = new Integer[sequence.length];
        int k = 0;
        for (int i = 0; i < count.length; i += 1)
            for (int j = 0; j < count[i]; j += 1, k += 1)
                sorted[k] = i + min;
        return sorted;
    }
}