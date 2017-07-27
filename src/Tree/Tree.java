package Tree;

/**
 * Created by 51694 on 2017/7/24.
 */
public class Tree<Item>
{
    Tree[] branches;
    Item item;

    Tree()
    {
    }
    public Tree(Item item, Tree[] branches)
    {
        this.branches = branches;
        this.item = item;
    }

    private boolean isLeaf()
    {
        return branches.length == 0;
    }

}
