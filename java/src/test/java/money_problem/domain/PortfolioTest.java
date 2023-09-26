package money_problem.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PortfolioTest {
    @Test
    void testShouldEvaluateAmountOfEmptyPortfolioInEur() {
        // Arrange
        Portfolio portfolio = new Portfolio(0);

        // Act
        String amount = portfolio.evaluate(Currency.EUR);

        // Assert
        assertThat(amount).isEqualTo("0 EUR");

    }

    @Test
    void testAddMoneyToPortfolio() {
        Portfolio portfolio = new Portfolio(0);
        double eurAmount = 5;
        double usdAmount = 10;
        Currency eurCurrency = Currency.EUR;
        Currency usdCurrency = Currency.USD;

        portfolio.add(eurAmount, eurCurrency);
        Map<Currency, Double> result = new HashMap<>();
        result.put(eurCurrency, eurAmount);

        assertThat(portfolio.getContent().isEmpty()).isEqualTo(false);
        assertThat(portfolio.getContent()).isEqualTo(result);

        portfolio.add(usdAmount, usdCurrency);
        result.put(usdCurrency, usdAmount);

        assertThat(portfolio.getContent()).isEqualTo(result);

        portfolio.add(usdAmount, usdCurrency);
        result.put(usdCurrency, usdAmount);

        assertThat(portfolio.getContent()).isEqualTo(result);
    }

    @Test
    void testTotalAmountInPortfolio() {

    }
}