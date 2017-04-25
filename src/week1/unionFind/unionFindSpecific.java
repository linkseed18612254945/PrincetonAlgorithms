package week1.unionFind;

import java.lang.reflect.Method;

/**
 * Created by 51694 on 2017/3/31.
 */
public class unionFindSpecific extends MyWeightedQUUF
{
    public unionFindSpecific(int N)
    {
        super(N, 0);
    }

    /** Order of growth: N * logN */
    public int findSpecific(int a)
    {
        int specific = Integer.MAX_VALUE;
        for (int i = 0; i < id.length; i += 1)
        {
            if (id[i] == 0 && i < specific && i > a)
            {
                specific = i;
            }
        }
        return specific;
    }
}
