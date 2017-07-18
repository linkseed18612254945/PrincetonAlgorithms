package Sort.HeapSort;

/**
 * Created by 51694 on 2017/7/12.
 */
public interface PriorityQueue<Item extends Comparable<Item>>
{
    void add(Item item);
    int size();
    boolean isEmpty();
    Item peekTop();
    Item removeTop();
}
