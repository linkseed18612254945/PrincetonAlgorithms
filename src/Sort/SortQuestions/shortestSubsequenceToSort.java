package Sort.SortQuestions;

import java.util.Scanner;

/**
 * Created by 51694 on 2017/7/28.
 */
public class shortestSubsequenceToSort
{
    public static int shortestLength(int[] A)
    {
        return 0;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i += 1)
            A[i] = sc.nextInt();
        int res = shortestLength(A);
        System.out.println(res);

    }
}
