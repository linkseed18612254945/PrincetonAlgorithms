package Sort.SortQuestions;

import Sort.Sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 51694 on 2017/7/28.
 */
public class ScaleSort
{
    public static int[] scale(int[] A, int k)
    {
        for (int i = A.length - 1; i > 0; i -= 1)
        {
            int lo = i - k;
            if (i - k < 0)
                lo = 0;
            buildMaxHeap(A, lo, i);
            swap(A, lo, i);
        }
        return A;
    }

    private static void buildMaxHeap(int[] A, int lo, int hi)
    {
        int length = hi - lo + 1;
        for (int i = lo + length / 2 - 1; i >= lo; i -= 1)
        {
            adjustHeap(A, i, lo, length);
        }
    }

    private static void adjustHeap(int[] A, int k, int lo, int length)
    {
        if (k > lo + length / 2 - 1)
            return;
        int mc = maxChild(A, k, lo, length);
        if (A[k] >= A[mc])
            return;
        swap(A, k, mc);
        adjustHeap(A, mc, lo, length);
    }

    private static int maxChild(int[] A, int k, int lo, int length)
    {
        int left = (k - lo + 1) * 2 - 1;
        int right = (k - lo + 1) * 2;
        if (right >= length)
            return left + lo;
        return (A[left + lo] > A[right + lo]) ? left + lo: right + lo;
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
        int k = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i += 1)
        {
            A[i] = sc.nextInt();
        }
        int[] res = scale(A, k);
        System.out.println(Arrays.toString(res));
    }
}
