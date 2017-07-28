package candy;

import java.util.Arrays;
import java.util.List;

public class CandySolution
{

    public static void main (String[] args)
    {
        Integer[] rating = {1, 3, 5, 4};
        Integer[] result = calTotalCandies(rating);
        List<Integer> resultList = Arrays.asList(result);
        System.out.println(resultList);
    }

    private static Integer[] calTotalCandies (Integer... rating)
    {
        int num = rating.length;
        Integer[] children = new Integer[num];
        Arrays.fill(children, 1);

        for (int i = 1, inc = 2; i < num; i++)
        {
            if (rating[i] > rating[i - 1])
                children[i] = (children[i - 1] + 1);
            
        }

        List<Integer> resultList = Arrays.asList(children);
        System.out.println(resultList);

        for (int i = num - 2, inc = 2; i >= 0; i--)
        {
            if (rating[i] > rating[i + 1])
                children[i] = Math.max(children[i], (children[i + 1] + 1));
        }
        return children;

    }

}
