package maximum.depth;

import util.BSTNode;

public class MaximumDepth
{

    public static void main (String[] args)
    {
        BSTNode d2x4right = new BSTNode(4, null, null);
        BSTNode d2x3left = new BSTNode(3, null, null);
        BSTNode d1x2right = new BSTNode(2, null, null);
        BSTNode d1x1left = new BSTNode(1, d2x3left, d2x4right);
        BSTNode root = new BSTNode(0, d1x1left, d1x2right);
        System.out.println(maximum(d1x1left));

    }

    public static int maximum (BSTNode root)
    {
        if (root == null)
            return 0;
        int left = maximum(root.getLeftNode());
        int right = maximum(root.getRightNode());

        return 1 + Math.max(left, right);
    }

}
