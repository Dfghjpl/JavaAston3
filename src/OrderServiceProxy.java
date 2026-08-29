import java.util.List;

public abstract class OrderServiceProxy extends OrderService{

    protected OrderService realOrderService;

    public OrderServiceProxy(OrderValidator validatorChain, OrderService realOrderService) {
        super(validatorChain);
        this.realOrderService = realOrderService; // Может быть null
    }

    public void setRealOrderService(OrderService realOrderService) {
        this.realOrderService = realOrderService;
    }
    @Override
    public Order createOrder(Pizza pizza, PricingStrategy strategy) throws ValidationException {
        if (realOrderService != null) {
            return realOrderService.createOrder(pizza, strategy);
        }
        return super.createOrder(pizza, strategy);
    }

    @Override
    public Order createOrder(List<Pizza> pizzas, PricingStrategy strategy) throws ValidationException {
        if (realOrderService != null) {
            return realOrderService.createOrder(pizzas, strategy);
        }
        return super.createOrder(pizzas, strategy);
    }

    @Override
    public Order createOrder(Order order) throws ValidationException {
        if (realOrderService != null) {
            return realOrderService.createOrder(order);
        }
        return super.createOrder(order);
    }
}
