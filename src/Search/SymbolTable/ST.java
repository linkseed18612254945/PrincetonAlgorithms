package Search.SymbolTable;

/**
 * Created by 51694 on 2017/6/26.
 */
public interface ST<Key, Value>
{
    void put(Key key, Value value);
    Value get(Key key);
    void delete(Key key);
    boolean contains(Key key);
    boolean isEmpty();
    int size();
    Iterable<Key> keys();

    default void print()
    {
        Iterable<Key> keys = keys();
        for (Key key: keys)
        {
            System.out.print(key + ":" + get(key) + "|");
        }
    }
}
