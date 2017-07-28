package two.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TwoSumSolution
{
    public static List<Integer> calculateTwoSum (int target, int... input)
    {
        Map<Integer, Integer> aMap = new HashMap<>();
        for (int index = 0; index < input.length; index++)
            aMap.put(input[index], index);
        Iterator<Integer> i = aMap.keySet().iterator();
        while (i.hasNext())
        {
            int ren = target - i.next();
            if (ren > 0 && aMap.get(ren) != null)
                return Arrays.asList(aMap.get(target - ren) + 1, aMap.get(ren) + 1);
        }
        return Arrays.asList(0, 0);

    }

    public static void main (String[] args)
    {
        System.out.println(calculateTwoSum(9, 1, 8));

    }
}
