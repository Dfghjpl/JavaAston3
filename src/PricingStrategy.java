public interface PricingStrategy {
    double calculate( Pizza pizza);

    default  String getStrategyName(){
        return this.getClass().getSimpleName();
    }
}
