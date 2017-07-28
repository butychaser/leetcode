package path.num;

import java.util.ArrayList;
import java.util.List;

import util.BSTNode;

public class PathNum
{

    public static List<List<Integer>> result = new ArrayList<>();
    public static void main (String[] args)
    {
        BSTNode d2x6right = new BSTNode(4, null, null);
        BSTNode d2x5left = new BSTNode(5, null, null);
        BSTNode d2x4right = new BSTNode(4, null, null);
        BSTNode d2x3left = new BSTNode(1, null, null);
        BSTNode d1x2right = new BSTNode(1, d2x5left, d2x6right);
        BSTNode d1x1left = new BSTNode(2, d2x3left, d2x4right);
        BSTNode root = new BSTNode(3, d1x1left, d1x2right);
        System.out.println(calculatePathNum(root, new ArrayList<Integer>(), 9, 0));

    }

    private static List<List<Integer>> calculatePathNum (
        BSTNode root,
        List<Integer> path,
        Integer target,
        Integer inter)
    {
        if (root == null)
            return result;
        
        path.add(root.getValue());
        Integer sum = inter + root.getValue();

        if (root.getLeftNode() == null && root.getRightNode() == null && sum == target)
        {
            result.add(new ArrayList<Integer>(path));
        }
        
        calculatePathNum(root.getLeftNode(), path, target, sum);
        calculatePathNum(root.getRightNode(), path, target, sum);

        int length = path.size();
        path.remove(length > 0 ? length - 1 : 0);
        
        return result;
    }

}
