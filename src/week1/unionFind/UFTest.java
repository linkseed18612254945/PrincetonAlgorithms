package week1.unionFind;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 51694 on 2017/3/29.
 */
public class UFTest
{
    public static void main(String[] args)
    {
        // String logIn = "C:\\Users\\51694\\PrincetonAlgorithms\\src\\week1\\unionFind\\networkLog";
        // SocialNetWork netWork = new SocialNetWork();
        // netWork.addLogFile(logIn);
        // System.out.println(netWork.completeNetworkSearch());

        SuccessorDelete sd = new SuccessorDelete(10);
        sd.remove(6);
        sd.remove(3);
        sd.remove(7);
        sd.remove(4);
        int successor = sd.findSuccessor(3);
        System.out.println(successor);

        Integer a = 1;
    }

}
