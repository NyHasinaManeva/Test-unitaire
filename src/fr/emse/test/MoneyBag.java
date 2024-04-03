package fr.emse.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class MoneyBag implements IMoney {
	private Vector<Money> fMonies = new Vector<Money>();
	private List<Money> monies;
	
	MoneyBag(Money m1, Money m2) {
	appendMoney(m1);
	appendMoney(m2);
	}
	
	public MoneyBag add(Money money) {
        List<Money> newMonies = new ArrayList<>(this.monies);
        newMonies.add(money);
        return new MoneyBag(newMonies.toArray(new Money[0]));
    }
	

	MoneyBag(Money bag[]) {
	for (int i = 0; i < bag.length; i++)
	appendMoney(bag[i]);
	}
	
	public MoneyBag(Money f12chf, Money f7usd, Money f7usd2) {
        this.monies = new ArrayList<>();
        this.monies.add(f12chf);
       this.monies.add(f7usd);
        this.monies.add(f7usd2);
    }


	public MoneyBag(Money f12chf, Money f7usd, Money f14chf, Money f21usd) {
	    this.monies = new ArrayList<>();
	    this.monies.add(f12chf);
	    this.monies.add(f7usd);
	    this.monies.add(f14chf);
	    this.monies.add(f21usd);
	}


	private void appendMoney(Money m) {
	if (fMonies.isEmpty()) {
	fMonies.add(m);
	} else {
	int i = 0;
	while ((i < fMonies.size())
	&& (!(fMonies.get(i).currency().equals(m.currency()))))
	i++;
	if (i >= fMonies.size()) {
	fMonies.add(m);
	} else {
	fMonies.set(i, new Money(fMonies.get(i).amount() +
	m.amount(),m.currency()));
	}
	}
	}
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        MoneyBag moneyBag = (MoneyBag) obj;
        return Objects.equals(fMonies, moneyBag.fMonies);
    }
	
	@Override
	public IMoney add(IMoney m) {
		return m.addMoneyBag(this);
		}

	@Override
	public IMoney addMoney(Money money) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMoney addMoneyBag(MoneyBag moneyBag) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public IMoney simplify() {
	    if (monies.size() == 1) {
	        return monies.get(0);
	    }
	    return this;
	}

	}
