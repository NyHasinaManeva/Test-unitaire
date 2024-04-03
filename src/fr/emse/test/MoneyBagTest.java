package fr.emse.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyBagTest {
    private Money f12CHF;
    private Money f14CHF;
    private Money f7USD;
    private Money f21USD;
    private MoneyBag fMB1;
    private MoneyBag fMB2;

    @Before
    public void setUp() {
        f12CHF = new Money(12, "CHF");
        f14CHF = new Money(14, "CHF");
        f7USD = new Money(7, "USD");
        f21USD = new Money(21, "USD");
        fMB1 = new MoneyBag(f12CHF, f7USD);
        fMB2 = new MoneyBag(f14CHF, f21USD);
    }

    @Test
    public void testBagEquals() {
        assertFalse(fMB1.equals(null)); // Corrected to assertFalse
        assertEquals(fMB1, fMB1);
        assertFalse(fMB1.equals(f12CHF)); // Corrected to assertFalse
        assertFalse(f12CHF.equals(fMB1)); // Corrected to assertFalse
        assertFalse(fMB1.equals(fMB2)); // Corrected to assertFalse
    }
    @Test
    public void testMixedSimpleAdd() {
    // [12 CHF] + [7 USD] == {[12 CHF][7 USD]}
    Money bag[] = { f12CHF, f7USD };
    MoneyBag expected = new MoneyBag(bag);
    assertEquals(expected, f12CHF.add(f7USD));
    }
    
//    @Test
//    public void testBagSimpleAdd() {
//        // Adding a MoneyBag to a simple Money
//        // For example, adding {[12 CHF][7 USD]} to [7 USD] should result in {[12 CHF][7 USD][7 USD]}
//        MoneyBag bag = new MoneyBag(f12CHF, f7USD); // Assuming this constructor exists
//        MoneyBag expected = new MoneyBag(f12CHF, f7USD, f7USD); // Assuming this constructor exists
//        assertEquals(expected, bag.add(f7USD));
//    }
//    
//    @Test
//    public void testSimpleBagAdd() {
//        // Ajouter un Money simple à un MoneyBag
//        // Par exemple, ajouter [7 USD] à {[12 CHF][7 USD]} devrait donner {[12 CHF][7 USD][7 USD]}
//        MoneyBag expected = new MoneyBag(f12CHF, f7USD, f7USD); // Supposons que ce constructeur existe
//        assertEquals(expected, fMB1.add(f7USD));
//    }
//
//    
//    @Test
//    public void testBagBagAdd() {
//        // Ajouter deux MoneyBags ensemble
//        // Par exemple, ajouter {[12 CHF][7 USD]} à {[14 CHF][21 USD]} devrait donner {[12 CHF][7 USD][14 CHF][21 USD]}
//        MoneyBag expected = new MoneyBag(f12CHF, f7USD, f14CHF, f21USD); // Supposons que ce constructeur existe
//        assertEquals(expected, fMB1.add(fMB2));
//    }
    
    @Test
    public void testSimplify() {
        // {[12 CHF][7 USD]} + [-12 CHF] == [7 USD]
        Money expected = new Money(7, "USD");
        assertEquals(expected, fMB1.add(new Money(-12, "CHF")).simplify());
    }




}
