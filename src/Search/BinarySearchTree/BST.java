package Search.BinarySearchTree;

import Search.SymbolTable.OST;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by 51694 on 2017/6/28.
 */
public class BST<Key extends Comparable<Key>, Value> implements SearchTree<Key, Value>
{
    private Node root;

    private class Node
    {
        private Key key;
        private Value value;
        private Node left, right;
        private int size; // number of nodes in subtree

        Node(Key key, Value value, int size)
        {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    BST(){}

    @Override
    public int size()
    {
        return size(root);
    }

    private int size(Node x)
    {
        if (x == null) return 0;
        return x.size;
    }

    @Override
    public int size(Key lo, Key hi)
    {
        Iterable<Key> keys = keys(lo, hi);
        int count = 0;
        for (Key k: keys) count += 1;
        return count;
    }

    @Override
    public boolean isEmpty()
    {
        return size() == 0;
    }

    @Override
    public boolean contains(Key key)
    {
        keyCheck(key);
        return get(key) != null;
    }

    @Override
    public Value get(Key key)
    {
        return get(root, key);
    }

    private Value get(Node x, Key key)
    {
        keyCheck(key);
        if (x == null) return null;
        int compare = key.compareTo(x.key);
        if (compare == 0) return x.value;
        else if (compare > 0) return get(x.right, key);
        else return get(x.left, key);
    }

    @Override
    public void put(Key key, Value value)
    {
        keyCheck(key);
        if (value == null)
        {
            delete(key);
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value)
    {
        if (x == null) return new Node(key, value, 1);
        int compare = key.compareTo(x.key);
        if (compare == 0) x.value = value;
        else if (compare > 0) x.right = put(x.right, key, value);
        else x.left = put(x.left, key, value);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public void delete(Key key)
    {
        keyCheck(key);
        root = delete(root, key);
    }

    private Node delete(Node x, Key key)
    {
        if (x == null) return null;
        int cmp = x.key.compareTo(key);
        if (cmp < 0) x.right = delete(x.right, key);
        else if (cmp > 0) x.left = delete(x.left, key);
        else
        {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public Key max()
    {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty bst");
        return max(root).key;
    }

    private Node max(Node x)
    {
        if (x.right == null) return x;
        else return max(x.right);
    }

    @Override
    public Key min()
    {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty bst");
        return min(root).key;
    }

    private Node min(Node x)
    {
        if (x.left == null) return x;
        return min(x.left);
    }

    @Override
    public Key floor(Key key)
    {
        keyCheck(key);
        if (isEmpty()) throw new NoSuchElementException("called max() with empty bst");
        return floor(root, key).key;
    }

    private Node floor(Node x, Key key)
    {
        if (x == null) return null;
        int cmp = x.key.compareTo(key);
        if (cmp == 0) return x;
        else if (cmp > 0) return floor(x.left, key);
        else
        {
            Node temp = floor(x.right, key);
            if (temp == null) return x;
            return temp;
        }
    }

    @Override
    public Key ceiling(Key key)
    {
        keyCheck(key);
        if (isEmpty()) throw new NoSuchElementException("called max() with empty bst");
        return ceiling(root, key).key;
    }

    private Node ceiling(Node x, Key key)
    {
        if (x == null) return null;
        int cmp = x.key.compareTo(key);
        if (cmp == 0) return x;
        else if (cmp < 0) return ceiling(x.right, key);
        else
        {
            Node temp = ceiling(x.left, key);
            if (temp == null) return x;
            return temp;
        }
    }

    @Override
    public int rank(Key key)
    {
        keyCheck(key);
        return rank(root, key);
    }

    private int rank(Node x, Key key)
    {
        if (x == null) return 0;
        int cmp = x.key.compareTo(key);
        if (cmp == 0) return size(x.left);
        else if (cmp > 0) return rank(x.left, key);
        else return rank(x.right, key) + size(x.left) + 1;
    }

    @Override
    public Key select(int rank)
    {
        if (rank < 0 || rank >= size())
            throw new IllegalArgumentException("Select with wrong rank");
        return select(root, rank).key;
    }

    private Node select(Node x, int rank)
    {
        if (x == null) return null;
        int k = size(x.left);
        if (rank == k) return x;
        else if (rank > k) return select(x.right, rank - k - 1);
        else return select(x.left, rank);
    }

    @Override
    public void deleteMin()
    {
        if (isEmpty()) throw new NoSuchElementException("BST under flow");
        root = deleteMin(root);
    }

    private Node deleteMin(Node x)
    {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public void deleteMax()
    {
        if (isEmpty()) throw new NoSuchElementException("BST under flow");
        root = deleteMax(root);
    }

    private Node deleteMax(Node x)
    {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
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
        LinkedList<Key> keyList = new LinkedList<>();
        keys(root, lo, hi, keyList);
        return keyList;
    }

    private void keys(Node x, Key lo, Key hi, LinkedList<Key> l)
    {
        if (x == null) return;
        int cmpLo = lo.compareTo(x.key);
        int cmpHi = hi.compareTo(x.key);
        if (cmpLo < 0) keys(x.left, lo, hi, l);
        if (cmpLo <= 0 && cmpHi >= 0) l.add(x.key);
        if (cmpHi > 0) keys(x.right, lo, hi ,l);
    }

    @Override
    public int height()
    {
        return height(root);
    }

    private int height(Node x)
    {
        if (x == null) return 0;
        if (x.size == 1) return 1;
        int lf = height(x.left);
        int rf = height(x.right);
        if (lf >= rf) return lf + 1;
        else return rf + 1;
    }

    @Override
    public void print()
    {
        print(root);
    }

    private void print(Node x)
    {
        if (x == null) return;
        print(x.left);
        System.out.println("(" + x.key + "," + x.value + "," + size(x) + ")");
        print(x.right);
    }

    private void keyCheck(Key key)
    {
        if (key == null)
            throw new IllegalArgumentException("The in put key should not be null");
    }
}
