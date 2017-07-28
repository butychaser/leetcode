package binary.calculation;

public class OneInAInteger
{

    public static void main (String[] args)
    {
        int testData = 111111111;
        System.out.println(Integer.toBinaryString(testData));
        System.out.println(calHowMany1InAInteger(testData));
    }

    private static int calHowMany1InAInteger(Integer data)
    {
        int result = 0;
        while(data != 0)
        {
            data = data & (data - 1);
            result++;
        }
        return result;
    }
}
