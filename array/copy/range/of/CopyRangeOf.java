package copy.range.of;

import java.util.Arrays;

import util.BSTNode;

public class CopyRangeOf
{

    public static void main (String[] args)
    {
                                                                      
        BSTNode[] arrayA = {
            new BSTNode(1, null, null),
            new BSTNode(2, null, null),
            new BSTNode(4, null, null),
            new BSTNode(5, null, null),
            new BSTNode(3, null, null)};
        BSTNode[] arrayB = {
            new BSTNode(4, null, null),
            new BSTNode(2, null, null),
            new BSTNode(5, null, null),
            new BSTNode(1, null, null),
            new BSTNode(3, null, null)};
        BSTNode root = construct(arrayA, arrayB);
        BSTNode.iteratePriorBST(root, true);
        
    }

    public static BSTNode construct (BSTNode[] pre, BSTNode[] in)
    {
        if (pre.length == 0 || in.length == 0 || pre.length != in.length)
            return null;
        BSTNode root = pre[0];
        int offset = 0;
        for (BSTNode i : in)
        {
            if (root.getValue() == i.getValue())
                break;
            offset++;
        }

        root
.setLeftNode(construct(
            Arrays.copyOfRange(pre, 1, offset + 1),
            Arrays.copyOfRange(in, 0, offset)
        ));
        
        root
.setRightNode(construct(
            Arrays.copyOfRange(pre, offset + 1, pre.length),
            Arrays.copyOfRange(in, offset+1, in.length)
        ));
        

        return root;

    }

}
