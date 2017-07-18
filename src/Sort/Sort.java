package Sort;

import Sort.ElementSort.*;
import Sort.FasterSort.*;
import Sort.HeapSort.HeapSort;
import Sort.NotCompareSort.CountingSort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by 51694 on 2017/7/12.
 */
public interface Sort<Item extends Comparable<Item>>
{
    Item[] sourceSequence();
    Item[] sortedSequence();

    static void main(String[] args)
    {
        int n = 200;
        Integer[] s = new Integer[n];
        Random rand = new Random();
        for (int i = 0; i < n; i += 1)
        {
            s[i] = rand.nextInt(500) - 200;
        }
        Sort<Integer> sort2 = new CountingSort(s);
        System.out.println(Arrays.toString(sort2.sourceSequence()));
        System.out.println(Arrays.toString(sort2.sortedSequence()));
    }
}
