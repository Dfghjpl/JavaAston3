public class PizzaDelivery implements DeliveryService{

    @Override
    public void deliver(Order order) {
        System.out.println("\nСвоя доставка. Клиенту: "+order.getCustomerName());
        System.out.println("\nПицц в заказе: "+order.getPizzaCount());
        System.out.println("\nСумма заказа: "+order.getFormattedPrice());

    }
}
