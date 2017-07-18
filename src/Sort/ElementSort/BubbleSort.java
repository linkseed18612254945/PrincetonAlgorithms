package Sort.ElementSort;
import Sort.SequenceSort;
/**
 * Created by 51694 on 2017/7/13.
 */
public class BubbleSort<Item extends Comparable<Item>> extends SequenceSort<Item>
{
    public BubbleSort(Item[] x)
    {
        super(x);
    }

    @Override
    public Item[] sort(Item[] sequence)
    {
        for (int i = 0; i < sequence.length - 1; i += 1)
        {
            for (int j = sequence.length - 1; j > i; j -= 1)
            if (less(sequence[j], sequence[j - 1]))
                exchange(sequence, j, j - 1);
        }
        return sequence;
    }
}
