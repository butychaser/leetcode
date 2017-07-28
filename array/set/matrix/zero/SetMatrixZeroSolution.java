package set.matrix.zero;

public class SetMatrixZeroSolution
{

    public static void main (String[] args)
    {
        char[][] matrix = {
            {'4', '4', '4', '4', '4', '4', '4', '4', '4'},
            {'2', '0', '4', '4', '4', '4', '4', '4', '4'},
            {'3', '4', '4', '4', '4', '4', '4', '4', '4'},
            {'4', '4', '4', '4', '4', '4', '4', '4', '4'},
            {'5', '4', '4', '4', '4', '4', '4', '4', '4'},
            {'6', '4', '4', '4', '4', '4', '4', '4', '4'},
            {'7', '4', '4', '4', '4', '4', '0', '4', '4'},
            {'8', '4', '4', '4', '4', '4', '4', '4', '0'},
            {'9', '4', '4', '4', '4', '4', '4', '4', '4'},};
        
        setZero(matrix);
        displayMatrix(matrix);
    }

    private static void setZero (char[][] data)
    {
        boolean row_zero = false, col_zero = false;
        int nrow = data.length, ncol = data[0].length;
        
        for (int j = 0; j < ncol; ++j)
        {
            if (Character.getNumericValue(data[0][j]) == 0)
            {
                row_zero = true;
                break;
            }
        }
            
        for (int i = 0; i < nrow; ++i)
        {
            if (Character.getNumericValue(data[i][0]) == 0)
            {
                col_zero = true;
                break;
            }
        }

        for (int i = 1; i < nrow; ++i)
            for (int j = 1; j < ncol; ++j)
            {
                if (Character.getNumericValue(data[i][j]) == 0)
                {
                    data[0][j] = '0';
                    data[i][0] = '0';
                }
            }
        for (int i = 1; i < nrow; ++i)
            for (int j = 1; j < ncol; ++j)
            {
                if (Character.getNumericValue(data[0][j]) == 0
                    || Character.getNumericValue(data[i][0]) == 0)
                {
                    data[i][j] = '0';
                }
            }
        if (row_zero)
            for (int j = 0; j < ncol; ++j)
                data[0][j] = '0';
        if (col_zero)
            for (int i = 0; i < nrow; ++i)
                data[i][0] = '0';
    }

    private static void displayMatrix (char[][] data)
    {
        for (int i = 0; i < data.length; ++i)
        {
            for (int j = 0; j < data[i].length; ++j)
            {
                System.out.print(data[i][j] + ",");
            }
            System.out.print("\n");
        }
    }
}
