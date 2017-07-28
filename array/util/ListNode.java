package util;

public class ListNode

{

    public ListNode ()
    {
        _next = null;
        _value = -1;
    }

    public ListNode (ListNode next, int value)
    {
        _next = next;
        _value = value;
    }

    public String toString ()
    {
        return Integer.valueOf(_value).toString()
            + (_next != null ? Integer.valueOf(_next.getValue()).toString() : null) + " | ";
    }

    public ListNode getNext ()
    {
        return _next;
    }

    public int getValue ()
    {
        return _value;
    }

    public void setNext (ListNode next)
    {
        _next = next;
    }

    public void setValue (int value)
    {
        _value = value;
    }

    private ListNode _next;
    private int      _value;

    protected boolean equals (ListNode node)
    {
        if (node == null)
            return false;
        return this.getValue() == node.getValue() && this.getNext() == node.getNext();

    }

    public static void iterateListNodes (ListNode head)
    {
        for (ListNode cur = head; cur != null; cur = cur.getNext())
            System.out.print(cur);
        System.out.print("\n");
    }

    protected static ListNode nd6     = new ListNode(null, 6);
    protected static ListNode nd5     = new ListNode(null, 5);
    protected static ListNode nd4     = new ListNode(nd6, 4);
    protected static ListNode nd3     = new ListNode(nd4, 3);
    protected static ListNode nd2     = new ListNode(nd3, 2);
    protected static ListNode nd1head = new ListNode(nd2, 1);

}
