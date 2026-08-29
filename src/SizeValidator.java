public class SizeValidator extends OrderValidator{

    @Override
    public void validate(Order order) throws ValidationException {
        for (Pizza pizza : order.getPizzas()) {
            // Если пицца большая И без начинки
            if (pizza.getSize() == Pizza.Size.LARGE && countIngredients(pizza) == 0) {
                throw new ValidationException(
                        "Большая пицца не может быть без начинки!"
                );
            }
        }

        System.out.println("Проверка пройдена: все большие пиццы имеют начинку");

        // Передаем дальше по цепочке
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
