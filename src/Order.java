import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Pizza> pizzas;
    private final PricingStrategy pricingStrategy;
    private final String customerName;


    public Order(Pizza pizza, PricingStrategy pricingStrategy){
        this(List.of(pizza),pricingStrategy,"Неизвестный");
    }
    public Order(List<Pizza> pizzas,PricingStrategy pricingStrategy){
        this(pizzas,pricingStrategy,"Неизвестный");
    }
    public Order(List<Pizza> pizzas, PricingStrategy pricingStrategy, String customerName){
        this.pizzas=pizzas;
        this.pricingStrategy=pricingStrategy;
        this.customerName=customerName;
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Pizza pizza : pizzas) {
            total += pricingStrategy.calculate(pizza);
        }
        return total;
    }
    public String getFormattedPrice() {
        return String.format("%.2f ₽", getTotalPrice());
    }
    public List<Pizza> getPizzas() {
        return new ArrayList<>(pizzas);
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public String getCustomerName() {
        return customerName;
    }
    public int getPizzaCount() {
        return pizzas.size();
    }
    public Order addPizza(Pizza pizza) {
        List<Pizza> newPizzas = new ArrayList<>(pizzas);
        newPizzas.add(pizza);
        return new Order(newPizzas, pricingStrategy, customerName);
    }

    public Order removePizza(int index) {
        List<Pizza> newPizzas = new ArrayList<>(pizzas);
        newPizzas.remove(index);
        return new Order(newPizzas, pricingStrategy, customerName);
    }

    @Override
    public String toString() {
        return String.format("Заказ: Клиент: %s, пиццы: %s, оплата:%s, сумма: %s ", customerName,pizzas.toString(),pricingStrategy.getStrategyName(), getFormattedPrice() );
    }
}
