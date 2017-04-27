package Graph.UndirectedGraph;


import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by 51694 on 2017/4/25.
 */
public class BreadFirstPaths implements GraphPath
{
    private final int s;
    private boolean[] marked;
    private int[] edgeTo;

    public BreadFirstPaths(Graph g, int s)
    {
        this.s = s;
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        bfs(g, s);
    }

    private void bfs(Graph g, int s)
    {
        Queue<Integer> fringe = new PriorityQueue<>();
        fringe.add(s);
        marked[s] = true;
        while (!fringe.isEmpty())
        {
            int v = fringe.remove();
            for (int w: g.adj(v))
            {
                if (!marked[w])
                {
                    edgeTo[w] = v;
                    fringe.add(w);
                    marked[w] = true;
                }
            }
        }

    }

    private void validateVertex(int v)
    {
        int V = marked.length;
        if (v < 0 || v >= V)
        {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
        }
    }

    @Override
    public boolean hasPathTo(int v)
    {
        validateVertex(v);
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v)
    {
        validateVertex(v);
        if (!hasPathTo(v))
        {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
        {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
