package money_problem.domain;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private int amount;

    public Portfolio(int amount) {
        this.amount = amount;
    }

    public String evaluate(Currency currency) {
        return this.amount + " " + currency.name();
    }

    public void add(double amount, Currency currency) {

    }

    public Map<Currency, Double> getContent() {
        return new HashMap<>();
    }
}
