public class YandexDeliveryAdapter implements DeliveryService{

    private  final  YandexDeliveryAPI yandexAPI;
    public YandexDeliveryAdapter(YandexDeliveryAPI yandexAPI){
        this.yandexAPI=yandexAPI;
    }

    @Override
    public void deliver(Order order) {
        YandexOrderRequest request= new YandexOrderRequest(
                order.getCustomerName(),
                "г. Москва, ул. Приемная, д. 1",
                order.getPizzas().toString(),
                order.getTotalPrice()
        );
        String orderId=yandexAPI.createdOrder(request);
        System.out.println("Заказ передан в Яндекс.Еду: "+orderId);
    }
}
