package DP;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by 51694 on 2017/7/19.
 */
class Item
{
    String name;
    int weight;
    int value;

    public Item(String name, int weight, int value)
    {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }
}

public class Pack01
{
    private HashMap<String, Item> itemsMap;
    private Item[] items;
    private int n;
    private int capacity;

    public Pack01(Item[] items, int capacity)
    {
        this.items = items;
//        for (Item x: items)
//            this.itemsMap.put(x.name, x);
        n = items.length;
        this.capacity = capacity;
    }


    private void best()
    {
        int[][] value = new int[n + 1][capacity + 1];
        for (int i = 0; i < n + 1; i += 1)
            for (int j = 0; j < capacity + 1; j += 1)
                value[i][j] = 0;

        for (int i = 1; i < n + 1; i += 1)
        {
            for (int j = 1; j < capacity + 1; j += 1)
            {
                if (items[i - 1].weight <= j)
                    value[i][j] = Math.max(value[i - 1][j], value[i - 1][j - items[i - 1].weight] + items[i - 1].value);
                else
                    value[i][j] = value[i - 1][j];
            }
        }
        for (int i = 1; i < n + 1; i += 1)
        {
            for (int j = 1; j < capacity + 1; j += 1)
            {
                System.out.print(value[i][j]+"\t");
            }
            System.out.println();
        }


    }

    public static void main(String[] args)
    {
        Item[] items = new Item[] {new Item("b",4, 5),
                                   new Item("c",5, 6),
                                   new Item("a",3, 4),
                                   };
        Pack01 pack = new Pack01(items, 10);
        pack.best();
    }
}


