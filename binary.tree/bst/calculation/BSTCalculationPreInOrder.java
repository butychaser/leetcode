package bst.calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.BSTNode;

public class BSTCalculationPreInOrder
{

    public static void main (String[] args)
    {
        List<BSTNode> priorOrder = Arrays.asList(new BSTNode(1, null, null), new BSTNode(
            2,
            null,
            null),
            new BSTNode(4, null, null),
 new BSTNode(5, null, null), new BSTNode(
            3,
            null,
            null), new BSTNode(6, null, null), new BSTNode(7, null, null));
        List<BSTNode> inOrder = Arrays.asList(
            new BSTNode(4, null, null),
            new BSTNode(2, null, null),
            new BSTNode(5, null, null),
            new BSTNode(1, null, null),
            new BSTNode(6, null, null),
            new BSTNode(3, null, null),
            new BSTNode(7, null, null));
        BSTNode root = calculateBSTbyPreInOrder(priorOrder, inOrder);
        BSTNode.iteratePriorBST(root, true);

    }

    private static BSTNode
        calculateBSTbyPreInOrder (List<BSTNode> PriorOrder, List<BSTNode> InOrder)
        
    {
        if (PriorOrder.size() == 1 && InOrder.size() == 1
            && PriorOrder.get(0).equals(InOrder.get(0)))
            return PriorOrder.get(0);
        
        BSTNode root = PriorOrder.get(0);
        int distance = InOrder.size();
        List<BSTNode> leftInNodes = new ArrayList<>(), rightInNodes = new ArrayList<>();
        for (int idx = 0; idx < InOrder.size(); ++idx)
        {
            if (root.equals(InOrder.get(idx)))
            {
                distance = idx;
                continue;
            }
            if (idx < distance)
                leftInNodes.add(InOrder.get(idx));
            if (idx > distance)
                rightInNodes.add(InOrder.get(idx));

        }
        List<BSTNode> leftPriorNodes = new ArrayList<>(), rightPriorNodes = new ArrayList<>();
        for (int idx = 1; idx < PriorOrder.size(); ++idx)
        {
            if (idx <= distance)
            {
                leftPriorNodes.add(PriorOrder.get(idx));
                continue;
            }
            rightPriorNodes.add(PriorOrder.get(idx));
        }

        root.setLeftNode(calculateBSTbyPreInOrder(leftPriorNodes,leftInNodes ));
        root.setRightNode(calculateBSTbyPreInOrder(rightPriorNodes, rightInNodes));
        return root;

    }

}
