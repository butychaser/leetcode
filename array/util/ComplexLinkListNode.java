package util;

public class ComplexLinkListNode
{
    public ComplexLinkListNode ()
    {
        _value = 0;
        _next = null;
        _sibling = null;
    }

    protected ComplexLinkListNode (int value, ComplexLinkListNode next, ComplexLinkListNode sibling)
    {
        _value = value;
        _next = next;
        _sibling = sibling;
    }

    public String toString()
    {
        return Integer.toString(_value) + ":n[" + (_next != null ? _next.getValue() : "n/a")
            + "]:s[" + (_sibling != null ? _sibling.getValue() : "n/a") + "]|";
    }

    public static void iterate (ComplexLinkListNode head)
    {
        for (ComplexLinkListNode node = head; node != null; node = node.getNext())
            System.out.println(node);

        System.out.println("\n");

    }

    protected static ComplexLinkListNode nd6     = new ComplexLinkListNode(6, null, null);
    protected static ComplexLinkListNode nd5     = new ComplexLinkListNode(5, nd6, null);
    protected static ComplexLinkListNode nd4     = new ComplexLinkListNode(4, nd5, nd6);
    protected static ComplexLinkListNode nd3     = new ComplexLinkListNode(3, nd4, null);
    protected static ComplexLinkListNode nd2     = new ComplexLinkListNode(2, nd3, nd4);
    protected static ComplexLinkListNode nd1head = new ComplexLinkListNode(1, nd2, null);
    public int getValue ()
    {
        return _value;
    }

    public void setValue (int value)
    {
        _value = value;
    }

    public ComplexLinkListNode getNext ()
    {
        return _next;
    }

    public void setNext (ComplexLinkListNode next)
    {
        _next = next;
    }

    public ComplexLinkListNode getSibling ()
    {
        return _sibling;
    }

    public void setSibling (ComplexLinkListNode sibling)
    {
        _sibling = sibling;
    }


    int                 _value;
    ComplexLinkListNode _next;
    ComplexLinkListNode _sibling;

    public static void main (String[] args)
    {
        iterate(nd1head);

    }
}
