package minimum.depth;

import util.BSTNode;

public class MinimumDepthCalculation
{

    public static void main (String[] args)
    {
        BSTNode d2x4right = new BSTNode(4, null, null);
        BSTNode d2x3left = new BSTNode(3, null, null);
        BSTNode d1x2right = new BSTNode(2, null, null);
        BSTNode d1x1left = new BSTNode(1, d2x3left, d2x4right);
        BSTNode root = new BSTNode(0, d1x1left, d1x2right);
        System.out.println(minimum(root));

    }

    public static int minimum (BSTNode root)
    {
        if (root != null && root.getLeftNode() == null && root.getRightNode() == null)
            return 1;
        if (root == null)
            return Integer.MAX_VALUE;

        int left = minimum(root.getLeftNode());
        int right = minimum(root.getRightNode());
        return 1 + Math.min(left, right);
    }

}
