package maximum.path.num;

import util.BSTNode;

public class MaximumPathNum
{

    public static int result = Integer.MIN_VALUE;
    public static void main (String[] args)
    {
        BSTNode d2x6right = new BSTNode(4, null, null);
        BSTNode d2x5left = new BSTNode(5, null, null);
        BSTNode d2x4right = new BSTNode(4, null, null);
        BSTNode d2x3left = new BSTNode(1, null, null);
        BSTNode d1x2right = new BSTNode(-9, d2x5left, d2x6right);
        BSTNode d1x1left = new BSTNode(-2, d2x3left, d2x4right);
        BSTNode root = new BSTNode(-3, d1x1left, d1x2right);
        System.out.println(dfs(root));
        System.out.println(result);

    }
    
    private static int dfs (BSTNode root)
    {
        if(root == null)
            return 0; //return 0 when conquer occurs.

        int l = dfs(root.getLeftNode()); //recursion on left node.
        int r = dfs(root.getRightNode()); //recursion on right node.

        int inter = root.getValue();

        if (l > 0) //only add up if left > 0
            inter += l;
        if (r > 0) //only add up if right > 0  
            inter += r;
        result = Math.max(result, inter);//global result add up only when        
        
        return Math.max(l, r) > 0 ? Math.max(l, r) + root.getValue() : root.getValue(); //return from either r+root or l+root 
                                                                                        //when either l or r greater than 0.  
    }

}
