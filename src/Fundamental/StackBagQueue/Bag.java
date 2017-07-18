package Fundamental.StackBagQueue;

/**
 * Created by 51694 on 2017/7/7.
 */
public interface Bag<Item> extends Iterable<Item>
{
    void add(Item item);
    boolean isEmpty();
    int size();
}
