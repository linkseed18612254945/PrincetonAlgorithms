package Fundamental.StackBagQueue;

/**
 * Created by 51694 on 2017/7/22.
 */
public class SingleStack<Item extends Comparable<Item>> extends LLStack<Item>
{
    public SingleStack(){}

    @Override
    public void push(Item item)
    {
        while (!isEmpty() && item.compareTo(peek()) >= 0)
            pop();
        items.addFirst(item);
    }

    public static void main(String[] args)
    {
        SingleStack<Integer> ss = new SingleStack<>();
        ss.push(5);
        ss.push(4);
        ss.push(2);
        ss.push(3);
        ss.push(6);
        ss.push(1);
        ss.print();
    }
}
