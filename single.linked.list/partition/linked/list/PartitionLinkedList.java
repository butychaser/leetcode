package partition.linked.list;

import util.ListNode;

public class PartitionLinkedList
{

    public static void main (String[] args)
    {
        ListNode nd6 = new ListNode(null, 5);
        ListNode nd5 = new ListNode(nd6, 2);
        ListNode nd4 = new ListNode(nd5, 3);
        ListNode nd3 = new ListNode(nd4, 4);
        ListNode nd2 = new ListNode(nd3, 2);
        ListNode nd1head = new ListNode(nd2, 1);
        ListNode result = partitionLinkedList(nd1head, 3);
        iterateLinkedList(result);
    }

    private static ListNode partitionLinkedList (ListNode head, int x)
    {
        ListNode dummyLeft = new ListNode(null, -1), dummyRight = new ListNode(null, -1);
        ListNode curLeft = dummyLeft;
        ListNode curRight = dummyRight;
        for (ListNode cur = head; cur != null; cur = cur.getNext())
        {
            if (cur.getValue() < x)
            {
                curLeft.setNext(cur);
                curLeft = cur;
            }
            else
            {
                curRight.setNext(cur);
                curRight = cur;
            }
        }
        curLeft.setNext(dummyRight.getNext());
        return dummyLeft.getNext();
    }
    private static void iterateLinkedList (ListNode head)
    {
        while (head != null)
        {
            System.out.print(head);
            head = head.getNext();
        }
        //System.out.println("\n");
    }
}
