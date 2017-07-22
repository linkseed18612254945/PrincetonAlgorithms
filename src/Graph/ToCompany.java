package Graph;

import java.util.Scanner;

/**
 * Created by 51694 on 2017/7/20.
 */
public class ToCompany
{
    private static int bestTime(int[] tx, int[] ty, int gx, int gy, int wt, int tt)
    {
        int walkTotalTime = (Math.abs(gx) +Math.abs(gy)) * wt;
        int[] taxiTotalTimes = new int[tx.length];
        int minTime = walkTotalTime;
        for (int i = 0; i < tx.length; i += 1)
        {
            int taxiTotalTime = (Math.abs(tx[i]) + Math.abs(ty[i])) * wt +
                    (Math.abs(gx - tx[i]) + Math.abs(gy - ty[i])) * tt;
            if (taxiTotalTime < minTime)
                minTime = taxiTotalTime;
        }
        return minTime;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            // 参数数据读入
            int taxiStationNumber = sc.nextInt();
            int[] taxiStationX = new int[taxiStationNumber];
            int[] taxiStationY = new int[taxiStationNumber];
            for (int i = 0; i < taxiStationNumber; i += 1)
                taxiStationX[i] = sc.nextInt();
            for (int i = 0; i < taxiStationNumber; i += 1)
                taxiStationY[i] = sc.nextInt();
            int gx = sc.nextInt();
            int gy = sc.nextInt();
            int walkTime = sc.nextInt();
            int taxiTime = sc.nextInt();

            int res = bestTime(taxiStationX, taxiStationY, gx, gy, walkTime, taxiTime);
            System.out.println(res);
        }
    }
}
