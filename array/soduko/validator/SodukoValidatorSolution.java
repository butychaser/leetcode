package soduko.validator;

import java.util.Arrays;

public class SodukoValidatorSolution
{

    public static void main (String[] args)
    {
        boolean[] used = {
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false};
        char[][] grid = {
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'2', '1', '.', '.', '.', '.', '.', '.', '.'},
            {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'7', '.', '.', '.', '.', '.', '1', '.', '.'},
            {'8', '.', '.', '.', '.', '.', '.', '.', '1'},
            {'9', '.', '.', '.', '.', '.', '.', '.', '.'},};
        arbitrate(used, grid);

    }

    public static boolean arbitrate (boolean[] used, char[][] grid)
    {
        if (grid.length != 9)
            throw new RuntimeException("the grid is not a Sudoku");
        else
        {
            for (int i = 0; i < 9; i++)
                if (grid[i].length != 9)
                    throw new RuntimeException("the grid is not a Sudoku");
        }

        for (int r = 0; r < 9; ++r)
        {
            Arrays.fill(used, false);
            for (int c = 0; c < 9; ++c)
            {
                if (checkAStreak(used, grid[r][c]) == false)
                    throw new RuntimeException("the position of [" + (r + 1) + (c + 1)
                        + "is a violation.");
            }
        }

        for (int c = 0; c < 9; ++c)
        {
            Arrays.fill(used, false);
            for (int r = 0; r < 9; ++r)
            {
                if (checkAStreak(used, grid[r][c]) == false)
                    throw new RuntimeException("the position at [" + (r + 1) + (c + 1)
                        + "] is a violation.");
            }
        }

        for (int rg = 0; rg < 3; ++rg)
        {
            for (int cg = 0; cg < 3; ++cg)
            {
                Arrays.fill(used, false);
                for (int e = 0; e < 9; ++e)
                {
                    int y = rg * 3 + e % 3, x = cg * 3 + Math.abs(e / 3);
                    int z = x + y + grid[x][y];
                    if (checkAStreak(used, grid[x][y]) == false)
                        throw new RuntimeException("the position at [" + (x + 1) + (y + 1)
                            + "] is {" + grid[x][y] + " } is a violation.");
                }
            }
        }

        return false;
    }

    public static boolean checkAStreak (boolean[] used, char e)
    {
        if (e == '.')
            return true;
        int i = Character.getNumericValue(e);
        if (used[i - 1])
            return false;
        else
            used[i - 1] = true;
        return true;

    }
}
