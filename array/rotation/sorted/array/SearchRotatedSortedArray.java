package rotation.sorted.array;

public class SearchRotatedSortedArray
{

    public static void main (String[] args)
    {
        int[] inputArray = {4, 5, 6, 7, 8, 1, 2, 3};
        //0, 1, 2, 3, 4, 5, 6, 7  
        int result = search(9, inputArray);
        System.out.println(result);
    }

    public static int search (int target, int... nums)
    {
        int middle = 0, first = 0, last = nums.length; //define last as the array length
                                                       //in order to calculate middle.
        while (first != last)
        {
            middle = (first + last) / 2; //the middle is (first+last)/2 
            if (nums[middle] == target)
                return middle;

            if (nums[first] < nums[middle])
            {
                if (nums[first] <= target && target < nums[middle]) //target equal or less than first
                    last = middle;
                else
                    first = middle + 1; // change first always to middle + 1
            }
            else
            {
                if (nums[middle] < target && target <= nums[last - 1]) //target equal or more as last
                    first = middle + 1; // change first always to middle + 1
                else
                    last = middle;
            }
        }
        return -1;
    }
}
