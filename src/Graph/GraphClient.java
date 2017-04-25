package Graph;

/**
 * Created by 51694 on 2017/4/24.
 */
public class GraphClient
{
    public static int maxDegree(Graph g)
    {
        int max = 0;
        for (int v = 0; v < g.V(); v += 1)
        {
            if (g.degree(v) > max)
            {
                max = g.degree(v);
            }
        }
        return max;
    }

    public static int avgDegree(Graph g)
    {
        return 2 * g.E() / g.V();
    }

    public static int numberOfSelfLoops(Graph g)
    {
        int count = 0;
        for (int v = 0; v < g.V(); v += 1)
        {
            for (int w: g.adj(v))
            {
                if (w == v)
                {
                    count += 1;
                }
            }
        }
        return count / 2;
    }
}
