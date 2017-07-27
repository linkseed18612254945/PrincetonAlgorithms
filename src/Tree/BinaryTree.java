package Tree;

import java.util.*;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by 51694 on 2017/7/24.
 */
public class BinaryTree
{
    private TreeNode root;
    private StringBuffer sTree;

    private class TreeNode
    {
        private Integer item;
        private TreeNode leftChild;
        private TreeNode rightChild;

        TreeNode(int item)
        {
            this.item = item;
            leftChild = null;
            rightChild = null;
        }

        TreeNode(){}

        boolean isNull()
        {
            return item == null;
        }

        boolean isLeaf()
        {
            return leftChild == null && rightChild == null;
        }
    }

    public BinaryTree()
    {
        root = null;
        sTree = new StringBuffer();
    }

    public void createTree()
    {
        root = new TreeNode(1);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(3);
        root.leftChild.leftChild = new TreeNode(4);
        root.rightChild.leftChild = new TreeNode(5);
        root.rightChild.rightChild = new TreeNode(6);
        root.rightChild.leftChild.leftChild = new TreeNode(7);
        root.rightChild.leftChild.rightChild = new TreeNode(8);
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public int size()
    {
        return size(root);
    }

    private int size(TreeNode n)
    {
        if (n == null)
            return 0;
        if (n.isLeaf())
            return 1;
        return size(n.leftChild) + size(n.rightChild) + 1;
    }

    public int height()
    {
        return height(root);
    }

    private int height(TreeNode n)
    {
        if (n == null)
            return 0;
        if (n.isLeaf())
            return 1;
        return 1 + Math.max(height(n.leftChild), height(n.rightChild));
    }

    public void serializeTreeLevel()
    {
        Deque<TreeNode> nodeDeque = new LinkedBlockingDeque<>();
        nodeDeque.add(root);
        TreeNode node;
        while (!nodeDeque.isEmpty())
        {
            node = nodeDeque.remove();
            serializeNode(node);
            if (node.isNull())
                continue;
            if (node.leftChild != null)
                nodeDeque.add(node.leftChild);
            else
                nodeDeque.add(new TreeNode());
            if (node.rightChild != null)
                nodeDeque.add(node.rightChild);
            else
                nodeDeque.add(new TreeNode());
        }
        System.out.println(sTree);
    }


    private void serializeNode(TreeNode node)
    {
        if (node == null)
            return;
        if (node.isNull())
            sTree.append("#!");
        else
        {
            sTree.append(node.item);
            sTree.append("!");
        }
    }


    private void unSerialize(TreeNode n, String[] ns)
    {

    }


    public void preOrder()
    {
        preOrder(root);
    }

    private void preOrder(TreeNode n)
    {
        if (n == null)
            return;
        visit(n);
        preOrder(n.leftChild);
        preOrder(n.rightChild);
    }

    public void iterPreOrder()
    {
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode node = root;
        while (node != null || !nodeStack.isEmpty())
        {
            while (node != null)
            {
                visit(node);
                nodeStack.push(node);
                node = node.leftChild;
            }
            if (!nodeStack.isEmpty())
            {
                node = nodeStack.pop().rightChild;
            }
        }
    }

    public void inOrder()
    {
        inOrder(root);
    }

    public void iterInOrder()
    {
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode node = root;
        while (node != null || !nodeStack.isEmpty())
        {
            while (node != null)
            {
                nodeStack.push(node);
                node = node.leftChild;
            }
            if (!nodeStack.isEmpty())
            {
                node = nodeStack.pop();
                visit(node);
                node = node.rightChild;
            }
        }
    }

    private void inOrder(TreeNode n)
    {
        if (n == null)
             return;
        inOrder(n.leftChild);
        visit(n);
        inOrder(n.rightChild);
    }

    public void postOrder()
    {
        postOrder(root);
    }

    public void iterPostOrder()
    {
    }

    public void levelOrder()
    {
        Queue<TreeNode> nodeQueue = new LinkedBlockingQueue<>();
        TreeNode node = root;
        nodeQueue.add(node);
        while (!nodeQueue.isEmpty())
        {
            node = nodeQueue.remove();
            visit(node);
            if (node.leftChild != null)
                nodeQueue.add(node.leftChild);
            if (node.rightChild != null)
                nodeQueue.add(node.rightChild);
        }
    }

    public int[][] levelOrderWithLevel()
    {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode node = root;
        TreeNode last = node;
        TreeNode nlast = node;
        int[][] res;
        int level = 0;
        nodeQueue.add(node);
        ArrayList<Integer> ll = new ArrayList<>();
        ArrayList<ArrayList<Integer>> all = new ArrayList<>();
        while (!nodeQueue.isEmpty())
        {
            node = nodeQueue.remove();
            visit(node);
            ll.add(node.item);
            if (node.leftChild != null)
            {
                nodeQueue.add(node.leftChild);
                nlast = node.leftChild;
            }
            if (node.rightChild != null)
            {
                nodeQueue.add(node.rightChild);
                nlast = node.rightChild;
            }
            if (node == last)
            {
                System.out.println();
                last = nlast;
                level += 1;
                all.add(ll);
                ll = new ArrayList<>();
            }
        }
        res = new int[all.size()][];
        for (int i = 0; i < all.size(); i += 1)
        {
            res[i] = new int[all.get(i).size()];
            for (int j = 0; j < all.get(i).size(); j += 1)
                res[i][j] = all.get(i).get(j);
        }
        return res;
    }

    private void postOrder(TreeNode n)
    {
        if (n == null)
            return;
        postOrder(n.leftChild);
        postOrder(n.rightChild);
        visit(n);
    }

    private void visit(TreeNode n)
    {
        System.out.print(n.item + " ");
    }

    public static void main(String[] args)
    {
        BinaryTree t = new BinaryTree();
        t.createTree();
        int[][] x = t.levelOrderWithLevel();
        System.out.println(Arrays.toString(x));
    }
}

