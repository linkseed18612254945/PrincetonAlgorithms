import java.util.Scanner;

public class Text2
{
    private static StringBuilder putReverse(Integer[] a, int n)
    {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < n; i += 1)
        {
            b.append(a[i]);
            b.reverse();
        }
        return b;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i += 1)
            arr[i] = sc.nextInt();
        StringBuilder res = putReverse(arr, n);
        for (int i = 0; i < res.length(); i += 1)
        {
            if (i == res.length() - 1)
                System.out.print(res.charAt(i));
            else
                System.out.print(res.charAt(i) + " ");
        }
    }
}
