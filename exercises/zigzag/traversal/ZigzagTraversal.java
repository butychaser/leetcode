package zigzag.traversal;

import java.util.ArrayList;
import java.util.List;

import util.BSTNode;

public class ZigzagTraversal
{
    public static List<List<BSTNode>> result = new ArrayList<>();
    
    public static void main (String[] args)
    {
        BSTNode d2x6right = new BSTNode(6, null, null);
        BSTNode d2x5left = new BSTNode(5, null, null);
        BSTNode d2x4right = new BSTNode(4, null, null);
        BSTNode d2x3left = new BSTNode(3, null, null);
        BSTNode d1x2right = new BSTNode(2, d2x5left, d2x6right);
        BSTNode d1x1left = new BSTNode(1, d2x3left, d2x4right);
        BSTNode root = new BSTNode(0, d1x1left, d1x2right);

        traverse(root, 0, true);
        System.out.println(result);

    }

    public static void traverse (BSTNode root, int level, boolean zigzag)
    {
        if (root == null)
            return;

        if (level == result.size())
            result.add(new ArrayList<BSTNode>());

        if (zigzag)
            result.get(level).add(root);
        else
            result.get(level).add(0, root);
        traverse(root.getLeftNode(), level + 1, !zigzag);
        traverse(root.getRightNode(), level + 1, !zigzag);

    }

}
