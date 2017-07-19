package Search.Haffman;

/**
 * Created by 51694 on 2017/7/19.
 */
public class HaffmanTree<T>
{
    private Node<T>[] nodes;
    private int n;


    public HaffmanTree(Node<T>[]  nodes)
    {
        this.nodes = nodes;
        n = nodes.length;
    }

    /** 创建哈夫曼树结构 */
    public void buildTree()
    {

    }

    /** 找到权重最小的两个节点 */
    private int[] minTwoNodeIndex(Node<T>[]  nodes)
    {
        int[] minTwo = new int[]{0, 0};
        for (int i = 1; i <= nodes.length; i += 1)
        {
            if (nodes[i].getWeight() < nodes[minTwo[0]].getWeight())
            {
                minTwo[0] = i;
                minTwo[1] = minTwo[0];
            }
            else if (nodes[i].getWeight() >= nodes[minTwo[0]].getWeight()
                     && nodes[i].getWeight() < nodes[minTwo[1]].getWeight())
            {
                minTwo[1] = i;
            }
        }
        return minTwo;
    }

}
class Node<T>
{
    private T data;
    private int weight;
    private Node left;
    private Node right;

    Node(T data, int weight, Node left, Node right)
    {
        this.data = data;
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

}
