package Graph.UndirectedGraph;


/**
 * Created by 51694 on 2017/4/25.
 */
public interface GraphPath
{
    boolean hasPathTo(int v);
    Iterable pathTo(int v);
}
