package Fundamental;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by 51694 on 2017/7/21.
 */
public class scaleAverage
{

    private static String average(Integer a)
    {
        if (a < 1) throw new IllegalArgumentException();
        if (a ==  1 || a == 2) a = 3;
        int total = 0;
        for (int i = 2; i < a; i += 1)
            total += scaleTotal(a, i);
        return total / gcd(total, a - 2) + "/" + (a - 2) / gcd(total, a - 2);

    }

    private static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

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
        Queue<String> averages = new ArrayDeque<>();
        while (sc.hasNext())
        {
            String res = average(sc.nextInt());
            averages.add(res);
        }
        for (String s : averages)
            System.out.println(s);
    }
}
