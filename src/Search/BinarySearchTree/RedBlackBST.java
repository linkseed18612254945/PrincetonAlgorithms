package Search.BinarySearchTree;

import java.util.NoSuchElementException;

/**
 * Created by 51694 on 2017/7/4.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value>
{
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;


    private class Node
    {
        private Key key;
        private Value value;
        private int size;
        private Node left, right;
        private boolean color;

        Node(Key key, Value value, int size, boolean color)
        {
            this.key = key;
            this.value = value;
            this.size = size;
            this.color = color;
        }
    }

    public RedBlackBST(){}

    public int size()
    {
        return size(root);
    }

    private int size(Node x)
    {
        if (x == null) return 0;
        return x.size;
    }

    public boolean isEmpty()
    {
        return root == null;
    }


    public Value get(Key key)
    {
        keyCheck(key);
        return get(root, key);
    }

    private Value get(Node x, Key key)
    {
        if (x == null) return null;
        int cmp = x.key.compareTo(key);
        if (cmp == 0) return x.value;
        else if (cmp > 0) return get(x.left, key);
        else return get(x.right, key);
    }

    public boolean contains(Key key)
    {
        return get(key) != null;
    }


    public void put(Key key, Value value)
    {
        keyCheck(key);
        if (value == null)
        {
            return;
        }

        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node x, Key key, Value value)
    {
        if (x == null) return new Node(key, value, 1, RED);
        int cmp = x.key.compareTo(key);
        if (cmp == 0) x.value = value;
        else if (cmp < 0) x.right = put(x.right, key, value);
        else x.left = put(x.left, key, value);
        return balance(x);
    }



    private Node balance(Node x)
    {
        if (isRed(x.left) && !isRed(x.right)) x = rotateLeft(x);
        if (isRed(x.left) && isRed(x.left.left)) x =rotateRight(x);
        if (isRed(x.left) && isRed(x.right)) flipColors(x);

        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    private boolean isRed(Node x)
    {
        return x.color == RED;
    }

    private Node rotateLeft(Node x)
    {
        Node t = x.right;
        x.right = t.left;
        t.left = x;
        t.color = x.color;
        x.color = RED;
        return t;
    }

    private Node rotateRight(Node x)
    {
        Node t = x.left;
        x.left = t.right;
        t.right = x;
        t.color = x.color;
        x.color = RED;
        return t;
    }

    private void flipColors(Node x)
    {
        x.color = RED;
        x.left.color = BLACK;
        x.right.color = BLACK;
    }

    private void keyCheck(Key key)
    {
        if (key == null)
            throw new IllegalArgumentException("input key should not be null");
    }


}
