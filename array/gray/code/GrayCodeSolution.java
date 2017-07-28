package gray.code;

import java.util.ArrayList;
import java.util.List;

public class GrayCodeSolution
{

    public static void main (String[] args)
    {
        System.out.println(calculateGrayCodeSequence(3));
        //[0, 1, 3, 2, 6, 7, 5, 4]
    }

    private static List<Integer> calculateGrayCodeSequence (int n)
    {
        List<Integer> result = new ArrayList<>();
        result.add(0); //add initial 0 as the very starter        
        for (int i = 0; i < n; ++i)
        {
            int hightest_bit = 1 << i; //cal highest bit for '|' operator for currect cycle.
            for (int j = result.size() - 1; j >= 0; j--) //reverse the order of
            { //the previous result. 
                result.add(hightest_bit | result.get(j));
            }
        }
        return result;
    }
}
