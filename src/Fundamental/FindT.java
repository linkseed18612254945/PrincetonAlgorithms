package Fundamental;

import java.util.*;

/**
 * Created by 51694 on 2017/7/20.
 */
public class FindT
{
    // 三维空间中有N个点，每个点可能是三种颜色的其中之一，三种颜色分别是红绿蓝，分别用'R', 'G', 'B'表示。现在要找出三个点，并组成一个三角形，使得这个三角形的面积最大。但是三角形必须满足：三个点的颜色要么全部相同，要么全部不同。
    private static double biggestArea(String[] colors, Integer[][] pos, int n)
    {
        double area, maxArea = 0;
        for (int i = 0; i < n;i += 1)
            for (int j = i + 1; j < n; j += 1)
                for (int k = j + 1; k < n; k += 1)
                {
                    Integer[] a = pos[i];
                    Integer[] b = pos[j];
                    Integer[] c = pos[k];
                    if (isNotTriangle(a, b, c))
                        continue;
                    if (isSameColor(colors, i, j, k) || isAllDifferentColor(colors, i, j, k))
                    {
                        area = triangleArea(a, b, c);
                        if (area > maxArea)
                            maxArea = area;
                    }
                }
        return maxArea;
    }

    private static boolean isNotTriangle(Integer[] a, Integer[] b, Integer[] c)
    {
        Integer[] vector1 = new Integer[] {b[0] - a[0], b[1] - a[1], b[2] - a[2]};
        Integer[] vector2 = new Integer[] {c[0] - a[0], c[1] - a[1], c[2] - a[2]};
        return vector1[0] * vector2[1] == vector1[1] * vector2[0] &&
                vector1[1] * vector2[2] == vector1[2] * vector2[1];
    }

    private static boolean isSameColor(String[] colors, int i, int j, int k)
    {
        return colors[i].equals(colors[j]) && colors[i].equals(colors[k]);
    }

    private static boolean isAllDifferentColor(String[] colors, int i, int j, int k)
    {
        return !colors[i].equals(colors[j]) && !colors[i].equals(colors[k]) && !colors[j].equals(colors[k]);
    }

    private static double triangleArea(Integer[] a, Integer[] b, Integer[] c)
    {
        double al = len(a, b);
        double bl = len(a, c);
        double cl = len(b, c);
        double p = (al + bl + cl) / 2;
        return Math.sqrt(p * (p - al) * (p - bl) * (p - cl));
    }

    private static double len(Integer[] a, Integer[] b)
    {
        double l = 0;
        for (int i = 0; i < a.length; i += 1)
            l += (b[i] - a[i]) * (b[i] - a[i]);
        return Math.sqrt(l);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] colors = new String[n];
        Integer[][] pos = new Integer[n][3];
        for (int i = 0; i < n; i += 1)
        {
            colors[i] = sc.next();
            for (int j = 0; j < 3; j += 1)
                pos[i][j] = sc.nextInt();
        }
        double res = biggestArea(colors, pos, n);
        System.out.println(String.format("%.5f",res));
    }
}
