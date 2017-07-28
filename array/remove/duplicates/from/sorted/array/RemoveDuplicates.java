package remove.duplicates.from.sorted.array;

public class RemoveDuplicates
{

    public static void main (String[] args)
    {
        int origin[] = {1, 1, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7};
        int result = removeReplicated(origin);
        for (int i = 0; i < result; i++)
            System.out.print("[" + origin[i] + "]");
        System.out.println("\n the rsult length:" + result);
    }

    public static int removeReplicated (int[] origin)
    {
        if (origin.length == 0)
            return 0;
        int index = 0;
        for (int i = 1; i < origin.length; i++)
        {
            if (origin[index] != origin[i])
                origin[++index] = origin[i];
        }
        return index + 1;
    }
}
