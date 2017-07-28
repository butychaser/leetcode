package k.closest.points;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPoints
{
    public static class Point
    {


        public Point (int _x, int _y)
        {
            x = _x;
            y = _y;
        }

        public int distance (Point p1)
        {
            return (this.x - p1.x) * (this.x - p1.x) + (this.y - p1.y) * (this.y - p1.y);
        }

        public String toString ()
        {
            return "[x,y] =>[" + x + "," + y + "]";
        }

        int x;
        int y;
    }
    public static void main (String[] args)
    {
        Point[] points = new Point[] {
            new Point(1, 1),
            new Point(2, 2),
            new Point(3, 3),
            new Point(4, 4),
            new Point(5, 5),
            new Point(6, 6)};

        List<Point> result = search(new Point(1, 1), 5, points);
        System.out.println(result);

    }

    public static List<Point> search (Point target, int k, Point... p)
    {
        PriorityQueue<Point> q = new PriorityQueue<Point>(k, new Comparator<Point>()
        {
            @Override
            public int compare (Point o1, Point o2)
            {
                return o2.distance(target) - o1.distance(target);
            }
        });

        int n = p.length;
        for (int i = 0; i < n; ++i)
        {
            if (i < k)
            {
                q.offer(p[i]);
            }
            else
            {
                Point tmp = q.peek();
                if (p[i].distance(target) < tmp.distance(target))
                {
                    q.poll();
                    q.offer(p[i]);
                }
            }
        }

        List<Point> result = new ArrayList<>();
        while (q.peek() != null)
            result.add(q.poll());
        return result;
    }

}
