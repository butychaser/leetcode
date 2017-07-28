package find.shared.list.node;

import util.ListNode;

public class FindSharedListNodeSolution
{

    public static void main (String[] args)
    {
        ListNode nd1 = new ListNode(null, 1);

        ListNode nd2 = new ListNode(nd1, 2);

        ListNode nd3 = new ListNode(nd2, 3);

        ListNode nd4 = new ListNode(nd3, 4);

        ListNode nd5head = new ListNode(nd4, 5);
        
        ListNode nd6 = new ListNode(nd4, 6);

        ListNode nd7 = new ListNode(nd6, 7);

        ListNode nd8 = new ListNode(nd7, 8);

        ListNode nd9head = new ListNode(nd8, 9);

        System.out.println(CalculateSharedNode(nd5head, nd9head));
    }

    private static ListNode CalculateSharedNode (ListNode head1, ListNode head2)
    {
        ListNode longHead = head1, shortHead = head2;
        int diff = calculateListLength(head1) - calculateListLength(head2);
        if (diff < 0)
        {
            longHead = head2;
            shortHead = head1;
        }
        diff = Math.abs(diff);

        for (int i = 0; i < diff; ++i)
        {
            longHead = longHead.getNext();
        }
        
        while (longHead != null & shortHead != null && longHead != shortHead)
        {
            longHead = longHead.getNext();
            shortHead = shortHead.getNext();
        }

        return shortHead;

    }

    private static int calculateListLength(ListNode head)
    {
        int length = 0;
        do 
        {
            ++length;
            head = head.getNext();
        }
        while(head != null);
        return length;
    }

}
