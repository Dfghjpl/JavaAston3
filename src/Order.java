import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        return String.format("Заказ: Клиент: %s, \nпиццы: %s, \nоплата:%s, сумма: %s ", customerName,pizzas.toString(),pricingStrategy.getStrategyName(), getFormattedPrice() );
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if ((obj==null)||(getClass()!=obj.getClass())) return false;
        Order order=(Order) obj;
        return Objects.equals(pizzas,order.pizzas)&&
                Objects.equals(pricingStrategy,order.pricingStrategy)&&
                Objects.equals(customerName,order.customerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pizzas,pricingStrategy,customerName);
    }
}
