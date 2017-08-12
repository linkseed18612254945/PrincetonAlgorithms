package Sort.SortQuestions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 51694 on 2017/7/28.
 */
public class sortThreeColor
{
    public static int[] threeColor(int[] A)
    {
        int zeroZone = 0;
        int twoZone = A.length - 1;
        int i = 0;
        while (i <= twoZone)
        {
            if (A[i] == 0)
            {
                swap(A, i, zeroZone);
                i += 1;
                zeroZone += 1;
            }
            else if (A[i] == 2)
            {
                swap(A, i, twoZone);
                twoZone -= 1;
            }
            else if (A[i] == 1)
                i += 1;
            else
                throw new IllegalArgumentException();
        }
        return A;
    }

    private static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i += 1)
            A[i] = sc.nextInt();
        int[] res = threeColor(A);
        System.out.println(Arrays.toString(res));
    }
}
