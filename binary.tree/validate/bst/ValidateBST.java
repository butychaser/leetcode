package validate.bst;

import util.BSTNode;

public class ValidateBST
{

    public static void main (String[] args)
    {
        BSTNode d2x6right = new BSTNode(6, null, null);
        BSTNode d2x5left = new BSTNode(5, null, null);
        BSTNode d2x4right = new BSTNode(4, null, null);
        BSTNode d2x3left = new BSTNode(1, null, null);
        BSTNode d1x2right = new BSTNode(2, d2x5left, d2x6right);
        BSTNode d1x1left = new BSTNode(2, d2x3left, d2x4right);
        BSTNode root = new BSTNode(3, d1x1left, null);
        BSTNode.iteratePriorBST(root, false);

        System.out.println(validate(root));

    }

    private static boolean validate (BSTNode root)
    {
        if (root == null)
            return true;
        boolean left = validate(root.getLeftNode());
        boolean right = validate(root.getRightNode());
        
        return (left
            && right
            && (root.getLeftNode() == null ? true : (root.getLeftNode().getValue() < root
                .getValue()
))
 && (root.getRightNode() == null ? true : root
                .getRightNode()
            .getValue() > root.getValue()))
;
    }

}
