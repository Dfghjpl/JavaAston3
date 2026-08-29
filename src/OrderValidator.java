public abstract class OrderValidator {

    protected OrderValidator next;

    public OrderValidator setNext(OrderValidator next) {
        this.next = next;
        return next;
    }

    public abstract void validate(Order order) throws ValidationException;

    protected void validateNext(Order order) throws ValidationException {
        if (next != null) {
            next.validate(order);
        }
    }

}
