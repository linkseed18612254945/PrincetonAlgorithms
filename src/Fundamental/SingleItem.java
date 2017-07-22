package Fundamental;

import java.util.*;

/**
 * Created by 51694 on 2017/7/20.
 */
public class SingleItem
{
    // 小易有一个长度为n序列，小易想移除掉里面的重复元素，但是小易想是对于每种元素保留最后出现的那个。
    private static Integer[] repeatRemove(Integer[] sequence)
    {
        class PositionComparator implements Comparator<Integer>
        {
            private Map<Integer, Integer> item;
            private PositionComparator(Map<Integer, Integer> item)
            {
                this.item = item;
            }

            @Override
            public int compare(Integer a, Integer b)
            {
                if (item.get(a) <= item.get(b))
                    return -1;
                else
                    return 1;
            }
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        PositionComparator pc = new PositionComparator(hm);
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(pc);
        for (int i = 0; i < sequence.length; i += 1)
            hm.put(sequence[i], i);
        sortedMap.putAll(hm);
        sequence = sortedMap.keySet().toArray(new Integer[0]);
        return sequence;
    }



    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] sequence = new Integer[n];
        for (int i = 0; i < n; i += 1)
        {
            sequence[i] = sc.nextInt();
        }
        Integer[] res = repeatRemove(sequence);
        for (int i = 0; i < res.length; i += 1)
        {
            if (i == res.length - 1)
                System.out.print(res[i]);
            else
                System.out.print(res[i] + " ");
        }
    }
}
