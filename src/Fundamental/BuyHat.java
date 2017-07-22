package Fundamental;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by 51694 on 2017/7/20.
 */
public class BuyHat
{
    //去商场买一顶帽子，商场里有N顶帽子，有些帽子的价格可能相同。度度熊想买一顶价格第三便宜的帽子，问第三便宜的帽子价格是多少？

    private static int thirdPrice(Integer[] price)
    {
        HashSet<Integer> phs = new HashSet<>();
        for (int i = 0; i < price.length; i += 1)
        {
            phs.add(price[i]);
        }
        Integer[] psa = phs.toArray(new Integer[0]);
        if (psa.length < 3)
            return -1;
        Arrays.sort(psa);
        return psa[2];
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] hatPrice = new Integer[n];
        for (int i = 0; i < n; i += 1)
            hatPrice[i] = sc.nextInt();
        int res = thirdPrice(hatPrice);
        System.out.println(res);
    }
}
