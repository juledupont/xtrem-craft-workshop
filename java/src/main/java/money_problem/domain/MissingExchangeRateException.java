package money_problem.domain;

public class MissingExchangeRateException extends Exception {
    public MissingExchangeRateException(Currency currency1, Currency currency2) {
        super(String.format("Missing exchange rate to perform the operation %s->%s", currency1, currency2));
    }
}
