package Graph.UndirectedGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 51694 on 2017/4/26.
 */
public class ConnectedComponents
{
    private boolean[] marked;
    private int[] id;
    private int[] size;
    private int len;
    private int componentId;

    public ConnectedComponents(Graph g)
    {
        len = g.V();
        marked = new boolean[len];
        id = new int[len];
        size = new int[len];
        for(int v = 0; v < len; v += 1)
        {
            if (!marked[v])
            {
                dfs(g, v);
                componentId += 1;
            }
        }
    }

    private void validateVertex(int v)
    {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    private void dfs(Graph g, int v)
    {
        marked[v] = true;
        size[componentId] += 1;
        id[v] = componentId;
        for(int w: g.adj(v))
        {
            if (!marked[w])
            {
                dfs(g, w);
            }
        }
    }

    public boolean areConnected(int v, int w)
    {
        validateVertex(v);
        validateVertex(w);
        return id[v] == id[w];
    }

    /** number of connected components */
    public int count()
    {
        return componentId;
    }

    /** which cc dose v belong */
    public int id(int v)
    {
        validateVertex(v);
        return id[v];
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append(count() + " components" + "\n");
        List<Integer>[] components = (ArrayList<Integer>[]) new ArrayList[count()];
        for (int i = 0; i < count(); i += 1)
        {
            components[i] = new ArrayList<>();
        }
        for (int v = 0; v < len; v += 1)
        {
            components[id(v)].add(v);
        }
        for (int i = 0; i < count(); i += 1)
        {
            for (int v: components[i])
            {
                s.append(v + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
