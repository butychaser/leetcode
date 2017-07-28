package remove.duplicates.linked.list;

import util.ListNode;

//Given a sorted linked list, delete all duplicates such that each element appear only once.
//For example,
//Given 1->1->2, return 1->2.
//Given 1->1->2->3->3, return 1->2->3.

public class RemoveDuplicatesLinkedList
{

    public static void main (String[] args)
    {
        ListNode nd0 = null;
        ListNode nd1 = new ListNode(null, 1);
        ListNode nd2 = new ListNode(nd1, 2);
        ListNode nd3 = new ListNode(nd2, 2);
        ListNode nd4 = new ListNode(nd3, 3);
        ListNode nd5 = new ListNode(nd4, 3);
        ListNode nd6 = new ListNode(nd5, 4);

        ListNode.iterateListNodes(nd4);
        removeDuplicates(nd4);
        ListNode.iterateListNodes(nd4);
    }

    private static void removeDuplicates (ListNode head)
    {
        if (head == null)
            return;
        for (ListNode prev = head, cur = prev.getNext(); cur != null; cur = cur.getNext()) //define prev and cur as prev's next node
        {
            if (prev.getValue() == cur.getValue())
            {
                prev.setNext(cur.getNext());  //if found duplicates, then  prev's next set as cur's next 
            }
            else
            {
                prev = cur;                  //if not found, then assign cur to prev
            }
        }
    }
}
