package week1.unionFind;
import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 51694 on 2017/3/30.
 */
public class SocialNetWork
{
    private MyWeightedQUUF socialUF;
    private Map<String, Integer> userMap;
    private int userId;
    private int completeUnion;

    public SocialNetWork()
    {
        userId = 0;
        completeUnion = -1;
        userMap = new HashMap<>();
    }

    public void addLogFile(String logFile)
    {
        In logIn = new In(logFile);
        String[] lines = logIn.readAllLines();

        for (int i = 0; i < lines.length; i += 1)
        {
            String userA = lines[i].split(" ")[0];
            String userB = lines[i].split(" ")[1];
            if (!userMap.containsKey(userA))
            {
                userMap.put(userA, userId);
                userId += 1;
            }
            if (!userMap.containsKey(userB))
            {
                userMap.put(userB, userId);
                userId += 1;
            }
        }
        buildSocialUnion(lines);

    }

    private void buildSocialUnion(String[] lines)
    {
        socialUF = new MyWeightedQUUF(userMap.size());
        for (int i = 0; i < lines.length; i += 1)
        {
            int pId = userMap.get(lines[i].split(" ")[0]);
            int qId = userMap.get(lines[i].split(" ")[1]);
            socialUF.union(pId, qId);
            if (socialUF.onlyOneUnion())
            {
                completeUnion = i + 1;
                return;
            }
        }
    }

    public int completeNetworkSearch()
    {
        return completeUnion;
    }

}

