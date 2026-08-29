public class PizzaValidator extends OrderValidator{
    @Override
    public void validate(Order order) throws ValidationException {
        if (order.getPizzaCount() == 0) {
            throw new ValidationException(" Заказ должен содержать хотя бы одну пиццу!");
        }

        System.out.println("Проверка пройдена: в заказе есть " +
                order.getPizzaCount() + " пиццы");


        validateNext(order);
    }
}
