public class RubleAdapter implements IModernPaymentGateway {
    private OldRubleSystem oldSystem;

    public RubleAdapter() {
        this.oldSystem = new OldRubleSystem();
    }

    @Override
    public void pay(float amount, String currency) {
        if ("RUB".equals(currency)) {
            oldSystem.payRubles(amount);
        } else {
            double convertedAmount = CurrencyConverter.convert(amount, currency, "RUB");
            oldSystem.payRubles((float) convertedAmount);
        }
    }
}