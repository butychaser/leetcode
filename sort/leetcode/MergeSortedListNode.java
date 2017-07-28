package leetcode;

import util.ListNode;

public class MergeSortedListNode
{

    public static void main (String[] args)
    {
        ListNode nd0 = null;
        ListNode nd1 = new ListNode(null, 1);
        ListNode nd2 = new ListNode(nd1, 2);
        ListNode nd3 = new ListNode(nd2, 2);
        ListNode nd4 = new ListNode(nd3, 3);
        ListNode nd5 = new ListNode(nd0, 3);
        ListNode nd6 = new ListNode(nd5, 4);

        //ListNode.iterateListNodes(nd6);
        ;
        ListNode.iterateListNodes(merge(nd6, nd4));

    }

    public static ListNode merge (ListNode node1, ListNode node2)
    {

        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;

        ListNode node = new ListNode();
        ListNode dummy = new ListNode(node, -1);
        for (; node1 != null && node2 != null; node = node.getNext())
        {
            if (node1.getValue() > node2.getValue())
            {
                node.setNext(node1);
                node1 = node1.getNext();
            }
            else
            {
                node.setNext(node2);
                node2 = node2.getNext();
            }
        }
        if (node1 == null)
            node.setNext(node2);
        else
            node.setNext(node1);
        return dummy.getNext().getNext();
    }

}
