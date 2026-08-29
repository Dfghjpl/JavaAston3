public class ChildPricing implements PricingStrategy {

    private static final double BASE_PRISE = 150.0;
    private static final double INGREDIENT_PRICE = 20.0;

    @Override
    public double calculate(Pizza pizza) {
        double price = BASE_PRISE;
        price += getSizePrice(pizza.getSize());

        price += getIngredientPrice(pizza);

        return price;
    }

    private double getSizePrice(Pizza.Size size) {
        return switch (size) {
            case SMALL -> 0;
            case MEDIUM -> 50;
            case LARGE -> 100;
        };
    }

    public static double getIngredientPrice(Pizza pizza) {
        int countIngredients = 0;
        if (pizza.getChesse()) countIngredients++;
        if (pizza.getBacon()) countIngredients++;
        if (pizza.getOlives()) countIngredients++;
        if (pizza.getOnions()) countIngredients++;
        if (pizza.getPineapple()) countIngredients++;
        if (pizza.getTomato()) countIngredients++;
        return countIngredients * INGREDIENT_PRICE;
    }

    @Override
    public String getStrategyName() {
        return "Детская скидка";
    }
}
