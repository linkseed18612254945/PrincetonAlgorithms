package Graph.MST;

import edu.princeton.cs.algs4.MinPQ;

import java.util.Queue;

/**
 * Created by 51694 on 2017/4/27.
 */
public class LazyPrimMST implements MST
{
    private int weight;
    private Queue<Edge> mst;
    private boolean[] marked;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph wg)
    {

    }

    @Override
    public Iterable<Edge> edges()
    {
        return null;
    }

    @Override
    public double weight()
    {
        return 0;
    }
}
