public class YandexDeliveryAPI {

    public String createdOrder(YandexOrderRequest request){
        System.out.println("\nСоздан заказ: "+ request);
        return "YANDEX-ORDER-"+System.currentTimeMillis();
    }
}
class YandexOrderRequest {
    private final String clientName;
    private final String address;
    private final String pizzas;
    private final double totalPrice;

    public YandexOrderRequest(String clientName, String address, String pizzas, double totalPrice){
        this.clientName=clientName;
        this.address=address;
        this.pizzas=pizzas;
        this.totalPrice=totalPrice;
    }

    @Override
    public String toString() {
        return "YandexOrderRequest{ clientName='"+clientName+" address='"+address+" pizzas='"+pizzas+" totalPrice="+totalPrice;
    }
}
