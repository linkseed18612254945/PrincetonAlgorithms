package Search.SymbolTable;

/**
 * Created by 51694 on 2017/6/27.
 */
public class GPA
{
    private  static ST<String, Double> GPAST = new SequentialSearchST<>();
    GPA()
    {
        buildDict();
    }
    private void buildDict()
    {
        GPAST.put("A",  4.00);
        GPAST.put("B",  3.00);
        GPAST.put("C",  2.00);
        GPAST.put("D",  1.00);
        GPAST.put("F",  0.00);
        GPAST.put("A+", 4.33);
        GPAST.put("B+", 3.33);
        GPAST.put("C+", 2.33);
        GPAST.put("A-", 3.67);
        GPAST.put("B-", 2.67);
    }

    public void averageGPA(String[] grades)
    {

        int total = 0;
        for (String grade: grades)
        {
            if (!GPAST.contains(grade)) throw new IllegalArgumentException("illegal grade symbol");
            total += GPAST.get(grade);
        }
        System.out.println("GPA = " + total / grades.length);
    }

    public static void main(String[] args)
    {
        String[] grades = new String[]{"A", "B", "A-", "A+", "C", "B-"};
        GPA gpa = new GPA();
        gpa.averageGPA(grades);

    }
}
