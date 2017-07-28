package reverse.node.k.group;

import util.ListNode;

//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//You may not alter the values in the nodes, only nodes itself may be changed.
//Only constant memory is allowed.
//For example, Given this linked list: 1->2->3->4->5
//For k = 2, you should return: 2->1->4->3->5
//For k = 3, you should return: 3->2->1->4->5

public class ReverseNodeKGroup extends ListNode
{

    static ListNode head = ListNode.nd1head;
    public static void main (String[] args)
    {
        ListNode.iterateListNodes(head);
        ListNode.iterateListNodes(reverse(null, head, 2));

    }

    private static ListNode reverse (ListNode priorHead, ListNode head, int k)
    {
        ListNode node = head;
        for (int i = 0; i < k; ++i)
        {
            if (node == null)
                return head; // return head if the k-group's length < k.
            node = node.getNext();
        }
        ListNode fixedHead = priorHead;
        if (fixedHead == null)
            fixedHead = new ListNode(head, -1); //set head as fixedHead's next.
        ListNode prev = head;
        ListNode cur = prev.getNext();

        for (int i = 1; i < k; ++i) // k-group is moving k-1 steps towards tail.
        {
            prev.setNext(cur.getNext());
            cur.setNext(fixedHead.getNext());
            fixedHead.setNext(cur);
            cur = prev.getNext(); //move cur to the next node as prev's next and fixedHead's next wont change.
        }

        ListNode result = reverse(prev, cur, k);
        prev.setNext(result);
        return fixedHead.getNext(); // return the head node of k-group nodes fixedHead's next.
    }

}
