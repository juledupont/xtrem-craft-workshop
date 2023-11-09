package money_problem.domain;

public class NegativeAmountException extends Exception {
    public NegativeAmountException(Double amount) {
        super(String.format("Cannot have negative amount, found %s", amount));
    }
}
