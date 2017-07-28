package detect.sub.tree;

import util.BSTNode;

public class DetectSubTree
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

        BSTNode s1x3left = new BSTNode(3, null, null);
        BSTNode s1x2right = new BSTNode(2, null, null);
        BSTNode s1x1left = new BSTNode(1, s1x3left, null);
        BSTNode sample = new BSTNode(0, s1x1left, s1x2right);

        System.out.println(detectRootNode(root, sample));
        BSTNode.iterateInBST(root, false);
        swapChildren(root);
        //BSTNode.iterateInBST(root, false);

    }

    private static boolean detectRootNode (BSTNode root, BSTNode sample)
    {
        boolean result = false;
        if (root == null || sample == null)
            return false;

        //result = tree1.equals(sample);          
        if (root.equals(sample)) //if root is equals, then check its subtree
            result = detectSubTree(root, sample);

        if (!result)
            result = detectRootNode(root.getLeftNode(), sample); //if the root or its subtree is not equals, 
        if (!result) //then have the node moved its left 
            result = detectRootNode(root.getRightNode(), sample);//and even right node.
        return result;

    }

    private static boolean detectSubTree (BSTNode root, BSTNode sample)
    {
        if (sample == null) //defense programming 
            return true; //and the occurrence of recursion's conquer

        if (root == null) //false if sample have value but root is null.
            return false;

        return root.equals(sample) && detectSubTree(root.getLeftNode(), sample.getLeftNode()) //check current node equality and then its left and right
            && detectSubTree(root.getRightNode(), sample.getRightNode()); //node's equality 
    }
    
    private static void swapChildren (BSTNode root)
    {
        if (root == null)
            return;
        BSTNode tmp = root.getLeftNode();
        root.setLeftNode(root.getRightNode());
        root.setRightNode(tmp);
        swapChildren(root.getLeftNode());
        swapChildren(root.getRightNode());

    }


}
