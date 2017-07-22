package DP;

import java.util.Scanner;

/**
 * Created by 51694 on 2017/7/20.
 */
public class TwoCpuProblem
{
    /** 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。
     * n个任务可以按照任意顺序放入CPU进行处理，现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。
     * 输入例子： 5
     *            3072 3072 7168 3072 1024
     * 输出例子： 9216
     * */

    private static int bestTime(int[] missions, int max)
    {
        int capacity = max / 2;
        int[] dp = new int[capacity + 1];
        for (int i = 1; i < missions.length + 1; i += 1)
        {
            for (int j = capacity; j >= 1; j -= 1)
                if (missions[i - 1] <= j)
                    dp[j] = Math.max(dp[j], dp[j - missions[i - 1]] + missions[i - 1]);
        }
        return Math.max(dp[capacity], max - dp[capacity]) * 1024;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            int n = sc.nextInt();
            int[] missions = new int[n];
            int maxTime = 0;
            for (int i = 0; i < n; i += 1)
            {
                missions[i] = sc.nextInt() / 1024;
                maxTime += missions[i];
            }
            int result = bestTime(missions, maxTime);
            System.out.println(result);
        }
    }
}
