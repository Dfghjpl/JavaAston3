public abstract class OrderDecorator extends Order {
    protected Order decoratedOrder;
    public OrderDecorator(Order decoratedOrder) {
        super(decoratedOrder.getPizzas(),
                decoratedOrder.getPricingStrategy(),
                decoratedOrder.getCustomerName());
        this.decoratedOrder = decoratedOrder;
    }

    @Override
    public double getTotalPrice() {
        return decoratedOrder.getTotalPrice();
    }

    @Override
    public String toString() {
        return decoratedOrder.toString();
    }
}
