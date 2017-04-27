package Graph.MST;

/**
 * Created by 51694 on 2017/4/27.
 */
public class Edge implements Comparable<Edge>
{
    private final double weight;
    private final int v;
    private final int w;

    public Edge(int v, int w, double weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight()
    {
        return weight;
    }

    public int either()
    {
        return v;
    }

    public int other(int vertex)
    {
        if (vertex == v)
        {
            return w;
        }
        else if (vertex == w)
        {
            return v;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int compareTo(Edge e)
    {
        return Double.compare(weight(), e.weight());
    }


    public String toString()
    {
        return String.format("%d-%d %.5f", v, w, weight);
    }
}
