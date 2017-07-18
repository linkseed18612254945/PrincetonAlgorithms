package Search.BinarySearchTree;

/**
 * Created by 51694 on 2017/7/3.
 */
public class BSTtest
{
    public static void main(String[] args)
    {
        BST<Integer, String> test = new BST<>();
        BST<Integer, String> testnull = new BST<>();
        test.put(3, "op");
        test.put(1, "link");
        test.put(9, "iio");
        test.put(7, "ukl");
        test.put(4, "lmk");
        test.put(5, "tty");
        test.put(12, "bg");

        test.print();
        System.out.println(test.height());

    }
}
