package Graph.UndirectedGraph;

import edu.princeton.cs.algs4.In;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 51694 on 2017/4/25.
 */
public class AdjMatrixGraph implements Graph
{
    private static final String NEWLINE = System.getProperty("line.separator");

    private int V;
    private int E;
    private boolean[][] adj;

    public AdjMatrixGraph(int V)
    {
        this.V = V;
        E = 0;
        adj = new boolean[V][V];
    }

    public AdjMatrixGraph(In in)
    {
        this.V = in.readInt();
        if (V < 0)
        {
            throw new IllegalArgumentException("Number of vertices must be non-negative");
        }
        adj = new boolean[V][V];
        int E = in.readInt();
        this.E = 0;
        if (V < 0)
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
        if (adj[v][w])
        {
            return;
        }
        adj[v][w] = true;
        adj[w][v] = true;
        E += 1;
    }

    @Override
    public Iterable<Integer> adj(int v)
    {
        Set<Integer> adjs = new HashSet<>();
        for (int w = 0; w < V; w += 1)
        {
            if (adj[v][w])
            {
                adjs.add(w);
            }
        }
        return adjs;
    }

    @Override
    public int degree(int v)
    {
        validateVetex(v);
        int degree = 0;
        for (int w: adj(v))
        {
            degree += 1;
        }
        return degree;
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
