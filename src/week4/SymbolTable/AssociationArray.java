package week4.SymbolTable;

import org.omg.CORBA.Object;

import java.util.Iterator;

/**
 * Created by 51694 on 2017/4/6.
 */
public class AssociationArray<K, V> implements ST<K, V>
{
    private int size;
    private K[] keys;
    private V[] values;
    private int CAPACITY = 50;

    public AssociationArray()
    {
        size = 0;
        keys = (K[]) new Object[CAPACITY];
        values = (V[]) new Object[CAPACITY];
    }


    private int indexKey(K key)
    {
        for (int i = 0; i < size; i += 1)
        {
            if (key.equals(keys[i]) && values[i] != null)
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value)
    {
        int index = indexKey(key);
        if (index == -1)
        {
            keys[size] = key;
            values[size] = value;
            size += 1;
        }
        else
        {
            values[index] = value;
        }
    }

    @Override
    public V get(K key)
    {
        int index = indexKey(key);
        if (index == -1)
        {
            return null;
        }
        else
        {
            return values[index];
        }
    }

    @Override
    public void delete(K key)
    {
        int index = indexKey(key);
        values[index] = null;
        size -= 1;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean contain(K key)
    {
        return indexKey(key) != -1;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public Iterator<K> keys()
    {
        return new KeyIterator();
    }

    class KeyIterator implements Iterator<K>
    {
        private int nextPos;
        public KeyIterator()
        {
            nextPos = 0;
        }

        public boolean hasNext()
        {
            return nextPos < size;
        }

        public K next()
        {
            K returnKey = keys[nextPos];
            nextPos += 1;
            return returnKey;
        }

    }
}
