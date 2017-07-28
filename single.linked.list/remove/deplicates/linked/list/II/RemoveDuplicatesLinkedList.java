package remove.deplicates.linked.list.II;

import util.ListNode;

public class RemoveDuplicatesLinkedList
{

    public static void main (String[] args)
    {
        ListNode nd0 = null;
        ListNode nd1 = new ListNode(null, 1);
        ListNode nd2 = new ListNode(nd1, 1);
        ListNode nd3 = new ListNode(nd2, 2);
        ListNode nd4 = new ListNode(nd3, 3);
        ListNode nd5 = new ListNode(nd4, 3);
        ListNode nd6 = new ListNode(nd5, 4);

        ListNode.iterateListNodes(nd2);
        ListNode result = removeDuplicates(nd2);
        ListNode.iterateListNodes(result);

    }
    
    private static ListNode removeDuplicates (ListNode head)
    {
        if (head == null || head.getNext() == null) //conquer occurs as isNull(head.getNext())
            return head;
        if (head.getValue() == head.getNext().getValue()) //the duplicates found as a next
        {
            while (head.getNext() != null && head.getValue() == head.getNext().getValue())
            {
                head.setNext(head.getNext().getNext()); //remove duplicates
            }
            return removeDuplicates(head.getNext()); //get rid of the source of duplicates
        }
        else
        {
            ListNode next = removeDuplicates(head.getNext());
            head.setNext(next);                      //head with a next of no-duplicates.
            return head;
        }
    }
}
