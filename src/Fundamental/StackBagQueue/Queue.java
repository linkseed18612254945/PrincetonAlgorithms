package Fundamental.StackBagQueue;

/**
 * Created by 51694 on 2017/7/10.
 */
public interface Queue<Item> extends Iterable<Item>
{
    void enqueue(Item item);
    Item dequeue();
    Item peek();
    int size();
    boolean isEmpty();

    default void print()
    {
        for(Item x : this)
        {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
