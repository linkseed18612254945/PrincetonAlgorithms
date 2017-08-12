package Sort.SortQuestions;

import java.util.Scanner;

/**
 * Created by 51694 on 2017/7/28.
 */
public class findInSortedMatrix
{
    public static boolean findX(int[][] mat, int n, int m, int x)
    {
        return findXHelper(mat, 0, m - 1, x);
    }

    private static boolean findXHelper(int[][] mat, int i, int j, int x)
    {
        if (i >= mat.length || j < 0)
            return false;
        if (x == mat[i][j])
            return true;
        else if (x > mat[i][j])
            return findXHelper(mat, i + 1, j, x);
        else
            return findXHelper(mat, i, j - 1, x);
    }


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];
        int x = sc.nextInt();
        for (int i = 0; i < n; i += 1)
            for (int j = 0; j < m; j += 1)
                mat[i][j] = sc.nextInt();
        boolean res = findX(mat, n, m, x);
        System.out.println(res);
    }
}
