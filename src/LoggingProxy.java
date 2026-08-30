import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.zip.DataFormatException;

public class LoggingProxy extends OrderServiceProxy {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public LoggingProxy( OrderService realOrderService) {
        super( realOrderService);
    }

    @Override
    public Order createOrder(Pizza pizza, PricingStrategy strategy) throws ValidationException {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println(timestamp + " : createOrder");

        long startTime = System.currentTimeMillis();
        try {
            Order result = super.createOrder(pizza, strategy);
            long duration = System.currentTimeMillis() - startTime;
            System.out.println(timestamp + " : createOrder выполнен за" + duration);
            return result;
        } catch (ValidationException e) {
            System.out.println(timestamp + " : createOrder ошибка" + e.getMessage());
            throw e;
        }
    }

    @Override
    public Order createOrder(List<Pizza> pizzas, PricingStrategy strategy) throws ValidationException {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println(timestamp + " : createOrder");

        long startTime = System.currentTimeMillis();
        try {
            Order result = super.createOrder(pizzas, strategy);
            long duration = System.currentTimeMillis() - startTime;
            System.out.println(timestamp + " : createOrder выполнен за" + duration);
            return result;
        } catch (ValidationException e) {
            System.out.println(timestamp + " : createOrder ошибка" + e.getMessage());
            throw e;
        }
    }

    @Override
    public Order createOrder(Order order) throws ValidationException {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println(timestamp + " : createOrder");

        long startTime = System.currentTimeMillis();
        try {
            Order result = super.createOrder(order);
            long duration = System.currentTimeMillis() - startTime;
            System.out.println(timestamp + " : createOrder выполнен за" + duration);
            return result;
        } catch (ValidationException e) {
            System.out.println(timestamp + " : createOrder ошибка" + e.getMessage());
            throw e;
        }
    }
}
