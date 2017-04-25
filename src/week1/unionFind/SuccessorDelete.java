package week1.unionFind;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 51694 on 2017/3/31.
 */
public class SuccessorDelete
{
    private unionFindSpecific s;
    private int itemNum;

    public SuccessorDelete(int N)
    {
        itemNum = N;
        s = new unionFindSpecific(N);
    }

    public void remove(int x)
    {
        s.id[x] = 1;
    }

    public int findSuccessor(int x)
    {
        if (s.id[x] == 1)
        {
            return s.findSpecific(x);
        }
        return -1;
    }
}
