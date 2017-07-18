package Search.SymbolTable;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by 51694 on 2017/6/26.
 */
public class ArrayST<Key, Value> implements ST<Key, Value>
{
    private static final int INIT_SIZE = 8;
    private Key[] keys;
    private Value[] values;
    private int n;

    ArrayST()
    {
        keys = (Key[]) new Object[INIT_SIZE];
        values = (Value[]) new Object[INIT_SIZE];
        n = 0;
    }

    @Override
    public void put(Key key, Value val)
    {
        delete(key);
        if (n >= keys.length)
        {
            resize(keys.length * 2);
        }
        keys[n] = key;
        values[n] = val;
        n += 1;
    }

    @Override
    public Value get(Key key)
    {
        for (int i = 0; i < n; i += 1)
        {
            if (keys[i].equals(key))
            {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public void delete(Key key)
    {
        for (int i = 0; i < n; i += 1)
        {
            if (keys[i].equals(key))
            {
                keys[i] = keys[n - 1];
                values[i] = values[n - 1];
                keys[n - 1] = null;
                values[n - 1] = null;
                n -= 1;
                if (n > 0 && n <= keys.length / 4)
                {
                    resize(keys.length / 2);
                }
                return;
            }
        }
    }

    @Override
    public boolean contains(Key key)
    {
        for (int i = 0; i < n; i += 1)
        {
            if (keys[i].equals(key))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty()
    {
        return keys.length == 0;
    }

    @Override
    public int size()
    {
        return n;
    }

    @Override
    public Iterable<Key> keys()
    {
        ArrayList<Key> keyList = new ArrayList<>();
        for (int i = 0; i < n; i += 1)
        {
            keyList.add(keys[i]);
        }
        return keyList;
    }

    public void resize(int capacity)
    {
        Key[] newKeys = (Key[]) new Object[capacity];
        Value[] newValues = (Value[]) new Object[capacity];
        System.arraycopy(keys, 0, newKeys, 0, n);
        System.arraycopy(values, 0, newValues, 0, n);
        keys = newKeys;
        values = newValues;
    }
}
