import java.util.Scanner;

public class Text1 implements Cloneable
{
    int p;
    int o;

    Text1(int l)
    {
        p = l + 1;
        o = l + 2;
    }
    private static int substring(String s)
    {
        int n = s.length();
        StringBuilder oneZero = new StringBuilder();
        int start = 1;
        for (int i = 0; i < n; i += 1)
        {
            oneZero.append(start);
            start = 1 - start;
        }
        StringBuilder zeroOne = new StringBuilder();
        start = 0;
        for (int i = 0; i < n; i += 1)
        {
            zeroOne.append(start);
            start = 1 - start;
        }
        return Math.max(longestSubstring(zeroOne.toString(), s), longestSubstring(oneZero.toString(), s));
    }

    private static int longestSubstring(String s1, String s2)
    {
        String target;
        int n = s1.length();
        for (int i = n; i >= 1; i--)
        {
            for (int j = 0; j <= n - i; j++)
            {
                target = s2.substring(j, j + i);

                for (int k = 0; k <= s1.length() - i; k++)
                {
                    if (s1.substring(k,k + i).equals(target))
                    {
                        return i;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args)
    {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        int res = substring(s);
//        System.out.println(res);
        Text1 x = new Text1(5);
        try
        {
            Text1 y  = (Text1) x.clone();
            System.out.println(x.o);
            System.out.println(y.o);
        }catch (CloneNotSupportedException e){}


    }
}
