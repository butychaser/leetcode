package water.trap;

public class WaterTrapSolution
{

    public static void main (String[] args)
    {
        int[] inputs = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(calculateTrappedWater(inputs));

    }

    //[0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3]   Math.min(left_max,
    //[3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1, 0]            right_max)
    //[0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]  -height
    //-------------------------------------------------------------------
    //[0, 0, 1, 0, 1, 2, 1, 0, 0, 1, 0, 0]  =trapped_water

    public static int calculateTrappedWater (int... blocks)
    {
        int n = blocks.length;
        int[] left_max = new int[n];
        int[] right_max = new int[n];
        for (int i = 1; i < n; ++i)
        {
            left_max[i] = Math.max(left_max[i - 1], blocks[i - 1]);
            right_max[n - 1 - i] = Math.max(right_max[n - i], blocks[n - i]);
        }

        int sum = 0;
        for (int i = 0; i < n; ++i)
        {
            if (blocks[i] < Math.min(left_max[i], right_max[i]))
                sum += Math.min(left_max[i], right_max[i]) - blocks[i];
        }
        return sum;
    }
}
