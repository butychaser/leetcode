package three.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSumSolution
{
    public static void main (String[] args)
    {
        List<Integer> inputList = Arrays.asList(-2, -1, 0, 1, 2, 3, 4, 5, 6);
        System.out.println(calculate3Sum(inputList, 0));

    }

    public static List<List<Integer>> calculate3Sum (List<Integer> input, int target)
    {
        List<List<Integer>> results = new ArrayList<>();

        Collections.sort(input); //sort integers first
        int begin = 0, last = input.size() - 1; //retain a place for k 

        for (int i = begin; i < last; ++i)
        {

            int j = i + 1; // the second index will the next to first
            int k = last; // the third index will be the last.

            if (i < last && input.get(i) == input.get(i + 1)) // skip the same integer  
                continue;

            while (j < k) //both(j,k) approach pussy
            {
                if (input.get(i) + input.get(j) + input.get(k) < target) //less then increase j forward to pussy
                {
                    ++j;
                    while (j < k && input.get(j) == input.get(j + 1))
                        // skip the same integer
                        ++j;
                }
                else if (input.get(i) + input.get(j) + input.get(k) > target) //more then k backward pussy
                {
                    --k;
                    while (j < k && input.get(k) == input.get(k - 1))
                        // skip the same integer
                        --k;
                }
                else
                {
                    results.add(Arrays.asList(input.get(i), input.get(j), input.get(k))); //meet then add to resultList
                    ++j; //both(j,k) approach 
                    --k;
                    while (j < k && input.get(j) == input.get(j + 1) // skip the same integer
                        && input.get(k) == input.get(k - 1))
                        // skip the same integer
                        ++j; //then j approach to pussy
                }
            }
        }
        return results;
    }
}
