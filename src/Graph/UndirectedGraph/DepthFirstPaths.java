package Graph.UndirectedGraph;


import java.util.Stack;

/**
 * Created by 51694 on 2017/4/25.
 */
public class DepthFirstPaths implements GraphPath
{
    private final int s;
    private boolean[] marked;
    private int[] edgeTo;

    public DepthFirstPaths(Graph g, int s)
    {
        this.s = s;
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        dfs(g, s);
    }

    private void dfs(Graph g, int s)
    {
        marked[s] = true;
        for (int w: g.adj(s))
        {
            if (!marked[w])
            {
                edgeTo[w] = s;
                dfs(g, w);
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
