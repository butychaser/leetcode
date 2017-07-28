package system.design;

public class Chair<T> extends Furniture<T>
{
    Chair (Material<T> _t)
    {
        t = _t;
    }
    @Override
    protected String furnitureType ()
    {
        // TODO Auto-generated method stub
        return "Chair";
    }

}
