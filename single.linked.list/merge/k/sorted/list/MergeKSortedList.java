package merge.k.sorted.list;

import util.ListNode;

public class MergeKSortedList
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

        ListNode.iterateListNodes(nd6);
        ListNode.iterateListNodes(nd4);
        ListNode.iterateListNodes(merge(nd6, nd4));

    }
    
    public static ListNode merge (ListNode node1, ListNode node2)
    {
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;
        ListNode node = new ListNode(), head = null;
        
        for (head = new ListNode(node, -1); node1 != null || node2 != null; node = node
            .getNext())
        {
            int value1 = node1 != null ? node1.getValue() : Integer.MIN_VALUE;
            int value2 = node2 != null ? node2.getValue() : Integer.MIN_VALUE;
            if (value1 > value2)
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
        return head;
    }
}
