package Sort.SortQuestions;

import java.util.Scanner;

/**
 * Created by 51694 on 2017/7/28.
 */
public class CheckDuplicate
{
    public static boolean check(int[] A)
    {
        int[] sortedA = SortExercise.heap(A);
        int last = sortedA[0];
        for (int i = 1; i < A.length; i += 1)
        {
            if (last == A[i])
                return true;
            last = A[i];
        }
        return false;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i += 1)
        {
            A[i] = sc.nextInt();
        }
        boolean res = check(A);
        System.out.println(res);
    }
}
