package Fundamental;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by 51694 on 2017/7/22.
 */
public class setUnion
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i += 1)
            set.add(sc.nextInt());
        for (int i = 0; i < m; i += 1)
            set.add(sc.nextInt());
        Integer[] res = set.toArray(new Integer[0]);
        Arrays.sort(res);
        for (int i = 0; i < res.length; i += 1)
        {
            if (i == res.length - 1)
            {
                System.out.print(res[i]);
                break;
            }
            System.out.print(res[i] + " ");
        }
    }
}
