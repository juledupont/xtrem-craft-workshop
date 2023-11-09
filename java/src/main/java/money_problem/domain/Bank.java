package money_problem.domain;

import java.util.HashMap;
import java.util.Map;

public final class Bank {
    private final Map<String, Double> exchangeRates;
    private final Currency pivotCurrency;

    public Bank(Map<String, Double> exchangeRates, Currency pivotCurrency) {
        this.exchangeRates = exchangeRates;
        this.pivotCurrency = pivotCurrency;
    }

    public static Bank createBankWithExchangeRate(Currency baseCurrency, Currency pivotCurrency, double rate) {
        Bank bank = new Bank(new HashMap<>(), pivotCurrency);
        bank.addExchangeRate(baseCurrency, pivotCurrency, rate);

        return bank;
    }

    public void addExchangeRate(Currency baseCurrency, Currency quoteCurrency, double rate) {
        //Condition quote Currency must be pivot
        if (this.pivotCurrency != quoteCurrency){
            throw new IllegalArgumentException("Quote must be pivot currency");
        }
        exchangeRates.put(baseCurrency + "->" + quoteCurrency, rate);
    }

    public double convertBaseAmountToQuote(double baseAmount, Currency baseCurrency, Currency quoteCurrency) throws MissingExchangeRateException {
        //if the base is equal to the quote return the same amount
        double res = 0;
        if (baseCurrency == quoteCurrency){
            res = baseAmount;
        } else {
            // if both base and quote are present in the exchange rates
            if (((exchangeRates.containsKey(baseCurrency + "->" + pivotCurrency) || baseCurrency == pivotCurrency))
                    && (exchangeRates.containsKey(quoteCurrency + "->" + pivotCurrency) || baseCurrency == pivotCurrency)){

                if (baseCurrency  != pivotCurrency && quoteCurrency != pivotCurrency){
                    res = (baseAmount * exchangeRates.get(baseCurrency + "->" + pivotCurrency))*1/(baseAmount * exchangeRates.get(quoteCurrency + "->" + pivotCurrency));
                }
                if (baseCurrency == pivotCurrency){
                    res = 1/(baseAmount * exchangeRates.get(quoteCurrency + "->" + pivotCurrency));
                } else if (quoteCurrency == pivotCurrency){
                    res =  baseAmount * exchangeRates.get(baseCurrency + "->" + pivotCurrency);
                }

            } else {
                throw new MissingExchangeRateException(baseCurrency, quoteCurrency);
            }
        }
        return res;
    }
}