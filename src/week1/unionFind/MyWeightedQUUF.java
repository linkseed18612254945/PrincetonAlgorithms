package week1.unionFind;

/**
 * Created by 51694 on 2017/3/30.
 */
public class MyWeightedQUUF extends MyQuickUnionUF implements UF
{
    private int[] size;

    MyWeightedQUUF(int N)
    {
        super(N);
        size = new int[N];
        for (int i = 0; i < N; i += 1)
        {
            size[i] = 1;
        }
    }

    MyWeightedQUUF(int N, int initN)
    {
        super(N, initN);
        size = new int[N];
        for (int i = 0; i < N; i += 1)
        {
            size[i] = 1;
        }
    }

    @Override
    public void union(int p, int q)
    {
        int pBoss = id[p];
        int qBoss = id[q];
        if (size[p] < size[q])
        {
            id[pBoss] = qBoss;
            size[qBoss] += size[pBoss];
        }
        else
        {
            id[qBoss] = pBoss;
            size[pBoss] += size[qBoss];
        }
    }

    public boolean onlyOneUnion()
    {
        int firstRoot = findRoot(id[0]);
        for (int i = 1; i < id.length; i += 1)
        {
            if (firstRoot != findRoot(i))
            {
                return false;
            }
        }
        return true;
    }
}
