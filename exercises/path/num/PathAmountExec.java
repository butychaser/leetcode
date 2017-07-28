package path.num;

import util.BSTNode;

public class PathAmountExec
{

    static int result = Integer.MIN_VALUE;
    
    public static void main (String[] args)
    {
        BSTNode d2x6right = new BSTNode(4, null, null);
        BSTNode d2x5left = new BSTNode(5, null, null);
        BSTNode d2x4right = new BSTNode(4, null, null);
        BSTNode d2x3left = new BSTNode(1, null, null);
        BSTNode d1x2right = new BSTNode(-9, d2x5left, d2x6right);
        BSTNode d1x1left = new BSTNode(-2, d2x3left, d2x4right);
        BSTNode root = new BSTNode(6, d1x1left, d1x2right);
        System.out.println(dfs(root));
        System.out.println(result);

    }

    public static int dfs (BSTNode node)
    {
        if (node == null)
            return 0;
        
        int value = node.getValue();
        int l = dfs(node.getLeftNode());
        int r = dfs(node.getRightNode());
        int inter = value;
        inter += l > 0 ? l : 0;
        inter += r > 0 ? r : 0;
        result = Math.max(result, inter);
        return Math.max(l, r) > 0 ? Math.max(l, r) + value : value;
    }

}
