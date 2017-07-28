package three.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSumExercise
{

    public static List<List<Integer>> result = new ArrayList<>();
    public static void main (String[] args)
    {
        List<Integer> inputList = Arrays.asList(-2, -1, 0, 1, 2, 3, 4, 5, 6);
        calculate(inputList, 0);
        System.out.println(result);

    }
    
    public static void calculate (List<Integer> input, int target)
    {
        int first = 0, last = input.size() - 1;
        int i = first, j = first + 1, k = last;
        Collections.sort(input);
        for (i = 0; i < last; ++i)
        {
            j = i + 1;
            k = last;
            while (j < k)
            {
                 if(input.get(i)+input.get(j)+input.get(k) < target)
                 {
                    ++j;
                    while (input.get(j) == input.get(k + 1))
                        ++j;
                 }
                else if (input.get(i) + input.get(j) + input.get(k) > target)
                {
                    --k;
                    while (input.get(k - 1) == input.get(k))
                        --k;
                }
                else
                {
                    result.add(Arrays.asList(input.get(i), input.get(j), input.get(k)));
                    ++j;
                    --k;
                    while (input.get(j) == input.get(k + 1))
                        ++j;
                    while (input.get(k - 1) == input.get(k))
                        --k;
                }
                 
                     
            }
        }

    }

}
