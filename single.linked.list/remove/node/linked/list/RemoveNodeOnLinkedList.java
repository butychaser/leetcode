package remove.node.linked.list;

import util.ListNode;

//Remove a specific node from a linked list.
public class RemoveNodeOnLinkedList
{

    public static void main (String[] args)
    {
        ListNode nd1 = new ListNode(null, 1);
        ListNode nd2 = new ListNode(nd1, 2);
        ListNode nd3 = new ListNode(nd2, 3);
        ListNode nd4 = new ListNode(nd3, 4);
        iterateLinkedList(nd4);
        removeNode(nd4, nd2);
        iterateLinkedList(nd4);


    }

    private static void removeNode (ListNode head, ListNode deleted)
    {
        if (deleted.getNext() != null)
        {
            ListNode next = deleted.getNext();
            deleted.setValue(next.getValue());
            deleted.setNext(next.getNext());
        }
        else
        {
            ListNode pre = head;
            while (!pre.getNext().equals(deleted))
            {
                pre = pre.getNext();
            }
            pre.setNext(null);

        }
    }

    private static void iterateLinkedList (ListNode head)
    {
        do
        {
            System.out.println(head);
            head = head.getNext();
        }
        while (head != null);
    }

}
