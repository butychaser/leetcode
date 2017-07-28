package b.f.s;

import java.util.LinkedList;
import java.util.List;

public class Node
{

    public Node (String value)
    {
        _value = value;
    }

    public final String _value;
    public boolean      visited     = false;
    public List<Node>   adjacencies = new LinkedList<>();

    public void add (Node node)
    {
        node.adjacencies.add(this);
        adjacencies.add(node);

    }

    public void visit ()
    {
        visited = true;
    }

    public String toString ()
    {
        return _value;
    }

}