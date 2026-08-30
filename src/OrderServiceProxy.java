import java.util.List;

public abstract class OrderServiceProxy extends OrderService {

    protected OrderService realOrderService;

    public OrderServiceProxy(OrderService realOrderService) {
        super(realOrderService.getValidatorChain());
        this.realOrderService = realOrderService; // Может быть null
    }

    public void setRealOrderService(OrderService realOrderService) {
        this.realOrderService = realOrderService;
    }

    @Override
    public Order createOrder(Pizza pizza, PricingStrategy strategy) throws ValidationException {

        return realOrderService.createOrder(pizza, strategy);

    }

    @Override
    public Order createOrder(List<Pizza> pizzas, PricingStrategy strategy) throws ValidationException {

        return realOrderService.createOrder(pizzas, strategy);

    }

    @Override
    public Order createOrder(Order order) throws ValidationException {

        return realOrderService.createOrder(order);

    }
}
