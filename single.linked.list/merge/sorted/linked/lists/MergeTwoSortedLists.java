package merge.sorted.linked.lists;

import util.ListNode;

public class MergeTwoSortedLists extends ListNode
{

    public static void main (String[] args)
    {
        //ListNode.iterateListNodes(merge(ListNode.nd5, ListNode.nd1head));
        //ListNode.iterateListNodes(merge(ListNode.nd5, ListNode.nd6));
        ListNode.iterateListNodes(merge(null, null));
    }

    public static ListNode merge(ListNode list1, ListNode list2)
    {
        if (list1 == null) //conquer and then return
            return list2;
        if (list2 == null) //conquer and then return
            return list1;
        ListNode newHead = null;
        if (list1.getValue() < list2.getValue())
        {
            newHead = list1;
            newHead.setNext(merge(list1.getNext(), list2)); //divide and then merge
        }

        if (list1.getValue() >= list2.getValue())
        {
            newHead = list2;
            newHead.setNext(merge(list1, list2.getNext())); //divide and then merge
        }
        return newHead;
    }

}
