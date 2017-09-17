package Sort.SortQuestions;

import Sort.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by 51694 on 2017/7/27.
 */
public class SortExercise
{
    public static int[] bubble(int[] A)
    {
        /*for (int i = arr.length; i > 1; i -= 1)
            for (int j = 0; j < i - 1; j += 1)
                if (arr[j + 1] < arr[j])
                    exchange(arr, j , j + 1);
        return arr;*/
        for (int i = 0; i < A.length - 1; i += 1)
            for (int j = A.length - 1; j > i; j -= 1)
                if (A[j] < A[j - 1])
                    exchange(A, j, j - 1);
        return A;
    }

    public static int[] select(int[] A)
    {
        for (int i = 0; i < A.length; i += 1)
        {
            int min = i;
            for (int j = i; j < A.length; j += 1)
            {
                if (A[j] < A[min])
                    min = j;
            }
            exchange(A, i, min);
        }
        return A;
    }

    public static int[] insert(int[] A)
    {
        if (A == null || A.length < 2)
            return A;
        for (int i = 1; i < A.length; i += 1)
        {
            int insertItem = A[i];
            int insertIndex = i;
            while (insertIndex > 0 && A[insertIndex - 1] > insertItem)
            {
                A[insertIndex] = A[insertIndex - 1];
                insertIndex -= 1;
            }
            A[insertIndex] = insertItem;
        }
        return A;
    }

    public static int[] merge(int[] A)
    {
        int[] tempA = new int[A.length];
        merge(A, tempA, 0, A.length - 1);
        return A;
    }

    private static void merge(int[] A, int[] tempA, int lo, int hi)
    {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        merge(A, tempA, lo, mid);
        merge(A, tempA, mid + 1, hi);
        mergeTwo(A, tempA, lo, mid, hi);
    }

    private static void mergeTwo(int[] A, int[] tempA, int lo, int mid, int hi)
    {
        if (A[mid] < A[mid + 1])
            return;
        int i = lo;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= hi)
        {
            if (A[i] < A[j])
            {
                tempA[k] = A[i];
                i += 1;
            }
            else
            {
                tempA[k] = A[j];
                j += 1;
            }
            k += 1;
        }
        while (i <= mid)
        {
            tempA[k] = A[i];
            i += 1;
            k += 1;
        }

        while (j <= hi)
        {
            tempA[k] = A[j];
            j += 1;
            k += 1;
        }
        System.arraycopy(tempA, 0, A, lo, k);
    }

    public static int[] quick(int[] A)
    {
        Random random = new Random();
        quick(A, 0 , A.length - 1, random);
        return A;
    }

    private static void quick(int[] A, int lo, int hi, Random random)
    {
        if (hi - lo <= 1)
            return;
        int sign = random.nextInt(hi - lo + 1) + lo;
        int mid = partition(A, lo, hi, sign);
        quick(A, lo ,mid - 1, random);
        quick(A, mid + 1, hi, random);
    }

    private static int partition(int[] A, int lo, int hi, int sign)
    {
        if (sign < lo || sign > hi)
            throw new IllegalArgumentException();
        int i = lo;
        int j = hi;
        while (i < j)
        {
            if (A[j] >=  A[sign])
            {
                j -= 1;
                continue;
            }
            if (A[i] <=  A[sign])
            {
                i += 1;
                continue;
            }
            exchange(A, i, j);
        }
        int exchangeIndex = j < sign ? (A[j] >= A[sign] ? j: j + 1) : j;
        exchange(A, sign, exchangeIndex);
        return exchangeIndex;
    }

    public static int[] heap(int[] A)
    {
        buildMaxHeap(A);
        for (int i = A.length - 1; i >= 0; i -= 1)
        {
            exchange(A, i ,0);
            heapAdjust(A, 0, i);
        }
        return A;
    }

    private static void buildMaxHeap(int[] A)
    {
        for (int i = A.length / 2 - 1; i >= 0; i -= 1)
            heapAdjust(A,i, A.length);
    }

    private static void heapAdjust(int[] A, int k, int length)
    {
        while (k < length / 2 && k >= 0)
        {
            int mc = maxChild(A, length, k);
            if (A[k] > A[mc])
                return;
            else
            {
                exchange(A, k, mc);
                k = mc;
            }
        }
    }

    private static int maxChild(int[] A, int length, int k)
    {
        int left = (k + 1) * 2 - 1;
        int right = (k + 1) * 2;
        if (right >= length)
            return left;
        return (A[left] > A[right])? left: right;
    }

    public static int[] shell(int[] A)
    {
        int gap = 3;
        for (int i = gap; i >= 1; i -= 1)
        {
            for (int j = i; j < A.length; j += 1)
            {
                int insertIndex = j;
                int insertItem = A[j];
                while (insertIndex >= i && A[insertIndex - i] > insertItem)
                {
                    exchange(A, insertIndex, insertIndex - i);
                    insertIndex -= i;
                }
                A[insertIndex] = insertItem;
            }
        }
        return A;
    }

    public static int[] counting(int[] A)
    {
        int min = A[0];
        int max = A[0];
        for (int i = 1; i < A.length; i += 1)
        {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
        int[] bucket = new int[max - min + 1];
        for (int a: A)
        {
            bucket[a - min] += 1;
        }
        int k = 0;
        for (int i = 0; i < bucket.length; i += 1)
        {
            for (int j = 0; j < bucket[i]; j += 1)
            {
                A[k] = i + min;
                k += 1;
            }
        }
        return A;
    }

    public static int[] radix(int[] A)
    {
        int level = 2;
        ArrayList<Integer>[] bucket = (ArrayList<Integer>[]) new Object[10];
        for (int x = 0; x < level; x+= 1)
        {
            radixWithOne(A, bucket, x);
        }
        return A;
    }

    private static void  radixWithOne(int[] A, ArrayList<Integer>[]bucket, int x)
    {
        for (int i = 0; i < A.length; i += 1)
            bucket[(int) (A[i] / Math.pow(10, x)) % 10].add(A[i]);
        int k = 0;
        for (int i = 0; i < bucket.length; i += 1)
        {
            for (Integer item: bucket[i])
            {
                A[k] = item;
                k += 1;
            }
        }
    }


    private static void exchange(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i += 1)
            arr[i] = sc.nextInt();
        System.out.println(Arrays.toString(arr));
        quick(arr);
        System.out.println(Arrays.toString(arr));
    }

}
