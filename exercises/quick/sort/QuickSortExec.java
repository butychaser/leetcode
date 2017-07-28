package quick.sort;

public class QuickSortExec
{

    public static void main (String[] args)
    {
        int[] inputData = {5, 4, 3, 2, 1};
        int length = inputData.length;
        quick(0, length - 1, inputData);
        for (int i : inputData)
        {
            System.out.println(i);
        }

    }

    private static void quick (int start, int end, int... inputArray)
    {
        if (start == end)
            return;
        int index = sort(start, end, inputArray);
        if (start < index)
            quick(start, index - 1, inputArray);
        if (index < end)
            quick(index + 1, end, inputArray);
    }

    private static int sort (int start, int end, int... inputArray)
    {
        int offset = start - 1;
        for (int idx = start; idx < end; ++idx)
        {
            if (inputArray[idx] < inputArray[end])
            {
                ++offset;
                if (idx != offset)
                {
                    int inter = inputArray[idx];
                    inputArray[idx] = inputArray[end];
                    inputArray[end] = inter;
                }
            }
        }
        ++offset;
        {
            int inter = inputArray[offset];
            inputArray[offset] = inputArray[end];
            inputArray[end] = inter;
        }
        return offset;

    }

}
