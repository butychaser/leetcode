package swap.adjacent.nodes;

import util.ListNode;

public class SwapAdjacentNodes extends ListNode
{
    static ListNode head = nd1head;
    public static void main (String[] args)
    {

        ListNode.iterateListNodes(head);
        ListNode.iterateListNodes(swap(null, head));
    }

    private static ListNode swap (ListNode prevHead, ListNode head)
    {
        if(head == null || head.getNext() == null)
            return null;
        ListNode dummy = prevHead; 
        if (dummy == null)                         
            dummy = new ListNode(head, -1);
        ListNode next = head.getNext();

        head.setNext(next.getNext());  //p -> prev ->head
        next.setNext(head);            //c -> cur  ->next 
        dummy.setNext(next);           //h -> fixHead -> dummy
                                       //c cur = prev.getNext()  
        swap(head, head.getNext());
        return next; //return the new head of next (or cur)   
    }

}
