package week4.SymbolTable;

import javafx.beans.binding.ObjectExpression;

/**
 * Created by 51694 on 2017/4/6.
 */
public class MyDate implements Comparable<MyDate>
{
    private final int month;
    private final int day;
    private final int year;

    public MyDate(int m, int d, int y)
    {
        month = m;
        day = d;
        year = y;
    }

    public boolean equals(Object other)
    {
        if (this == other)
        {
            return true;
        }
        if (other == null)
        {
            return false;
        }
        if (this.getClass() != other.getClass())
        {
            return false;
        }
        return (month == other.month) && (day == other.day) && (year == other.year);
    }

    public int compareTo(MyDate other)
    {
        if (year > other.year)
        {
            return 1;
        }
        else if (year < other.year)
        {
            return  -1;
        }
        else
        {
            if (month > other.month)
            {
                return 1;
            }
            else if (month < other.month)
            {
                return -1;
            }
            else
            {
                if (day > other.day)
                {
                    return 1;
                }
                else if (day < other.day)
                {
                    return  -1;
                }
                else
                {
                    return 0;
                }
            }
        }
    }
}
