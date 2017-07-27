package String;

/**
 * Created by 51694 on 2017/7/26.
 */
public class StringLinkOrder
{
    public static String minStringLink(String[] s)
    {
        quickSort(s, 0, s.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String x: s)
            sb.append(x);
        return sb.toString();
    }

    private static void quickSort(String[] s, int lo, int hi)
    {
        if (lo >= hi)
            return;
        int m = partition(s, lo, hi);
        quickSort(s, lo, m - 1);
        quickSort(s, m + 1, hi);
    }

    private static int partition(String[] s,int lo, int hi)
    {
        String mid = s[lo];
        int part = lo;
        while (lo < hi)
        {
            if ((mid + s[hi]).compareTo(s[hi] + mid) <= 0)
            {
                hi -= 1;
                continue;
            }
            if ((mid + s[lo]).compareTo(s[lo] + mid) >= 0)
            {
                lo += 1;
                continue;
            }
            exchange(s, lo, hi);
        }
        exchange(s, part, hi);
        return hi;
    }

    private static void exchange(String[] s, int left, int right)
    {
        String temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }

    public static void main(String[] args)
    {
        String[] s = {"ba", "b", "cad"};
        System.out.println(minStringLink(s));
    }

}
