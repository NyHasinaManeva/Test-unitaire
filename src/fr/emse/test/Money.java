package fr.emse.test;

public class Money implements IMoney {
    private int fAmount;
    private String fCurrency;

    public Money(int amount, String currency) {
        fAmount = amount;
        fCurrency = currency;
    }

    public int amount() {
        return fAmount;
    }

    public String currency() {
        return fCurrency;
    }

    @Override
    public IMoney add(IMoney m) {
        return m.addMoney(this);
    }

    @Override
    public IMoney addMoney(Money money) {
        if (money.currency().equals(currency())) {
            return new Money(amount() + money.amount(), currency());
        } else {
            return new MoneyBag(this, money);
        }
    }

    @Override
    public IMoney addMoneyBag(MoneyBag moneyBag) {
        MoneyBag newMoneyBag = new MoneyBag(this, moneyBag);
        return newMoneyBag.simplify();
    }
}
