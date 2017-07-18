package Search.SymbolTable;

/**
 * Created by 51694 on 2017/6/27.
 */
public class Test
{
    public static void main(String[] args)
    {
        ST<String, Integer> testST1 = new ArrayST<>();
        ST<String, Integer> testST2 = new SequentialSearchST<>();
        OST<String, Integer> testOST1 = new BinarySearchST<>();
        processST(testST1);
        testST1.print();
        System.out.println();

        processST(testST2);
        testST2.print();
        System.out.println();

        processST(testOST1);
        testOST1.print();
        System.out.println();

        String[] words = new String[]{"I", "like", "the", "wood", "and", "the", "wood", "house", "I", "am", "the"};
        FrequencyCounter counter = new FrequencyCounter(words);
        counter.printCounter();

    }

    private static void processST(ST<String, Integer> st)
    {
        st.put("S", 0);
        st.put("E", 6);
        st.put("A", 2);
        st.put("R", 3);
        st.put("C", 4);
        st.put("H", 5);
        st.put("X", 7);
    }
}
