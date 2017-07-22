package Sort;

import java.util.Scanner;

/**
 * Created by 51694 on 2017/7/20.
 */
public class InterestSort
{

    private static int bestTimes(Integer[] sequence)
    {
        int totalMoveTimes = 0;
        int removedMin = 1000;
        for (int i = 0; i < sequence.length; i += 1)
        {
            if (sequence[i] > removedMin)
            {
                totalMoveTimes += 1;
                continue;
            }
            for (int j = i + 1; j < sequence.length; j += 1)
            {
                if (sequence[j] < sequence[i])
                {
                    totalMoveTimes += 1;
                    removedMin = Math.min(removedMin, sequence[i]);
                    break;
                }
            }
        }
        return totalMoveTimes;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] sequence = new Integer[n];
        for (int i = 0; i < n; i += 1)
            sequence[i] = sc.nextInt();
        int res = bestTimes(sequence);
        System.out.println(res);
    }
}
