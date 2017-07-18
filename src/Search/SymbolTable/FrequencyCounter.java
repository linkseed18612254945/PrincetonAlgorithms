package Search.SymbolTable;

import java.util.List;

/**
 * Created by 51694 on 2017/6/27.
 */
public class FrequencyCounter
{
    private OST<String, Integer> counter = new BinarySearchST<>();

    FrequencyCounter(String[] words)
    {
        for (String word: words)
        {
            if (counter.contains(word))
            {
                counter.put(word, counter.get(word) + 1);
            }
            else
            {
                counter.put(word, 1);
            }
        }
    }

    FrequencyCounter(List<String> wordList)
    {
        String[] words = (String[]) wordList.toArray();
        for (String word: words)
        {
            if (counter.contains(word))
            {
                counter.put(word, counter.get(word) + 1);
            }
            else
            {
                counter.put(word, 1);
            }
        }
    }

    public void printCounter()
    {
        counter.print();
    }
}

