package system.design;

public interface Material<T>
{
    boolean stressTest ();

    boolean fireTest ();

    T materialType ();

    public String toString ();
}
