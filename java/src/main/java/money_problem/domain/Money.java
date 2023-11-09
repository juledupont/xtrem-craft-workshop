package money_problem.domain;

public class Money {

    Currency currency;
    Double amount;

    public Money(double moneyAmount, Currency currency) throws NegativeAmountException {
        this.currency = currency;
        if(moneyAmount < 0){
            throw new NegativeAmountException(moneyAmount);
        } else {
            this.amount = moneyAmount;
        }
    }

    public void addMoneyInSameCurrency(Money money2) throws DifferentCurrenciesAmountException {
        if (this.currency != money2.currency) {
            throw new DifferentCurrenciesAmountException(this.currency, money2.currency);
        } else {
            this.amount = MoneyCalculator.add(this.amount, this.currency, money2.amount);
        }
    }

    public double getAmount() {
        return this.amount;
    }

    public void multiplyMoney(int factor) throws NegativeAmountException {
        if (factor < 0) {
            throw new NegativeAmountException(factor * this.amount);
        } else {
            this.amount = MoneyCalculator.times(this.amount, this.currency, factor);
        }
    }

    public void divideMoney(int quotient) throws NegativeAmountException, ArithmeticException {
        if (quotient <= 0) {
            throw new ArithmeticException("Division by zero or negative quotient is not allowed.");
        }else {
            this.amount = MoneyCalculator.divide(this.amount, this.currency, quotient);
        }
    }
}
