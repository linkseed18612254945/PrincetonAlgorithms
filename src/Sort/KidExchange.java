package Sort;

import java.util.Scanner;

/**
 * Created by 51694 on 2017/7/20.
 */
public class KidExchange
{
    private static int exchangeTimes(char[] arr)
    {
        int sideBIndex;
        int leftBTimes = 0, rightBTimes = 0;
        sideBIndex = 0;
        for (int i = 0; i < arr.length; i += 1)
        {
            if (arr[i] == 'B')
            {
                leftBTimes += i - sideBIndex;
                sideBIndex += 1;
            }
        }
        sideBIndex = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i -= 1)
        {
            if (arr[i] == 'B')
            {
                rightBTimes += sideBIndex - i;
                sideBIndex -= 1;
            }
        }
        return Math.min(leftBTimes, rightBTimes);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        char[] kids = sc.nextLine().toCharArray();
        int res = exchangeTimes(kids);
        System.out.println(res);
    }
}
