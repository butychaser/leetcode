package balanced.bst;

import util.BSTNode;

public class BalancedBST
{

    public static void main (String[] args)
    {
        BSTNode d2x6right = new BSTNode(6, null, null);
        BSTNode d2x5left = new BSTNode(5, null, null);
        BSTNode d2x4right = new BSTNode(4, null, null);
        BSTNode d2x3left = new BSTNode(3, null, null);
        BSTNode d1x2right = new BSTNode(2, d2x5left, d2x6right);
        BSTNode d1x1left = new BSTNode(1, d2x3left, d2x4right);
        BSTNode root = new BSTNode(0, d1x1left, d1x2right);

        System.out.println(balancedBST(root));

    }

    private static int balancedBST (BSTNode root)
    {
        if (root == null)
            return 0;
        
        int left = balancedBST(root.getLeftNode());
        int right = balancedBST(root.getRightNode());
        
        if (left < 0 || right < 0 || Math.abs(right - left) > 1)
            return -1;
        
        return Math.max(left, right) + 1;
    }

}
