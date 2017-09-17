import java.util.*;

public class Text3
{
    private static int maxCrazy(Integer[] a, int n)
    {
        ArrayList<Integer[]> crazyValue = new ArrayList<>();
        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i += 1)
        {
            pos.put(i, 0);
            for (int j = i + 1; j < n; j += 1)
            {
                Integer[] crazy = new Integer[4];
                crazy[0] = Math.abs(a[i] - a[j]);
                crazy[1] = i;
                crazy[2] = j;
                crazy[3] = 0;
                crazyValue.add(crazy);
            }
        }
        int sum = 0;
        for (int i = 0; i < n - 1; i += 1)
        {
            int max = - Integer.MAX_VALUE;
            int maxIndex = -1;
            for (int j = 0; j < crazyValue.size(); j += 1)
            {
                if (crazyValue.get(j)[3] == 0 && crazyValue.get(j)[0] > max &&
                        pos.get(crazyValue.get(j)[1]) < 2 && pos.get(crazyValue.get(j)[2]) < 2)
                {
                    max = crazyValue.get(j)[0];
                    maxIndex = j;
                }
            }
            crazyValue.get(maxIndex)[3] = 1;
            pos.put(crazyValue.get(maxIndex)[1], pos.get(crazyValue.get(maxIndex)[1]) + 1);
            pos.put(crazyValue.get(maxIndex)[2], pos.get(crazyValue.get(maxIndex)[2]) + 1);
            sum += max;
        }
        return sum;
    }


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i += 1)
            arr[i] = sc.nextInt();
        int res = maxCrazy(arr, n);
        System.out.println(res);
    }
}
