package remove.element;

//Given an array and a value, remove all instances of that of value in place and return the new length.
//The order of elements can be changed. It doesn't matter what you leave beyond the new length.

public class RemoveElementApp
{

    public static void main (String[] args)
    {
        int origin[] = {5, 4, 3, 2, 1};
        //int origin[] = {1, 2, 3, 4, 5};
        //int origin[] = {3, 3, 3, 3, 3};
        //int origin[] = {5, 5, 5, 5, 5};
        int result = RemoveElement(origin, 3);
        for (int i = 0; i <= result; i++)
            System.out.println(origin[i]);
    }

    public static int RemoveElement (int[] origin, int b)
    {
        if (origin.length == 0)
            return 0;

        int i = 0, j = 0;
        for (i = 0; i < origin.length; i++)
        {
            if (origin[i] <= b)
            {
                origin[j++] = origin[i];
            }
        }
        return j - 1;
    }
}