package reverse.linked.list;

import util.ListNode;

public class ReverseLinkedListExec
{

    public static void main (String[] args)
    {
        ListNode nd5 = new ListNode(null, 5);
        ListNode nd4 = new ListNode(nd5, 4);
        ListNode nd3 = new ListNode(nd4, 3);
        ListNode nd2 = new ListNode(nd3, 2);
        ListNode nd1head = new ListNode(nd2, 1);
        ListNode.iterateListNodes(nd1head);
        ListNode reverse = reverse(nd1head);
        ListNode.iterateListNodes(nd5);
    }

    private static ListNode reverse (ListNode head)

    {
        ListNode head1 = new ListNode(head, -1);
        ListNode prev = head;
        ListNode cur = head.getNext();
        while (cur != null)
        {
            prev.setNext(cur.getNext());
            cur.setNext(head1.getNext());
            head1.setNext(cur);
            cur = prev.getNext();
        }
        return head1.getNext();
    }


}
