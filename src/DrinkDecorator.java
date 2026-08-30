public class DrinkDecorator extends OrderDecorator {

    private static final double DRINK_PRICE = 100.0;
    private final String drinkName;

    public DrinkDecorator(Order decoratedOrder, String drinkName) {
        super(decoratedOrder);
        this.drinkName = drinkName;
    }

    public DrinkDecorator(Order decoratedOrder) {
        this(decoratedOrder, "Кола");
    }

    @Override
    public double getTotalPrice() {
        return decoratedOrder.getTotalPrice() + DRINK_PRICE;
    }

    @Override
    public String toString() {
        return decoratedOrder.toString() + "\nНапиток:" + drinkName + " " + DRINK_PRICE;
    }
}
