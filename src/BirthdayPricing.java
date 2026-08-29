public class BirthdayPricing extends RegularPricing{

    private static final double PIZZA_DISCOUNT = 0.10;
    @Override
    public double calculate(Pizza pizza) {
        double price=super.calculate(pizza);
        price= price* (1-PIZZA_DISCOUNT);
        return price;
    }

    @Override
    public String getStrategyName() {
        return "Скидка в честь дня рождения";
    }
}
