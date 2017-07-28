package system.design;

public class FurnitureClient
{

    public static void main (String[] args)
    {
        //Material<? extends Material<?>> material = new Metal();
        Furniture<? extends Material<?>> oneTable = new Table<>(new Metal());
        oneTable.fireTest();
        oneTable.stressTest();

        Chair<? extends Material<?>> oneChair = new Chair<>(new SteelGlass());
        oneChair.stressTest();
        oneChair.fireTest();
    }

}
