package week4.SymbolTable;

import java.util.Iterator;

/**
 * Created by 51694 on 2017/4/6.
 */
public interface ST<K, V>
{
    void put(K key, V value);
    V get(K key);
    void delete(K key);
    boolean contain(K key);
    boolean isEmpty();
    int size();
    int size(K lo, K hi); // number of keys in [lo..hi]
    K min();
    K max();
    K floor(K key); // largest key <= given key
    K ceiling(K key); // smallest key >= given key
    int rank(K key); // number of keys less than key
    K select(int k);// key of rank k
    void deleteMin();// delete smallest key
    void deleteMax();// delete largest key
    Iterator<K> keys();
    Iterator<K> keys(K lo, K hi);
}
