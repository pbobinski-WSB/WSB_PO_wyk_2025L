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
      Coin dollar = new Coin(1,"dollar");
      Coin dime = new Coin(0.1, "dime");
      register.enterPayment(2, dollar);
      register.enterPayment(5, dime);
      System.out.print("Change: ");
      System.out.println(register.giveChange());
      System.out.println("Expected: 0.25");

      register.recordPurchase(2.25);
      register.recordPurchase(19.25);
      register.enterPayment(23, dollar);
      Coin quarter = new Coin(0.25, "quarter");
      register.enterPayment(2, quarter);
      System.out.print("Change: ");
      System.out.println(register.giveChange());
      System.out.println("Expected: 2.0");
   }
}
