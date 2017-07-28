package grey.code;

import java.util.ArrayList;
import java.util.List;

public class GreyCode
{
    public static List<Integer> result = new ArrayList<>();
    public static void main (String[] args)
    {
        calculate(2);
        System.out.println(result);

    }
    
    public static void calculate (int index)
    {
        result.add(0);
        for (int i = 0; i < index; ++i)
        {
            int bitoprand = 1 << i;
            int length = result.size();
            for (int idx = length - 1; idx >= 0; --idx)
            {
                int inter = result.get(idx);
                result.add(inter | bitoprand);
            }
        }
    }

}
