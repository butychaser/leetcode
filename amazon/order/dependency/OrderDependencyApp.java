package order.dependency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class OrderDependencyApp
{
    public static List<Order> result = new ArrayList<>();

    public static void main (String[] args)
    {
        Order o1 = new Order("A");
        Order o2 = new Order("B");
        Order o3 = new Order("C");
        Order o4 = new Order("D");
        OrderDependency od1 = new OrderDependency(o1, o2);
        OrderDependency od2 = new OrderDependency(o2, o3);
        OrderDependency od3 = new OrderDependency(o3, o4);
        List<OrderDependency> list = new ArrayList<>();
        list.add(od1);
        list.add(od2);
        list.add(od3);

        BFSearch(list);
        for (Order o : result)
            System.out.println(o);

    }

    public static void BFSearch (List<OrderDependency> ods)
    {
        Set<Order> set = new HashSet<>();
        Map<Order, Integer> inMap = new HashMap<>();
        Map<Order, List<Order>> map = new HashMap<>();

        for (OrderDependency od : ods)
        {
            Order cur = od.cur, pre = od.pre;

            set.add(od.cur);
            set.add(od.pre);
            if (inMap.containsKey(cur))
            {
                inMap.put(cur, inMap.get(cur) + 1);
            }
            else
                inMap.put(cur, 1);

            if (!inMap.containsKey(pre))
                inMap.put(pre, 0);
            
            if(map.containsKey(pre))
            {
                map.get(pre).add(cur);
            }
            else
                map.put(pre, Arrays.asList(cur));
            
            if(!map.containsKey(cur))
                map.put(cur, new ArrayList<Order>());
        }

        Queue<Order> q = new LinkedList<>();

        for (Order o : inMap.keySet())
            {
                if (inMap.get(o) == 0)
                    q.offer(o);
            }

            while (!q.isEmpty())
        {
                Order o = q.poll();
                result.add(o);

                for (Order oo : map.get(o))
                {
                    inMap.put(oo, inMap.get(oo) - 1);
                    if (inMap.get(oo) == 0)
                        q.offer(oo);
                }
            }

            if (result.size() != set.size())
                return;


    }

}
