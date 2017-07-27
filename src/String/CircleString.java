package String;

import Search.SymbolTable.ST;

/**
 * Created by 51694 on 2017/7/26.
 */
public class CircleString
{

    public static boolean isCircleString(String s1, String s2)
    {
        // 1234 -- 2341 3412 4123
        // s in 12341234?
        if (s1.length() != s2.length())
            return false;
        String s = s1 + s1;
        for (int i = 0; i < s1.length(); i += 1)
        {
            if (s.substring(i, i + s2.length()).equals(s2))
                return true;
        }
        return false;
    }

    public static String circleStringLeft(String s, int i)
    {
        // s="ABCDE", i=2  ==> "DEABC" ss = "BCDEABCDE"
        String ss = s.substring(1).concat(s);
        if (i > s.length() - 1)
            throw new IllegalArgumentException();
        return ss.substring(i, i + s.length());
    }


    public static void main(String[] args)
    {
        String s1 = "abcd";
        String s2 = "cdba";
        // System.out.println(isCircleString(s1, s2));
        String s = "ABCDE";
        System.out.println(circleStringLeft(s, 3));
    }
}
