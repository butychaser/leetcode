package window.sum;

import java.util.Arrays;
import java.util.List;

public class WindowSumApp
{

    public static void main (String[] args)
    {
        List<Integer> result = Arrays.asList(sum(5, new Integer[] {4, 2, 73, 11, -5}));
        System.out.println(result);
    }

    public static Integer[] sum (int window, Integer... data)
    {
        if (data.length == 0 || data.length - window < 0)
            return new Integer[] {0};

        Integer[] result = new Integer[data.length - window + 1];
        Integer prior = 0;
        result[0] = 0;
        for (int j = 0; j < window; ++j)
            result[0] += data[j];
        prior = data[0];
        for (int i = 1; i < data.length - window + 1; ++i)
        {
            result[i] = result[i - 1] + data[window + i - 1] - prior;
            prior = data[i];
        }
        return result;
    }

}
