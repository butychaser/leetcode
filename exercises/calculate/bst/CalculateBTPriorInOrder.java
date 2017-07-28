package calculate.bst;

import java.util.Arrays;

import util.BSTNode;
public class CalculateBTPriorInOrder

{

    public static void main (String[] args)
    {
        BSTNode[] priorOrder = new BSTNode[] {
            new BSTNode(1, null, null),
            new BSTNode(
            2,
            null,
 null),
            new BSTNode(4, null, null),
            new BSTNode(5, null, null),
            new BSTNode(3, null, null)//,
//            new BSTNode(6, null, null),
        //            new BSTNode(7, null, null)
        };
        BSTNode[] inOrder = new BSTNode[] {
            new BSTNode(4, null, null),
            new BSTNode(2, null, null),
            new BSTNode(5, null, null),
            new BSTNode(1, null, null),
//            new BSTNode(6, null, null),
            new BSTNode(3, null, null)//,
//            new BSTNode(7, null, null)
            };
        BSTNode root = calculate(priorOrder, inOrder);
        BSTNode.iteratePriorBST(root, true);

    }

    private static BSTNode calculate (BSTNode[] prior, BSTNode[] in)
    {
        if (prior.length == 0 || in.length == 0) //the case in which the prior's root is the last of in.
            return null;

        if (prior.length == 1 && in.length == 1 && prior[0].equals(in[0])) //conquer occurs once array's length is 1
            return prior[0];

        BSTNode root = prior[0];
        int distance = 0;
        for (int i = 0; i < in.length; ++i)
        {
            if (root.equals(in[i]))
                break;
            ++distance; //calculate the distance of root out of in-order traversal.

        }

        root.setLeftNode(calculate(
Arrays.copyOfRange(prior, 1, distance + 1), //calculate left tree on left of prior and in 
            Arrays.copyOfRange(in, 0, distance)));
        root.setRightNode(calculate(
Arrays.copyOfRange(prior, distance + 1, prior.length), //calculate right tree on right of prior and in 
            Arrays.copyOfRange(in, distance + 1, in.length)));
        return root;
    }
}
