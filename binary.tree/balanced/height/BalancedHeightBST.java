package balanced.height;

import util.BSTNode;

public class BalancedHeightBST
{

    public static void main (String[] args)
    {
        BSTNode d2x6right = new BSTNode(6, null, null);
        BSTNode d2x5left = new BSTNode(5, null, null);
        BSTNode d2x4right = new BSTNode(4, null, null);
        BSTNode d2x3left = new BSTNode(3, null, null);
        BSTNode d1x2right = new BSTNode(2, d2x5left, d2x6right);
        BSTNode d1x1left = new BSTNode(1, d2x3left, d2x4right);
        BSTNode root = new BSTNode(0, d1x1left, null);

        System.out.println(balanced(root));

    }

    // -1 is not a balanced tree
    private static int balanced (BSTNode root)
    {
        if (root == null)
            return 0; //conquer when no children

        int left = balanced(root.getLeftNode()); //recursion on both nodes. 
        int right = balanced(root.getRightNode());

        if (left < 0 | right < 0 | Math.abs(left - right) > 1) //depth differ of left and right 
            return -1; //more than 1 will be non-balanced.   
        return Math.max(left, right) + 1;

    }

}
