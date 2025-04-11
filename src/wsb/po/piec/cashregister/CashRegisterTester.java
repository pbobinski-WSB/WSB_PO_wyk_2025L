package wsb.po.piec.cashregister;

/**
   This class tests the CashRegister class.
*/
public class CashRegisterTester
{
   public static void main(String[] args)
   {
      CashRegister register = new CashRegister();

      register.recordPurchase(0.75);
      register.recordPurchase(1.50);
      register.enterPayment(2, Coin.DOLLAR);
      register.enterPayment(5, Coin.DIME);
      System.out.print("Change: ");
      double change = register.giveChange();
      System.out.println(change);
      System.out.println("Expected: 0.25");
      System.out.print("In PLN: ");
      System.out.println(Exchange.usd2pln(change));

      register.recordPurchase(2.25);
      register.recordPurchase(19.25);
      register.enterPayment(23, Coin.DOLLAR);
      register.enterPayment(2, Coin.QUARTER);
      System.out.print("Change: ");
      System.out.println(register.giveChange());
      System.out.println("Expected: 2.0");
   }
}
