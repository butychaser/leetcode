package system.design;

public abstract class Furniture<T>
{
    protected Material<T> t;

    protected void stressTest ()
    {
        System.out.println("Furniture Type " + furnitureType() + " Material Type: "
            + t.materialType() + " on stress Test: " + t.stressTest());
    }

    protected void fireTest ()
    {
        System.out.println("Furniture Type" + furnitureType() + " Material Type: "
 + t.materialType()
 + " on fire Test: " + t.fireTest());
        return;
    }

    protected abstract String furnitureType ();

}
