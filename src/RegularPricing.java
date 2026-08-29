public class RegularPricing implements PricingStrategy {

    private static final double BASE_PRICE = 300.0;
    private static final double INGREDIENT_PRICE = 50.0;

    @Override
    public double calculate(Pizza pizza) {
        double price = BASE_PRICE;

        price += getSizePrice(pizza.getSize());
        price += getIngredientPrice(pizza);

        return price;
    }

    private double getSizePrice(Pizza.Size size) {
        return switch (size) {
            case SMALL -> 0;
            case MEDIUM -> 100;
            case LARGE -> 300;
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
        return "Обычная цена";
    }
}
