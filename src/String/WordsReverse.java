package String;

/**
 * Created by 51694 on 2017/7/26.
 */
public class WordsReverse
{
    public static String wordsReverse(String s)
    {
        String[] w = s.split(" ");
        int i = 0;
        int j = w.length - 1;
        while (i < j)
        {
            String temp = w[i];
            w[i] = w[j];
            w[j] = temp;
            i += 1;
            j -= 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < w.length; k += 1)
        {
            sb.append(w[k]);
            if (k != w.length - 1)
                sb.append(" ");
        }
        return sb.toString();
    }

    public static String wordsReverse2(String s)
    {
        char[] alphas = s.toCharArray();
        reverse(alphas, 0, alphas.length - 1);
        int wordStart = 0;
        int wordEnd;
        for (int i = 0; i < alphas.length; i += 1)
        {
            if (alphas[i] == ' '|| i == alphas.length - 1)
            {
                wordEnd = i - 1;
                reverse(alphas, wordStart, wordEnd);
                wordStart = i + 1;
            }
        }
        return new String(alphas);
    }

    private static void reverse(char[] s, int start, int end)
    {
        while (start < end)
        {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start += 1;
            end -= 1;
        }
    }


    public static void main(String[] args)
    {
        String sentence = "I love the dog so much";
        System.out.println(wordsReverse(sentence));
        System.out.println(wordsReverse2(sentence));
    }
}
