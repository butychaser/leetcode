package complex.linked.list;

import util.ComplexLinkListNode;

public class ComplexLinkedListSolution extends ComplexLinkListNode
{

    public static ComplexLinkListNode nodeHead = null;

    public static void main (String[] args)
    {
        ComplexLinkListNode.iterate(nodeHead);
        createClone();
        connectSibling();
        System.out.println("===================");
        ComplexLinkListNode.iterate(finalizeClone());
    }

    public static void createClone()
    {
        ComplexLinkListNode node = nodeHead;
        while (node != null)
        {
            ComplexLinkListNode clone = new ComplexLinkListNode(); //create a clone node as placeholder
            clone.setValue(node.getValue());
            clone.setNext(node.getNext());

            node.setNext(clone);
            node = clone.getNext();
        }
    }

    public static void connectSibling ()
    {
        ComplexLinkListNode node = nodeHead;
        while (node != null)
        {
            ComplexLinkListNode clone = node.getNext();
            clone.setSibling(node.getSibling() != null ? node.getSibling().getNext() : null);//check if original node without sibling.
            node = clone.getNext();

        }

    }

    public static ComplexLinkListNode finalizeClone ()
    {
        ComplexLinkListNode node = nodeHead;
        ComplexLinkListNode cloneHead = null, clone = null; //prepare cloneHead and clone if original is null.
        if (node == null)
            return cloneHead;

        cloneHead = node.getNext();
        clone = node.getNext();
        while (node != null)
        {
            node.setNext(clone.getNext());
            node = node.getNext();
            if (node != null)
            {
            clone.setNext(node.getNext());
                clone = clone.getNext();
            }
            else
            {
                clone.setNext(null);
            }

        }
        return cloneHead;
    }

}
