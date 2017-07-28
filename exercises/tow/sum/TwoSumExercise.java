package tow.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumExercise
{

    public static void main (String[] args)
    {
        System.out.println(calculateTwoSum(20, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    }

    private static List<Integer> calculateTwoSum (int target, int... data)
    {
        Map<Integer, Integer> heapMap = new HashMap<>();
        for(int i =0; i< data.length; ++i)
        {
            if(heapMap.containsKey(data[i]))
            {
                return Arrays.asList(heapMap.get(data[i]) + 1, i + 1);
            }
            else
            {
                int remain = target - data[i];
                heapMap.put(remain, i);
            }
        }
        return Arrays.asList(-1, -1);
    }

}
