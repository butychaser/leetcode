package Breath.First.Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph
{

    private List<Node> nodes = new ArrayList<>();

    public static void breadthFirstTraversal (Node rootNode)
    {

        Queue<Node> q = new LinkedList<>();
        q.add(rootNode);
        rootNode.visited = true;
        while (!q.isEmpty())
        {
            Node n = (Node) q.poll();
            System.out.print(n.data + " ");
            for (Node adj : n.adjacentNodes)
            {
                if (!adj.visited)
                {
                    adj.visited = true;
                    q.add(adj);
                }
            }
        }

    }

    public static void main (String[] args)
    {

        Node frankfurt = new Node("frankfurt");
        Node mannheim = new Node("mannheim");
        Node wurzburg = new Node("wurzburg");
        Node stuttgard = new Node("stuttgard");
        Node kassel = new Node("kassel");
        Node karlsruhe = new Node("karlsruhe");
        Node erfurt = new Node("erfurt");
        Node numberg = new Node("numberg");
        Node augsburg = new Node("augsburg");
        Node munchen = new Node("munchen");


        frankfurt.addAdjacentNode(mannheim);
        frankfurt.addAdjacentNode(wurzburg);
        frankfurt.addAdjacentNode(kassel);

        mannheim.addAdjacentNode(karlsruhe);

        karlsruhe.addAdjacentNode(augsburg);

        augsburg.addAdjacentNode(munchen);

        munchen.addAdjacentNode(kassel);
        munchen.addAdjacentNode(numberg);

        wurzburg.addAdjacentNode(erfurt);
        wurzburg.addAdjacentNode(numberg);

        numberg.addAdjacentNode(stuttgard);

        breadthFirstTraversal(frankfurt);
    }

}