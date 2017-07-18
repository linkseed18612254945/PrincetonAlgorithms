package Search.BinarySearchTree;

import Search.SymbolTable.OST;

/**
 * Created by 51694 on 2017/7/4.
 */
public interface SearchTree <Key extends Comparable<Key>, Value> extends OST <Key, Value>
{
    void print();
    int height();
}
