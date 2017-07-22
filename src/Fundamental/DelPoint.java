package Fundamental;

import java.util.Scanner;

/**
 * Created by 51694 on 2017/7/20.
 */
public class DelPoint
{
    // 一个数轴上共有N个点，第一个点的坐标是度度熊现在位置，第N-1个点是度度熊的家。现在他需要依次的从0号坐标走到N-1号坐标。 但是除了0号坐标和N-1号坐标，他可以在其余的N-2个坐标中选出一个点，并直接将这个点忽略掉，问度度熊回家至少走多少距离？

    private static int delReward(Integer[] pos)
    {
        int bestReward = delReward(pos, 1);
        for (int i = 2; i < pos.length - 1; i += 1)
        {
            if (delReward(pos, i) > bestReward)
            {
                bestReward = delReward(pos, i);
            }
        }
        return bestReward;
    }

    private static int delReward(Integer[] arr, int p)
    {
        if (p <= 0 || p >= arr.length) throw new IllegalArgumentException();
        return Math.abs(arr[p + 1] - arr[p]) + Math.abs(arr[p] - arr[p - 1])
                - Math.abs(arr[p + 1] - arr[p - 1]);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] pos = new Integer[n];
        int totalDistance = 0;
        for (int i = 0; i < n; i += 1)
        {
            pos[i] = sc.nextInt();
            if (i > 0)
                totalDistance += Math.abs(pos[i] - pos[i - 1]);
        }

        int reward = delReward(pos);
        System.out.println(totalDistance - reward);
    }
}
