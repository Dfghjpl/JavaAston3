import java.util.List;

public class OrderService {
    private final OrderValidator validatorChain;

    public OrderService(OrderValidator validatorChain) {
        this.validatorChain = validatorChain;
    }
    public Order createOrder(Pizza pizza, PricingStrategy strategy)
            throws ValidationException {
        Order order = new Order(pizza, strategy);
        return createOrder(order);
    }
    public Order createOrder(List<Pizza> pizzas, PricingStrategy strategy)
            throws ValidationException {
        Order order = new Order(pizzas, strategy);
        return createOrder(order);
    }
    public Order createOrder(Order order) throws ValidationException {
        // Запускаем цепочку валидации
        validatorChain.validate(order);

        System.out.println("Заказ принят!");
        return order;
    }
}
