package Fundamental.unionFind;

/**
 * Created by 51694 on 2017/7/11.
 */
public interface UnionFind
{
    void connect(int p, int q);
    boolean isConnected(int p, int q);
}
