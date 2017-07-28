package order.dependency;

class Order
{
    public Order (String string)
    {
        this.order = string;
    }
    String order = "";

    public String toString ()
    {
        return order;
    }
}