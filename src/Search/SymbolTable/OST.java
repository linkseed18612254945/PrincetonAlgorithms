package Search.SymbolTable;

import java.util.Iterator;

/**
 * Created by 51694 on 2017/6/26.
 */
public interface OST<Key extends Comparable<Key>, Value>  extends ST<Key, Value>
{
    Key min();
    Key max();
    Key floor(Key key);
    Key ceiling(Key key);
    int rank(Key key);
    Key select(int rank);
    void deleteMin();
    void deleteMax();
    int size(Key lo, Key hi);
    Iterable<Key> keys(Key lo, Key hi);
}
