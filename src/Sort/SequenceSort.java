package Sort;

/**
 * Created by 51694 on 2017/7/12.
 */
public abstract class SequenceSort<Item extends Comparable<Item>> implements Sort<Item>
{
    private Item[] sequence;
    public SequenceSort(Item[] sequence)
    {
        this.sequence = sequence;
    }

    @Override
    public Item[] sourceSequence()
    {
        return sequence;
    }

    @Override
    public Item[] sortedSequence()
    {
        Item[] sortedSequence = sequence.clone();
        return sort(sortedSequence);
    }

    public static boolean less(Comparable x, Comparable y)
    {
        int cmp = x.compareTo(y);
        return cmp < 0;
    }


    public static void exchange(Comparable[] sequence, int i, int j)
    {
        Comparable temp = sequence[i];
        sequence[i] = sequence[j];
        sequence[j] = temp;
    }

    public abstract Item[] sort(Item[] sequence);
}
