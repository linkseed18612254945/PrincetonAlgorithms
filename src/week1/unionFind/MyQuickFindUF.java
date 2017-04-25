package week1.unionFind;

/**
 * Created by 51694 on 2017/3/29.
 */
public class MyQuickFindUF implements UF
{
    private int[] id;
    private int itemNum;
    MyQuickFindUF(int N)
    {
        itemNum = N;
        id = new int[itemNum];
        for (int i = 0; i < itemNum; i += 1)
        {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q)
    {
        int oldBoss = id[p];
        int newBoss = id[q];
        if (oldBoss != newBoss)
        {
            for (int i = 0; i < itemNum; i += 1)
            {
                if (id[i] == oldBoss)
                {
                    id[i] = newBoss;
                }
            }
        }

    }

    @Override
    public boolean isUnion(int p, int q)
    {
        return id[p] == id[q];
    }
}
