package week1.unionFind;

/**
 * Created by 51694 on 2017/3/30.
 */
public class MyWQUPC extends MyWeightedQUUF implements UF
{
    MyWQUPC(int N)
    {
        super(N);
    }

    @Override
    public int findRoot(int p)
    {
        while(id[p] == p)
        {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

}
