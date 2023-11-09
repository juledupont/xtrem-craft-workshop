package money_problem.domain;

public class DifferentCurrenciesAmountException extends Exception {
    public DifferentCurrenciesAmountException(Currency currency1, Currency currency2) {
        super(String.format("Cannot perform arithmetic operations on different currencies, found %s and %s",currency1, currency2));
    }
}
