package Fundamental.StackBagQueue;

/**
 * Created by 51694 on 2017/7/10.
 */
public interface Stack<Item> extends Iterable<Item>
{
    void push(Item item);
    Item pop();
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
