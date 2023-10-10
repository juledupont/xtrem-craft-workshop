public class BankBuilder
{
    public Cuurency pivotCurrency;
    public Map<String, Double> exchangeRates;
}

public class BankTestDataBuilder {

    private Currency pivotCurrency;
    private Map<String, Double> exchangeRates;

    public static BankTestDataBuilder BankTestBuilder
        => new CreateBankBuilder();

    public BankTestDataBuilder withPivotCurrency(Currency pivot)
    {
        pivotCurrency = pivot;
        return this;
    }

    public BankTestDataBuilder withExchangeRates(Map<String, Double> exchange)
    {
        exchangeRates = exchange;
        return this;
    }

    public BankTestDataBuilder Build()
    {
        return new BankBuilder(pivotCurrency, exchangeRates);
    }

    @Test
    public testBankBuilder(){
        return BankBuilder(pivotCurrency, exchangeRates);
    }
}