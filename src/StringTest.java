import java.io.File;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by 51694 on 2017/7/22.
 */
public class StringTest
{
    public static void main(String[] args) throws Exception
    {
        String path = "./testfile.txt";
        File f = new File(path);
        Scanner input = new Scanner(f);
        StringBuffer s = new StringBuffer();
        input.useDelimiter(";");
        while (input.hasNext())
        {
            s.append(input.next());
        }
        System.out.println(s);
        Stack x = new Stack();
    }
}
