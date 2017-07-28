package rotate.linked.list;

//Given a list, rotate the list to the right by k places, where k is non-negative.
//For example: Given 1->2->3->4->5->nullptr and k = 2, return 4->5->1->2->3->nullptr.

import util.ListNode;
public class RotateLinkedList
{

    public static void main (String[] args)
    {
        ListNode nd5 = new ListNode(null, 5);
        ListNode nd4 = new ListNode(nd5, 4);
        ListNode nd3 = new ListNode(nd4, 3);
        ListNode nd2 = new ListNode(nd3, 2);
        ListNode nd1head = new ListNode(nd2, 1);
        ListNode.iterateListNodes(nd1head);
        ListNode.iterateListNodes(rotate(nd1head, 2));

    }

    private static ListNode rotate (ListNode head, int k)
    {
        int length = 1;
        ListNode node = head;
        for (; node.getNext() != null; node = node.getNext(), ++length)
        {

        }
        node.setNext(head);

        int offset = length - k;
        for (int i = 0; i < offset; ++i)
        {
            node = node.getNext();
        }
        head = node.getNext();
        node.setNext(null);
        return head;
    }

}
