package color.sort;

import java.util.Arrays;
import java.util.List;

public class ColorSortApp
{

    public static void main (String[] args)
    {
        Integer[] inputArray = {2, 2, 2, 2, 2, 2, 2, 0, 0, 0};
        List<Integer> result = Arrays.asList(sort(inputArray));
        System.out.println(result);

    }

    public static Integer[] sort (Integer... data)
    {
        int red = 0, blue = data.length - 1;
        
        for (int i = 0; i < blue + 1; ) //disable auto-increase.
        {
            if(data[i] == 0)
            {
                int tmp = data[i];
                data[i] = data[red];
                data[red] = tmp;
                red++;
                ++i;
            }
            else if (data[i] == 2)
            {
                int tmp = data[i];
                data[i] = data[blue];
                data[blue] = tmp;
                blue--;                //dont increase the index as blue index move backward.
            }
            else
                ++i;
        }
        return data;
    }

}
