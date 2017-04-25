package Graph;

/**
 * Created by 51694 on 2017/4/25.
 */

public interface Graph
{
    int V();
    int E();
    Iterable<Integer> adj(int v);
    String toString();
    int degree(int v);
    void addEdge(int v, int w);
}
