package Graph.UndirectedGraph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 51694 on 2017/4/25.
 */
public class GraphTest
{
    public static void main(String[] args)
    {
        In in = new In("C:\\Users\\51694\\PrincetonAlgorithms\\src\\Graph\\GraphData\\tinyG.txt");
        Graph G = new AdjListGraph(in);
        StdOut.println(G);
        ConnectedComponents cc = new ConnectedComponents(G);
        System.out.println(cc);
    }
}
