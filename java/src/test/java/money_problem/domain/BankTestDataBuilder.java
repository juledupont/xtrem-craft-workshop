package money_problem.domain;

import java.util.HashMap;
import java.util.Map;

public class BankTestDataBuilder {

    private Currency pivotCurrency;
    private Map<String, Double> exchangeRates;

    public static BankTestDataBuilder BankTestBuilder() {
        return new BankTestDataBuilder();
    }

    public BankTestDataBuilder withPivotCurrency(Currency pivot) {
        pivotCurrency = pivot;
        return this;
    }

    public BankTestDataBuilder withExchangeRates(Map<String, Double> exchange) {
        exchangeRates = exchange;
        return this;
    }

    public Bank Build() {
        return new Bank(exchangeRates, pivotCurrency);
    }
}
