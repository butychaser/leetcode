package util;

public class BSTNode
{

    public BSTNode ()
    {
        _leftNode = null;
        _rightNode = null;
        _value = -1;
    }

    public BSTNode (int value, BSTNode leftNode, BSTNode rightNode)
    {
        _leftNode = leftNode;
        _rightNode = rightNode;
        _value = value;
    }

    public String toString ()
    {
        return "  " + Integer.valueOf(_value).toString() + "\n" + " / \\ \n"
            + (_leftNode != null ? Integer.valueOf(_leftNode.getValue()).toString() : null) + "  "
            + (_rightNode != null ? Integer.valueOf(_rightNode.getValue()).toString() : null)
            + "\n";
    }

    public boolean equals (BSTNode other)
    {
        if (other == null)
            return false;
        return _value == other.getValue();

    }

    public static void iteratePriorBST (BSTNode root, boolean isLeft)
    {
        if (root == null)
            return;
        System.out.print(root);
        if (!isLeft)
            System.out.print("\n");
        iteratePriorBST(root.getLeftNode(), true);
        iteratePriorBST(root.getRightNode(), false);

    }

    public static void iterateInBST (BSTNode root, boolean isLeft)
    {
       if(root == null) return;
        iterateInBST(root.getLeftNode(), true);
       System.out.print(root);
        if (!isLeft)
            System.out.print("\n");
        iterateInBST(root.getRightNode(), false);
       
    }


    public BSTNode getLeftNode ()
    {
        return _leftNode;
    }

    public void setLeftNode (BSTNode leftNode)
    {
        _leftNode = leftNode;
    }

    public BSTNode getRightNode ()
    {
        return _rightNode;
    }

    public void setRightNode (BSTNode rightNode)
    {
        _rightNode = rightNode;
    }

    public int getValue ()
    {
        return _value;
    }

    public void setValue (int value)
    {
        _value = value;
    }
    private BSTNode _leftNode;
    private BSTNode _rightNode;
    private int     _value;

    public static void main (String[] argv)
    {
        BSTNode root = new BSTNode(1, new BSTNode(), null);
        System.out.println(root);
    }
}
