package Fundamental.unionFind;

/**
 * Created by 51694 on 2017/7/11.
 */
public class ArrayQuickUion implements UnionFind
{
    int[] id;
    int itemNum;

    public ArrayQuickUion(int itemNum)
    {
        if (itemNum < 1) throw new IllegalArgumentException();
        this.itemNum = itemNum;
        id = new int[itemNum];
        initSelfUnion(id);
    }

    private void initSelfUnion(int[] id)
    {
        for (int i = 0; i < id.length; i += 1)
        {
            id[i] = i;
        }
    }

    @Override
    public void connect(int p, int q)
    {
        check(p, q);
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        id[pRoot] = qRoot;
    }

    @Override
    public boolean isConnected(int p, int q)
    {
        return findRoot(p) == findRoot(q);
    }

    private int findRoot(int p)
    {
        while (id[p] != p)
            p = id[p];
        return p;
    }

    private void check(int p, int q)
    {
        if (p <0 || q < 0 || p >= itemNum || q >= itemNum)
            throw new IllegalArgumentException();
    }
}
