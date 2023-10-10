package money_problem.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MoneyTest {

    @Test
    void testBeAddedToAnotherMoneyInSameCurreny() throws NegativeAmountException {
        // Arrange
        double moneyEURAmount = 10.0;
        Money moneyEUR = new Money(moneyEURAmount, Currency.EUR);

        double moneyEURAmount2 = 5.0;
        Money moneyEUR2 = new Money(moneyEURAmount2, Currency.EUR);

        // Act
        moneyEUR.addMoneyInSameCurrency(moneyEUR2);

        // Assert
        assertThat(moneyEUR.getAmount()).isEqualTo(moneyEURAmount + moneyEURAmount2);

        /*
         // Arrange
         Money moneyEUR = new Money(moneyEURAmount, Currency.EUR);
         double moneyUSDAmount = 5.0;
         Money moneyUSD = new Money(moneyUSDAmount, Currency.USD);

         //Act
         moneyEUR.addMoneyInSameCurrency(moneyUSD);
         */
    }

    @Test
    void testCreateMoneyWithNegativeAmount() {
        // Assert
        assertThrows(NegativeAmountException.class, () -> {
            Money moneyEUR = new Money(-15, Currency.EUR);
        });
    }

    @Test
    void testBeMultipliedByNumeralValue() throws NegativeAmountException {
        // Arrange
        double moneyEURAmount = 15.0;
        Money moneyEUR = new Money(moneyEURAmount, Currency.EUR);
        int factor = 2;

        // Act
        moneyEUR.multiplyMoney(factor);

        // Asserts
        assertThat(moneyEUR.getAmount()).isEqualTo(moneyEURAmount * factor);
    }

    @Test
    void testBeDividedByNumerateValue() throws NegativeAmountException {
        // Arrange
        double moneyEURAmount = 15.0;
        Money moneyEUR = new Money(moneyEURAmount, Currency.EUR);
        int quotient = 2;

        // Act
        moneyEUR.divideMoney(quotient);

        // Asserts
        assertThat(moneyEUR.getAmount()).isEqualTo(moneyEURAmount / quotient);
    }
}
