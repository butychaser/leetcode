package zigzag.traversal;

import java.util.ArrayList;
import java.util.List;

import util.BSTNode;

public class ZigzagTraversalSolu
{

    public static void main (String[] args)
    {
        List<List<BSTNode>> result = new ArrayList<>();

        BSTNode d2x6right = new BSTNode(6, null, null);
        BSTNode d2x5left = new BSTNode(5, null, null);
        BSTNode d2x4right = new BSTNode(4, null, null);
        BSTNode d2x3left = new BSTNode(3, null, null);
        BSTNode d1x2right = new BSTNode(2, d2x5left, d2x6right);
        BSTNode d1x1left = new BSTNode(1, d2x3left, d2x4right);
        BSTNode root = new BSTNode(0, d1x1left, d1x2right);

        traverse(root, 1, result, true);
        System.out.println(result);

    }
    
    private static void traverse (
        BSTNode root,
        int level,
        List<List<BSTNode>> result,
        boolean leftToRight)
    {
        if (root == null)
            return;

        if (level > result.size())
            result.add(new ArrayList<BSTNode>());

        if (leftToRight)
            result.get(level - 1).add(root);
        else
            result.get(level - 1).add(0, root);

        if (root.getLeftNode() != null)
            traverse(root.getLeftNode(), level + 1, result, !leftToRight);
        if (root.getRightNode() != null)
            traverse(root.getRightNode(), level + 1, result, !leftToRight);
    }

}
