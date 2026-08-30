public class IngredientsValidator extends OrderValidator {
    private static final int MAX_INGREDIENTS = 5;

    @Override
    public void validate(Order order) throws ValidationException {

        for (Pizza pizza : order.getPizzas()) {
            int ingredientCount = countIngredients(pizza);

            if (ingredientCount > MAX_INGREDIENTS) {
                throw new ValidationException(
                        "Слишком много ингредиентов в пицце: " +
                                ingredientCount + " (максимум " + MAX_INGREDIENTS + ")"
                );
            }
        }
        System.out.println("Проверка пройдена: все пиццы содержат не более " +
                MAX_INGREDIENTS + " ингредиентов");
        validateNext(order);
    }


    private int countIngredients(Pizza pizza) {
        int count = 0;
        if (pizza.getChesse()) count++;
        if (pizza.getBacon()) count++;
        if (pizza.getOlives()) count++;
        if (pizza.getOnions()) count++;
        if (pizza.getPineapple()) count++;
        if (pizza.getTomato()) count++;
        return count;
    }
}
