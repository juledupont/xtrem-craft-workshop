package money_problem.domain;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private int amount;
    private Map<Currency, Double> amountByCurrency;

    public Portfolio(int amount) {
        this.amount = amount;
        amountByCurrency = new HashMap<>();
    }

    public String evaluate(Currency currency) {
        return this.amount + " " + currency.name();
    }

    public void add(double amount, Currency currency) {
        amountByCurrency.put(currency, amountByCurrency.getOrDefault(currency, 0d) + amount);
    }

    public Map<Currency, Double> getContent() {
        return amountByCurrency;
    }
}
