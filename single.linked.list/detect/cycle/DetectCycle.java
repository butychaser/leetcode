package detect.cycle;

import util.ListNode;

public class DetectCycle extends ListNode
{

    public static void main (String[] args)

    {
        System.out.println(detect(ListNode.nd5));
        System.out.println(detect(ListNode.nd4));
        System.out.println(detect(ListNode.nd3));
        System.out.println(detect(ListNode.nd2));
        System.out.println(detect(ListNode.nd1head));

        nd5.setNext(nd3);
        System.out.println(detect(ListNode.nd5));

    }

    private static boolean detect (ListNode head)
    {
        if (head == null || head.getNext() == null)
            return false;

        for (ListNode oneStep = head, twoStep = head; oneStep != null && twoStep != null; oneStep = oneStep
            .getNext(), twoStep = twoStep.getNext())
        {
            twoStep = twoStep.getNext();
            if (twoStep == null)
                return false;
            if (oneStep == twoStep)
                return true;
        }

            return false;
    }

}
