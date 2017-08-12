package Sort.SortQuestions;

import Sort.Sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 51694 on 2017/7/28.
 */
public class mergeAB
{
    public static int[] merge(int[] A, int[] B, int n, int m)
    {
        int i = n - 1;
        int j = m - 1;
        int k = n + m - 1;
        while (i >= 0 && j >= 0)
        {
            if (A[i] > B[j])
            {
                A[k] = A[i];
                k -= 1;
                i -= 1;
            }
            else
            {
                A[k] = B[j];
                k -= 1;
                j -= 1;
            }
        }

        while (i >= 0)
        {
            A[k] = A[i];
            i -= 1;
            k -= 1;
        }
        while (j >= 0)
        {
            A[k] = B[j];
            j -= 1;
            k -= 1;
        }
        return A;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[100];
        int[] B = new int[m];
        for (int i = 0; i < n; i += 1)
            A[i] = sc.nextInt();
        for (int i = 0; i < m; i += 1)
            B[i] = sc.nextInt();
        int[] res = merge(A, B, n, m);
        System.out.println(Arrays.toString(res));
    }
}
