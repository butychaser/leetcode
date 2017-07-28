package trap.water;

public class TrapWater
{

    public static void main (String[] args)
    {
        int[] inputs = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(sum(inputs));
    }

    public static int sum (int... block)
    {
        int sum = 0, length = block.length;
        int[] left_max = new int[length], right_max = new int[length];

        for (int i = 1; i < length; ++i)
        {
            left_max[i] = Math.max(left_max[i - 1], block[i - 1]);
            right_max[length - i - 1] = Math.max(right_max[length - i], block[length - i]);

        }
        for (int i = 0; i < length; ++i)
        {
            sum += Math.min(left_max[i], right_max[i]) - block[i] > 0 ? Math.min(
                left_max[i],
                right_max[i]) - block[i] : 0;
        }


        return sum;
    }

}
