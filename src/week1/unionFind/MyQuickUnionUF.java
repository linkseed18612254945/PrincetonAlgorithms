package week1.unionFind;

/**
 * Created by 51694 on 2017/3/29.
 */
public class MyQuickUnionUF implements UF
{
    int[] id;
    int itemNum;

    MyQuickUnionUF(int N)
    {
        itemNum = N;
        id = new int[itemNum];
        for (int i = 0; i < itemNum; i += 1)
        {
            id[i] = i;
        }
    }
    MyQuickUnionUF(int N, int initN)
    {
        itemNum = N;
        id = new int[itemNum];
        for (int i = 0; i < itemNum; i += 1)
        {
            id[i] = initN;
        }
    }

    int findRoot(int p)
    {
        if (id[p] == p)
        {
            return p;
        }
        return findRoot(id[p]);
    }

    @Override
    public void union(int p, int q)
    {
        int rootOfP = findRoot(p);
        int rootOfQ = findRoot(q);
        id[rootOfP] = rootOfQ;
    }

    @Override
    public boolean isUnion(int p, int q)
    {
        return findRoot(p) == findRoot(q);
    }
}
