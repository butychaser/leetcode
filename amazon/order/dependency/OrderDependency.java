package order.dependency;

public class OrderDependency
{
    Order cur;
    Order pre;

    public OrderDependency (Order o1, Order o2)
    {
        cur = o2;
        pre = o1;
    }
}
