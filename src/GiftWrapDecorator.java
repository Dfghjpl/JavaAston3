public class GiftWrapDecorator extends OrderDecorator{

    private static final double GIFT_WRAP_PRICE = 50.0;
    public GiftWrapDecorator(Order decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public double getTotalPrice() {
        return decoratedOrder.getTotalPrice()+GIFT_WRAP_PRICE;
    }

    @Override
    public String toString() {
        return decoratedOrder.toString()+"\nПодарочная упаковка:"+GIFT_WRAP_PRICE;
    }
}
