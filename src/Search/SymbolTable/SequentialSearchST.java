package Search.SymbolTable;

import java.util.ArrayList;

/**
 * Created by 51694 on 2017/6/26.
 */
public class SequentialSearchST<Key, Value> implements ST<Key, Value>
{
    private int n;
    private Node head;

    class Node
    {
        Key key;
        Value value;
        Node next;

        Node(Key key,Value value)
        {
            this.key = key;
            this.value = value;
            this.next = null;
        }
        Node(Key key,Value value, Node next)
        {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    SequentialSearchST()
    {
        n = 0;
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
        for (Node p = head; p != null; p = p.next)
        {
            if (p.key.equals(key))
            {
                p.value = value;
                return;
            }
        }
        head = new Node(key, value, head);
        n += 1;
    }

    @Override
    public Value get(Key key)
    {
        keyCheck(key);
        for(Node p = head; p != null; p = p.next)
        {
            if (p.key.equals(key))
            {
                return p.value;
            }
        }
        return null;
    }

    @Override
    public void delete(Key key)
    {
        keyCheck(key);
        head = delete(head, key);
        n -= 1;
    }

    private Node delete(Node node, Key key)
    {
        if (node == null)
        {
            return null;
        }
        if (node.key.equals(key))
        {
            return node.next;
        }
        else
        {
            node.next = delete(node.next, key);
            return node;
        }
    }

    @Override
    public int size()
    {
        return n;
    }

    @Override
    public boolean isEmpty()
    {
        return head == null;
    }

    @Override
    public boolean contains(Key key)
    {
        keyCheck(key);
        return get(key) != null;
    }

    @Override
    public Iterable<Key> keys()
    {
        ArrayList<Key> keys = new ArrayList<>();
        for (Node p = head; p != null; p = p.next)
        {
            keys.add(p.key);
        }
        return keys;
    }


    private void keyCheck(Key key)
    {
        if (key == null)
        {
            throw new IllegalArgumentException("put key is null");
        }
    }
}

