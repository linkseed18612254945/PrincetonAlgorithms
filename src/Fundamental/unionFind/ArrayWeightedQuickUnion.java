package Fundamental.unionFind;

/**
 * Created by 51694 on 2017/7/11.
 */
public class ArrayWeightedQuickUnion implements UnionFind
{
    private int[] id;
    private int[] size;
    private int itemNum;

    public ArrayWeightedQuickUnion(int itemNum)
    {
        if (itemNum < 1) throw new IllegalArgumentException();
        this.itemNum = itemNum;
        id = new int[itemNum];
        size = new int[itemNum];
        initSelfUnion(id);
        initSelfSize(size);

    }

    private void initSelfUnion(int[] id)
    {
        for (int i = 0; i < id.length; i += 1)
        {
            id[i] = i;
        }
    }

    private void initSelfSize(int[] size)
    {
        for (int i = 0; i < size.length; i += 1)
        {
            size[i] = 1;
        }
    }

    @Override
    public void connect(int p, int q)
    {
        check(p, q);
        int rootP = findRoot(p);
        int rootQ = findRoot(q);
        if (size[p] >= size[q])
        {
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        else
        {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
    }

    @Override
    public boolean isConnected(int p, int q)
    {
        return findRoot(p) == findRoot(q);
    }

    private int findRoot(int p)
    {
        while (p != id[p])
            p = id[p];
        return p;
    }


    private void check(int p, int q)
    {
        if (p <0 || q < 0 || p >= itemNum || q >= itemNum)
            throw new IllegalArgumentException();
    }
}
