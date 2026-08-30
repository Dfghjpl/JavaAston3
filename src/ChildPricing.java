public class ChildPricing implements PricingStrategy {

    private static final double BASE_PRISE = 200;

    @Override
    public double calculate(Pizza pizza) {
        double price = BASE_PRISE;
        price += getSizePrice(pizza.getSize());

        return price;
    }

    private double getSizePrice(Pizza.Size size) {
        return switch (size) {
            case SMALL -> 0;
            case MEDIUM -> 50;
            case LARGE -> 100;
        };
    }


    @Override
    public String getStrategyName() {
        return "Детская скидка";
    }
}
