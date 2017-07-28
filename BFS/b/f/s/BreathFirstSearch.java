package b.f.s;

import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch
{
    public static void main(String[] args)
    {
        Node beijing = new Node("Beijing");
        Node tianjin = new Node("Tianjin");
        Node shanghai = new Node("Shanghai");
        Node chongqing = new Node("Chongqing");
        Node langfang = new Node("Lang fang");
        Node tanggu = new Node("Tang gu");
        Node wuhan = new Node("Wu han");
        Node nanjing = new Node("Nan jing");
        Node guangzhou = new Node("Guang zhou");
        Node chengdu = new Node("Cheng du");

        beijing.add(tianjin);
        tianjin.add(langfang);
        langfang.add(tanggu);
        tanggu.add(wuhan);
        beijing.add(shanghai);
        shanghai.add(nanjing);
        nanjing.add(wuhan);
        beijing.add(chongqing);
        chongqing.add(wuhan);
        wuhan.add(chengdu);
        chengdu.add(guangzhou);

        

        Queue<Node> q = new LinkedList<>();
        q.add(beijing);
        beijing.visit();
        while(!q.isEmpty())
        {
         Node node = q.poll();
          System.out.println("City:"+node);  
         for(Node n: node.adjacencies)
         { 
            if(!n.visited){
             n.visit();
             q.add(n);
            }    
         }
        }
    }

}
