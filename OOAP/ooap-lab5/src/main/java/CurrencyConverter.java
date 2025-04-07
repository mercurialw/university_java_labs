import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private static final Map<String, Double> rates = new HashMap<>();
    static {
        rates.put("RUB", 1.0);
        rates.put("USD", 85.0);
        rates.put("EUR", 95.0);
    }
    public static double convert(double amount, String from, String to) {
        if (from.equals(to)) return amount;
        double rateFrom = rates.get(from);
        double rateTo = rates.get(to);
        return (amount * rateFrom) / rateTo;
    }
}
