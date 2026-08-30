void main() {

    Pizza pizza = new Pizza.Bilder(Pizza.Size.MEDIUM)
            .bacon()
            .chesse()
            .olives()
            .bild();
    //System.out.println(pizza);
    Pizza pizza1 = new Pizza.Bilder(Pizza.Size.SMALL)
            .pineapple()
            .olives()
            .bild();

    Order order = new Order(pizza, new BirthdayPricing());
    System.out.println(order.toString());
    List<Pizza> pizzas = List.of(pizza, pizza1);
    Order order1 = new Order(pizzas, new BirthdayPricing(), "Виктория");

    OrderValidator validator = new PizzaValidator();
    validator.setNext(new IngredientsValidator())
            .setNext(new SizeValidator());
    OrderService realService = new OrderService(validator);

    OrderService orderService = new LoggingProxy(realService);

    try {
        Pizza pizza2 = new Pizza.Bilder(Pizza.Size.LARGE)
                .olives()
                .bacon()
                .bild();
        Order order2 = orderService.createOrder(pizza2, new RegularPricing());
        System.out.println(order2);
    } catch (ValidationException e) {
        System.out.println("Ошибка: " + e.getMessage());
    }

    Order orderWithGift = new GiftWrapDecorator(order1);
    System.out.println(order.toString());
    System.out.println(orderWithGift.toString() + "\nИтого " + orderWithGift.getFormattedPrice());

    Order orderWithDelivery = new ExpressDeliveryDecorator(orderWithGift);
    System.out.println(orderWithDelivery.toString() + "\nИтого " + orderWithDelivery.getFormattedPrice());

    Order orderWithDrink = new DrinkDecorator(orderWithDelivery);
    System.out.println(orderWithDrink.toString() + "\nИтого " + orderWithDrink.getFormattedPrice());

    OrderService service = new LoggingProxy(orderService);

    Pizza pizza2 = new Pizza.Bilder(Pizza.Size.LARGE)
            .bacon()
            .pineapple()
            .tomato()
            .bild();
    try {
        service.createOrder(pizza2, new RegularPricing());
    } catch (Exception e) {
        System.out.println("\nОшибка" + e.getMessage());
    }

    Pizza pizza3 = new Pizza.Bilder(Pizza.Size.MEDIUM)
            .chesse()
            .tomato()
            .bild();
    OrderValidator validator1 = new PizzaValidator();
    validator1.setNext(new IngredientsValidator())
            .setNext(new SizeValidator());
    OrderService service1 = new OrderService(validator1);
    try {
        Order order6 = service.createOrder(pizza3, new RegularPricing());
        DeliveryService myDelivery = new PizzaDelivery();
        myDelivery.deliver(order);

        YandexDeliveryAPI yandexDeliveryAPI = new YandexDeliveryAPI();
        DeliveryService yandexDelivery = new YandexDeliveryAdapter(yandexDeliveryAPI);
        yandexDelivery.deliver(order);

    } catch (Exception e) {
        System.out.println("Ошибка: " + e.getMessage());
    }
}