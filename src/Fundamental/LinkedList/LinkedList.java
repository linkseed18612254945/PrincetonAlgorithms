package Fundamental.LinkedList;

/**
 * Created by 51694 on 2017/7/6.
 */
public interface LinkedList<Item> extends Iterable<Item>
{
    boolean isEmpty();
    int size();
    void addFirst(Item item);
    Item getFirst();
    void removeFirst();
    void addLast(Item item);
    Item getLast();
    void removeLast();
    void insert(int i, Item item);
    Item get(int i);


    default public void print()
    {
        for (int i = 0; i < size(); i += 1)
        {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
}
