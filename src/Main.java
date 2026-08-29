
void main() {

    Pizza pizza=new Pizza.Bilder(Pizza.Size.MEDIUM)
            .bacon()
            .chesse()
            .olives()
            .bild();
    //System.out.println(pizza);
    Pizza pizza1=new Pizza.Bilder(Pizza.Size.SMALL)
            .pineapple()
            .olives()
            .bild();

    Order order=new Order(pizza,new BirthdayPricing());
    System.out.println(order.toString());
    List<Pizza> pizzas= List.of(pizza, pizza1);
    Order order1=new Order(pizzas,new BirthdayPricing(),"Виктория");

    OrderValidator validator = new PizzaValidator();
    validator.setNext(new IngredientsValidator())
            .setNext(new SizeValidator());
    OrderService orderService=new OrderService(validator);

    try{
        Pizza pizza2=new Pizza.Bilder(Pizza.Size.LARGE)
                .olives()
                .bacon()
                .bild();
        Order order2=orderService.createOrder(pizza2,new RegularPricing());
        System.out.println(order);
    }catch (ValidationException e){
        System.out.println("Ошибка: "+e.getMessage());
    }
}
