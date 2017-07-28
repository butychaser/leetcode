package maximum.continues;

public class MaximumContinues

//13.2 Maximum Subarray
//
//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has
//the largest sum = 6.
{

    public static void main (String[] args)
    {
        int[] inputData = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maximum(inputData));
    }
    private static int maximum (int... inputArray)
    {
        int inter = 0, result = Integer.MIN_VALUE; //pre-set result as negative infinity.

        for (int i = 0; i < inputArray.length; ++i)
        {
            inter = Math.max(inter + inputArray[i], inputArray[i]);//return current value if added up is negative.
            result = Math.max(result, inter); //compare with current maximum result.
        }
        return result;
    }

}
