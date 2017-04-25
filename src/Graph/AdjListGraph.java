package Graph;

import edu.princeton.cs.algs4.In;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 51694 on 2017/4/24.
 */
public class AdjListGraph implements Graph
{
    private static final String NEWLINE = System.getProperty("line.separator");

    private int V;
    private int E;
    private Set<Integer>[] adj;


    public AdjListGraph(int V)
    {
        if (V < 0)
        {
            throw new IllegalArgumentException("Number of vertices must be non-negative");
        }
        this.V = V;
        this.E = 0;
        adj = (Set<Integer>[]) new HashSet[V];
        for (int v = 0; v < V; v += 1)
        {
            adj[v] = new HashSet<>();
        }
    }

    public AdjListGraph(In in)
    {
        V = in.readInt();
        if (V < 0)
        {
            throw new IllegalArgumentException("Number of vertices must be non-negative");
        }
        adj = (Set<Integer>[]) new HashSet[V];
        for (int v = 0; v < V; v += 1)
        {
            adj[v] = new HashSet<>();
        }
        int E = in.readInt();
        this.E = 0;
        if (E < 0)
        {
            throw new IllegalArgumentException("Number of edges must be non-negative");
        }
        for (int e = 0; e < E; e += 1)
        {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }


    private void validateVetex(int v)
    {
        if (v < 0 || v >= V)
        {
            throw new IllegalArgumentException("Illegal vetex " + v);
        }
    }

    @Override
    public int V()
    {
        return V;
    }

    @Override
    public int E()
    {
        return E;
    }

    @Override
    public void addEdge(int v, int w)
    {
        validateVetex(v);
        validateVetex(w);
        if(adj[v].contains(w))
        {
            return;
        }
        adj[v].add(w);
        adj[w].add(v);
        E += 1;
    }

    @Override
    public int degree(int v)
    {
        validateVetex(v);
        return adj[v].size();
    }

    @Override
    public Iterable<Integer> adj(int v)
    {
        validateVetex(v);
        return adj[v];
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v += 1)
        {
            s.append(v + ": ");
            for (int w: adj(v))
            {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
