package plus.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOneSolution
{

    public static void main (String[] args)
    {

        Character[] inputArray = {'9', '9', '9', '9', '9', '9', '9'};
        //System.out.println(inputArray);
        System.out.println(caclulatePlusOne(1, Arrays.asList(inputArray)));

    }

    public static List<Character> caclulatePlusOne (int plus, List<Character> data)
    {
        data = new ArrayList<>(data);
        int c = plus;
        for (int i = 0; i < data.size(); ++i)
        {
            int inter = c + Character.getNumericValue(data.get(i));
            c = inter / 10;
            data.set(i, Character.forDigit(inter % 10, 10));
        }

        //List<Character> charList = Arrays.asList(data);
        if (c == 1)
            data.add(0, new Character('1'));
        return data;
    }
}
