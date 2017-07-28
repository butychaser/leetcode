package minimum.gap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Given an array S of n integers, find three integers in S such that the sum is closest to a given number,
//target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//For example, given array S = {-1 2 1 -4}, and target = 1.
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
public class NearestGapSolution
{

    public static void main (String[] args)
    {
        List<Integer> input = Arrays.asList(1, 2, -1, 4, 1);
        System.out.println(calculateNearestGap(input, 2));

    }

    public static List<Integer> calculateNearestGap (List<Integer> input, int target)
    {
        List<Integer> result = new ArrayList<>();
        Collections.sort(input);
        int begin = 0, last = input.size() - 1, min_gap = 0;

        for (int i = begin; i < last - 1; ++i)
        {
            int j = i + 1, k = last;
            while (j < k)
            {
                int sum = input.get(i) + input.get(k) + input.get(j);
                int gap = Math.abs(sum - target);
                if (min_gap == 0 || gap < min_gap)
                {
                    min_gap = gap;
                    result = Arrays.asList(input.get(i), input.get(k), input.get(j));
                }

                if (sum < target)
                    ++j;
                else
                    --k;
            }
        }

        return result;
    }
}
