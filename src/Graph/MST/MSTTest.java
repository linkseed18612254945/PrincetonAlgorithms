package Graph.MST;

import edu.princeton.cs.algs4.In;

/**
 * Created by 51694 on 2017/4/27.
 */
public class MSTTest
{
    public static void main(String[] args)
    {
        In in = new In("C:\\Users\\51694\\PrincetonAlgorithms\\src\\Graph\\GraphData\\tinyEWG.txt");
        EdgeWeightedGraph wg = new EdgeWeightedGraph(in);
        System.out.println(wg);
    }
}
