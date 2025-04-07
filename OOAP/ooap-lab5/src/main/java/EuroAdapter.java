public class EuroAdapter implements IModernPaymentGateway {
    private OldEuroSystem oldSystem;

    public EuroAdapter() {
        this.oldSystem = new OldEuroSystem();
    }

    @Override
    public void pay(float amount, String currency) {
        if ("EUR".equals(currency)) {
            oldSystem.payEuro(amount);
        } else {
            double convertedAmount = CurrencyConverter.convert(amount, currency, "EUR");
            oldSystem.payEuro((float) convertedAmount);
        }
    }
}