public class ExpressDeliveryDecorator extends OrderDecorator{

    private static final double DELIVERY_PRICE=150.0;
    public ExpressDeliveryDecorator(Order decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public double getTotalPrice() {
        return decoratedOrder.getTotalPrice()+DELIVERY_PRICE;
    }

    @Override
    public String toString() {
        return decoratedOrder.toString()+"\nЭкспресс доставка:"+DELIVERY_PRICE;
    }
}
