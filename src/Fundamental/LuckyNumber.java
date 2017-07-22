package Fundamental;

import java.util.Scanner;

/**
 * Created by 51694 on 2017/7/22.
 */
public class LuckyNumber
{
    private static int scaleTotal(int a, int scale)
    {
        int total = 0;
        while (a >= 1)
        {
            total += a % scale;
            a = a / scale;
        }
        return total;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int lucks = 0;
        for (int i = 1; i <= n; i += 1)
        {
            if (scaleTotal(i, 2) == scaleTotal(i, 10))
                lucks += 1;
        }
        System.out.println(lucks);
    }

}
