package Fundamental.unionFind;


/**
 * Created by 51694 on 2017/7/11.
 */
public class ArrayQuickFind implements UnionFind
{
    private int[] id;
    private int itemNum;

    public ArrayQuickFind(int itemNum)
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
        int pId = id[p];
        int qId = id[q];
        if (pId == qId) return;
        for (int i = 0; i < id.length; i += 1)
        {
            if (id[i] == pId) id[i] = qId;
        }
    }

    @Override
    public boolean isConnected(int p, int q)
    {
        check(p, q);
        return id[p] == id[q];
    }

    private void check(int p, int q)
    {
        if (p <0 || q < 0 || p >= itemNum || q >= itemNum)
            throw new IllegalArgumentException();
    }
}
