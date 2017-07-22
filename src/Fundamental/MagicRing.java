package Fundamental;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 51694 on 2017/7/20.
 */
public class MagicRing
{
    // 小易拥有一个拥有魔力的手环上面有n个数字(构成一个环),当这个魔力手环每次使用魔力的时候就会发生一种奇特的变化：每个数字会变成自己跟后面一个数字的和(最后一个数字的后面一个数字是第一个),一旦某个位置的数字大于等于100就马上对100取模(比如某个位置变为103,就会自动变为3).现在给出这个魔力手环的构成，请你计算出使用k次魔力之后魔力手环的状态。

    private static void use(Integer[] rings)
    {
        Integer first = rings[0];
        int next;
        for (int i = 0; i < rings.length; i += 1)
        {
            if (i == rings.length - 1)
                next = first;
            else
                next = rings[(i + 1) % rings.length];
            rings[i] = (rings[i] + next) % 100;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] rings = new Integer[n];
        int t = sc.nextInt();
        for (int i = 0; i < n; i += 1)
        {
            rings[i] = sc.nextInt();
        }
        for (int i = 0; i < t; i += 1)
        {
            use(rings);
        }
        for (int i = 0; i < rings.length; i += 1)
        {
            if (i == rings.length - 1)
                System.out.print(rings[i]);
            else
                System.out.print(rings[i] + " ");
        }
    }
}
