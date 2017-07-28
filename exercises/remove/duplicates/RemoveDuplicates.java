package remove.duplicates;

import util.ListNode;

public class RemoveDuplicates
{

    public static void main (String[] args)
    {
        ListNode nd0 = null;
        ListNode nd1 = new ListNode(null, 2);
        ListNode nd2 = new ListNode(nd1, 2);
        ListNode nd3 = new ListNode(nd2, 2);
        ListNode nd4 = new ListNode(nd3, 3);
        ListNode nd5 = new ListNode(nd4, 3);
        ListNode nd6 = new ListNode(nd5, 4);

        ListNode.iterateListNodes(nd6);
        ListNode result = remove(nd6);
        ListNode.iterateListNodes(result);
    }

    private static ListNode remove (ListNode head)
    {
        if (head == null || head.getNext() == null)
            return head;
        if (head.getValue() == head.getNext().getValue())
        {
            while (head.getNext() != null && head.getValue() == head.getNext().getValue())
            {
                head = head.getNext();
            }
            return remove(head.getNext());

        }
        else
        {
            head.setNext(remove(head.getNext()));
            return head;
        }
    }

}
