package reverse.linked.list;

import util.ListNode;
public class ReverseLinkedList
{

    public static void main (String[] args)
    {
        ListNode nd5 = new ListNode(null, 5);
        ListNode nd4 = new ListNode(nd5, 4);
        ListNode nd3 = new ListNode(nd4, 3);
        ListNode nd2 = new ListNode(nd3, 2);
        ListNode nd1head = new ListNode(nd2, 1);
        //        iterateLinkedList(nd1head);
        //        reverseLinkedList(nd1head, 2, 5);
        //        iterateLinkedList(nd1head);

    }

    private static void reverseLinkedList (ListNode head, int m, int n)
    {
        ListNode prev = new ListNode(head, 0);  //Define a prev node to define a fixed head node
        for (int i = 0; i < m - 1; ++i)         //to link with the new head of reversed list
            prev = prev.getNext();

        final ListNode fixHead = prev;          //a fixed head node to linked with the new head of reversed list
        prev = prev.getNext();                  //prev is the head of reversed list
        ListNode cur = prev.getNext();          //cur is the tail and then become the new head of revserse list link with the fixed head.
        
        for(int i = m;i < n; ++i)
        {
            prev.setNext(cur.getNext()); //prev point the cur's next and reverse prev and cur
            cur.setNext(fixHead.getNext());    //inject the cur node as before the head of reverse list.
            fixHead.setNext(cur);              //always link cur with the fixed head as inject cur as head. 
            cur = prev.getNext();              //move cur as the next tail  
        }

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
