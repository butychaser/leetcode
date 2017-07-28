package system.design;

public class Glass<T extends Material<T>> implements Material<T>
{

    @Override
    public boolean stressTest ()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean fireTest ()
    {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public T materialType ()
    {
        // TODO Auto-generated method stub
        return (T) this;
    }

}
