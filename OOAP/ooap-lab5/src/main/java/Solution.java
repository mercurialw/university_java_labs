public class Solution {
    public static void main(String[] args) {
        IModernPaymentGateway rubAdapter = new RubleAdapter();
        IModernPaymentGateway usdAdapter = new DollarAdapter();
        IModernPaymentGateway eurAdapter = new EuroAdapter();

        rubAdapter.pay(1000, "RUB");
        rubAdapter.pay(100, "USD");// Конвертация
        usdAdapter.pay(50, "EUR");// Конвертация
        eurAdapter.pay(1000, "RUB");// Конвертация
    }
}