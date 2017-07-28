package inorder.traversal.iterate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.BSTNode;

public class TraversalInorderIteration
{

    public static void main (String[] args)
    {
        BSTNode d2x6right = new BSTNode(6, null, null);
        BSTNode d2x5left = new BSTNode(5, null, null);
        BSTNode d2x4right = new BSTNode(4, null, null);
        BSTNode d2x3left = new BSTNode(3, null, null);
        BSTNode d1x2right = new BSTNode(2, d2x5left, d2x6right);
        BSTNode d1x1left = new BSTNode(1, null, d2x4right);
        BSTNode root = new BSTNode(0, d1x1left, null);

        //System.out.println(traverse(root));
        System.out.println(traversePrevOrder(root));

    }

    private static List<BSTNode> traverse (BSTNode root)
    {
        List<BSTNode> result = new ArrayList<>();
        Stack<BSTNode> s = new Stack<>();
        BSTNode node = root;
        while (node != null || !s.isEmpty())
        {
            if (node != null)
            {
                s.push(node);
                node = node.getLeftNode();
            }
            else
            {
                node = s.pop();
                result.add(node);
                node = node.getRightNode();
            }
        }
        return result;
    }

    private static List<BSTNode> traversePrevOrder (BSTNode root)
    {
        if (root == null)
            return null;
        List<BSTNode> result = new ArrayList<>();
        Stack<BSTNode> s = new Stack<>();
        BSTNode node = root;

        result.add(node);
        while(!s.isEmpty()||(node.getLeftNode()!=null || node.getRightNode()!=null)){
            if (node.getLeftNode() != null && node.getRightNode() != null)
            {
                s.push(node.getRightNode());
                result.add(node.getLeftNode());
                node = node.getLeftNode();

            }
            else if (node.getRightNode() != null)
            {
                result.add(node.getRightNode());
                node = node.getRightNode();
            }

            else if (node.getLeftNode() != null)
            {
                result.add(node.getLeftNode());
                node = node.getLeftNode();
            }

            else
            {
                node = s.pop();
                result.add(node);
            }

        }
        return result;

    }

}
