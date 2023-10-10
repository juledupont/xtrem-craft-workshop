package money_problem.domain;

public class NegativeAmountException extends Exception {
    public NegativeAmountException(String message) {
        super("Cannot have negative amount");
    }
}
