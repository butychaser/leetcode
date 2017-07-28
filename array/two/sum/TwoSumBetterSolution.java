package two.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumBetterSolution
{

    public static void main (String[] args)
    {
        System.out.println(calculateTwoSum(19, 1, 7, 10, 9));

    }

    private static List<Integer> calculateTwoSum (int target, int... data)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < data.length; ++i)
        {
            if (map.containsKey(data[i]))
            {
                int index = map.get(data[i]);
                int abit = Integer.lowestOneBit(11112);
                int bit = Integer.highestOneBit(11111);
                return Arrays.asList(index + 1, i + 1);

            }
            else
            {
                int expected = target - data[i];
                map.put(expected, i);
            }
        }
        return Arrays.asList(0, 0);
    }

}
