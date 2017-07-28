package longest.consecutive;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence is [1,
//2, 3, 4]. Return its length: 4.
//Your algorithm should run in O(n) complexity.

public class LongestConsecutiveSolution
{
    public static List<Integer> inputList = Arrays.asList(1, 2, 3);

    public static void main (String[] args)
    {
        Map<Integer, Integer> _aMap = new HashMap<>();
        Iterator<Integer> i = inputList.iterator();
        while (i.hasNext())
            _aMap.put(i.next(), 0);
        int longest = 0;
        Iterator<Integer> iKey = _aMap.keySet().iterator();
        while (iKey.hasNext())
        {
            int key = iKey.next();

            if (_aMap.get(key) != 0) //always process the integer as intact as degree 0.
                continue;

            int result = calConsecutiveDegree(key, _aMap);
            longest = longest > result ? longest : result;
        }
        System.out.println(longest);
        System.out.println(_aMap);

    }

    public static int calConsecutiveDegree (int i, Map<Integer, Integer> aMap)
    {
        if (!aMap.containsKey(i + 1)) //conquer when the key(i+1) cannot found as a result of no further consecutive.
        {
            aMap.put(i, 1);
            return 1;
        }
        else
        {
            int degree = 1 + calConsecutiveDegree(i + 1, aMap); //else recursive to its consecutive as i+1.  
            aMap.put(i, degree); //and increase degree by 1 and put into the Map.
            return degree;

        }
    }
}
