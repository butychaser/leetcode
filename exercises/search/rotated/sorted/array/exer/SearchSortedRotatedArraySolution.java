package search.rotated.sorted.array.exer;

public class SearchSortedRotatedArraySolution
{

    public static void main (String[] args)
    {
        int[] inputArray = {4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(search(9, inputArray));

    }

    private static int search (int target, int... data)
    {
        int first = 0, middle = 0, last = data.length;
        while (first != last)
        {
            if (target == data[middle])
                return middle;

            middle = (first + last) / 2;
            if (data[first] < data[middle])
            {
                if (data[first] <= target && target < data[middle])
                    last = middle;
                else
                    first = middle + 1;

            }
            else
            {
                if (data[middle] < data[last - 1])
                {
                    if (data[middle] < target && target <= data[last - 1])
                        first = middle + 1;
                    else
                        last = middle;
                }
            }

        }
        return -1;
    }

}
