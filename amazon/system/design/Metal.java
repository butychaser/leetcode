package system.design;

public class Metal implements Material<Metal>
{

    @Override
    public boolean stressTest ()
    {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean fireTest ()
    {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public Metal materialType ()
    {
        // TODO Auto-generated method stub
        return this;
    }

}
