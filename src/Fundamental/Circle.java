package Fundamental;

import java.util.Scanner;

/**
 * Created by 51694 on 2017/7/21.
 */
public class Circle
{
    // 战争游戏的至关重要环节就要到来了，这次的结果将决定王国的生死存亡，小B负责首都的防卫工作。首都位于一个四面环山的盆地中，周围的n个小山构成一个环，作为预警措施，小B计划在每个小山上设置一个观察哨，日夜不停的瞭望周围发生的情况。 一旦发生外地入侵事件，山顶上的岗哨将点燃烽烟，若两个岗哨所在的山峰之间没有更高的山峰遮挡且两者之间有相连通路，则岗哨可以观察到另一个山峰上的烽烟是否点燃。由于小山处于环上，任意两个小山之间存在两个不同的连接通路。满足上述不遮挡的条件下，一座山峰上岗哨点燃的烽烟至少可以通过一条通路被另一端观察到。对于任意相邻的岗哨，一端的岗哨一定可以发现一端点燃的烽烟。 小B设计的这种保卫方案的一个重要特性是能够观测到对方烽烟的岗哨对的数量，她希望你能够帮她解决这个问题。
    private static int seePair(Integer[] mountains)
    {
        int pair = 0;
        for (int i = 0; i <mountains.length; i += 1)
            for (int j = i + 1; j < mountains.length; j += 1)
                if (canSee(mountains, i, j))
                    pair += 1;
        return pair;
    }

    private static boolean canSee(Integer[] mountains, int a, int b)
    {
        boolean pathOne = true, pathTwo = true;
        int i = a;
        while (rightNext(mountains.length, i) != b)
        {
            i = rightNext(mountains.length, i);
            if (mountains[i] > Math.min(mountains[a], mountains[b]))
            {
                pathOne = false;
                break;
            }
        }
        i = a;
        while (leftNext(mountains.length, i) != b)
        {
            i = leftNext(mountains.length, i);
            if (mountains[i] > Math.min(mountains[a], mountains[b]))
            {
                pathTwo = false;
                break;
            }
        }
        return pathOne || pathTwo;
    }

    private static int rightNext(int n, int i)
    {
        return (i + 1) % n;
    }

    private static int leftNext(int n, int i)
    {
        if (i == 0)
            return n - 1;
        return i - 1;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] mountains = new Integer[n];
        for (int i = 0; i < n; i += 1)
            mountains[i] = sc.nextInt();
        int res = seePair(mountains);
        System.out.println(res);
    }
}
