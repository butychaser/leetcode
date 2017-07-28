package traversal.in.level;

import java.util.ArrayList;
import java.util.List;

import util.BSTNode;

public class TraverseInLevelBST
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

        List<List<BSTNode>> result = new ArrayList<>();
        traverse(root, 1, result);
        System.out.println(result);

    }

    private static void
 traverse (BSTNode root, int level, List<List<BSTNode>> result)
    {
        if (root == null)
            return;
        if (level > result.size())
            result.add(new ArrayList<BSTNode>());
        result.get(level - 1).add(root);
        traverse(root.getLeftNode(), level + 1, result);
        traverse(root.getRightNode(), level + 1, result);

    }

}
