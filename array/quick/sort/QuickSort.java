package quick.sort;

import java.util.Arrays;
import java.util.List;

public class QuickSort
{

    public static void main (String[] args)
    {
        int[] data = {5, 4, 3, 2, 1};
        List<Integer> _data = Arrays.asList(5, 4, 3, 2, 1);
        quickSort(0, data.length - 1, data); //
        System.out.println(data);
    }

    public static int partition (int start, int end, int... data)
    {
        int small_set = start - 1; //
        for (int idx = start; idx < end; ++idx) // end is the prior one before the end.
        {
            if (data[idx] < data[end])
            {
                ++small_set;
                if (small_set != idx)
                {
                    int inter = data[idx];
                    data[idx] = data[small_set];
                    data[small_set] = inter;
                }

            }
        }
        ++small_set;
        int inter = data[end];
        data[end] = data[small_set];
        data[small_set] = inter;

        return small_set;
    }

    public static void quickSort (int start, int end, int... data)
    {
        System.out.println("===============");
        for (int i = start; i <= end; ++i)
            System.out.print(data[i]);
        System.out.println("\n===============");

        if (start == end)
            return;
        int index = partition(start, end, data);
        if (index > start)
            quickSort(start, index - 1, data);
        if (index < end)
            quickSort(index + 1, end, data);
    }
}
