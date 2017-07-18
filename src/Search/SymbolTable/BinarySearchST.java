package Search.SymbolTable;


import java.util.ArrayList;

/**
 * Created by 51694 on 2017/6/27.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> implements OST<Key, Value>
{
    private static final int INIT_CAPACITY = 2;;
    private Key[] keys;
    private Value[] values;
    private int n;

    BinarySearchST(int capacity)
    {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }
    BinarySearchST()
    {
        this(INIT_CAPACITY);
    }

    @Override
    public int rank(Key key)
    {
        keyCheck(key);
        int lo = 0, hi = n - 1;
        while(lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0)  lo = mid + 1;
            else return mid;
        }
        return lo;  // lo is bigger than input key
    }

    @Override
    public Key select(int rank)
    {
        if (rank >= n || rank < 0) throw new IllegalArgumentException("illegal rank");
        return keys[rank];
    }

    @Override
    public void put(Key key, Value value)
    {
        keyCheck(key);
        if(value == null)
        {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < n && keys[i].equals(key))
        {
            values[i] = value;
            return;
        }
        if (n == keys.length) resize(2 * keys.length);
        for (int j = n; j > i; j --)
        {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        n += 1;
        assert check();
    }

    @Override
    public Value get(Key key)
    {
        keyCheck(key);
        int i = rank(key);
        if (isEmpty()) return null;
        if (i < n && keys[i].compareTo(key) == 0) return values[i];
        return null;
    }

    @Override
    public void delete(Key key)
    {
        keyCheck(key);
        int i = rank(key);
        if (i > n || keys[i].compareTo(key) != 0)
        {
            return;
        }
        for (int j = i; j < n; j += 1)
        {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        n -= 1;
        keys[n] = null;
        values[n] = null;
        if (n > 0 && n == keys.length / 4) resize(keys.length / 2);
        assert check();
    }

    @Override
    public void deleteMax()
    {
        delete(max());
    }

    @Override
    public void deleteMin()
    {
        delete(min());
    }

    @Override
    public boolean isEmpty()
    {
        return n == 0;
    }

    @Override
    public boolean contains(Key key)
    {
        return get(key) != null;
    }

    @Override
    public int size()
    {
        return n;
    }

    @Override
    public int size(Key lo, Key hi)
    {
        keyCheck(lo);
        keyCheck(hi);
        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else return rank(hi) - rank(lo);
    }

    private void resize(int capacity)
    {
        Key[] newKeys = (Key[]) new Comparable[capacity];
        Value[] newValues = (Value[]) new Comparable[capacity];
        System.arraycopy(keys, 0, newKeys, 0, n);
        System.arraycopy(values, 0, newValues, 0, n);
        keys = newKeys;
        values = newValues;
    }



    @Override
    public Key max()
    {
        return keys[n - 1];
    }

    @Override
    public Key min()
    {
        return keys[0];
    }

    @Override
    public Key floor(Key key)
    {
        keyCheck(key);
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) return keys[i];
        if (i == 0) return null;
        return keys[i - 1];
    }

    @Override
    public Key ceiling(Key key)
    {
        keyCheck(key);
        int i = rank(key);
        if (i == n) return null;
        return keys[i];
    }

    @Override
    public Iterable<Key> keys()
    {
        return keys(min(), max());
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi)
    {
        keyCheck(lo);
        keyCheck(hi);
        ArrayList<Key> keyList = new ArrayList<>();
        if (lo.compareTo(hi) > 0) return keyList;
        for (int i = rank(lo); i < rank(hi); i += 1) keyList.add(keys[i]);
        if (contains(hi)) keyList.add(hi);
        return keyList;
    }

    private void keyCheck(Key key)
    {
        if (key == null)
        {
            throw new IllegalArgumentException("input key is null");
        }
    }

    private boolean check()
    {
        return isSorted() && rankCheck();
    }

    private boolean isSorted()
    {
        for (int i = 1; i < size(); i += 1)
            if (keys[i].compareTo(keys[i + 1]) < 0) return false;
        return true;
    }

    private boolean rankCheck()
    {
        for (int i = 0; i < size(); i += 1)
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) return false;
        for (int i = 0; i < size(); i += 1)
            if (i != rank(select(i))) return false;
        return true;
    }
}

