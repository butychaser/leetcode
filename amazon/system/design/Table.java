package system.design;

public class Table<T> extends Furniture<T>
{
    Table (Material<T> _t)
    {
        t = _t;
    }

    @Override
    protected String furnitureType ()
    {
        // TODO Auto-generated method stub
        return "Table";
    }
}
