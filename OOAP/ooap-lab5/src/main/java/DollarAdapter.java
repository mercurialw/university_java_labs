public class DollarAdapter implements IModernPaymentGateway {
    private OldDollarSystem oldSystem;

    public DollarAdapter() {
        this.oldSystem = new OldDollarSystem();
    }

    @Override
    public void pay(float amount, String currency) {
        if ("USD".equals(currency)) {
            oldSystem.payDollar(amount);
        } else {
            double convertedAmount = CurrencyConverter.convert(amount, currency, "USD");
            oldSystem.payDollar((float) convertedAmount);
        }
    }
}