package Graph.MST;


import edu.princeton.cs.algs4.In;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by 51694 on 2017/4/27.
 */
public class EdgeWeightedGraph
{
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Set<Edge>[] adj;

    public EdgeWeightedGraph(int V)
    {
        if (V < 0)
        {
            throw new IllegalArgumentException();
        }
        this.V = V;
        this.E = 0;
        adj = (Set<Edge>[]) new HashSet[V];
        for (int v = 0; v < V; v += 1)
        {
            adj[v] = new HashSet<>();
        }
    }

    public EdgeWeightedGraph(In in)
    {
        this(in.readInt());
        int E = in.readInt();
        if (E < 0)
        {
            throw new IllegalArgumentException();
        }
        int v, w;
        double weight;
        for (int i = 0; i < E; i += 1)
        {
            v = in.readInt();
            w = in.readInt();
            validateVertex(v);
            validateVertex(w);
            weight = in.readDouble();
            Edge e = new Edge(v, w ,weight);
            addEdge(e);
        }
    }

    private void validateVertex(int v)
    {
        if (v < 0 || v >= V)
        {
            throw new IllegalArgumentException("Illegal vetex " + v);
        }
    }

    public void addEdge(Edge e)
    {
        int v = e.either();
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        if (!(adj[v].contains(e) && adj[w].contains(e)))
        {
            adj[v].add(e);
            adj[w].add(e);
            E += 1;
        }
    }

    public int V()
    {
        return V;
    }

    public int E()
    {
        return E;
    }

    public Iterable<Edge> adj(int v)
    {
        validateVertex(v);
        return adj[v];
    }

    public int degree(int v)
    {
        return adj[v].size();
    }

    public Iterable<Edge> edges()
    {
        Set<Edge> edgeList = new HashSet<>();
        for (int v = 0; v < V; v += 1)
        {
            for (Edge e: adj(v))
            {
                edgeList.add(e);
            }
        }
        return edgeList;
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v ++)
        {
            s.append(v + ": ");
            for (Edge e: adj(v))
            {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();

    }

}
