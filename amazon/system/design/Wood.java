package system.design;

public class Wood implements Material<Wood>
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
        return false;
    }

    @Override
    public Wood materialType ()
    {
        // TODO Auto-generated method stub
        return this;
    }

}
