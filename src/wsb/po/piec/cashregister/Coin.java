package wsb.po.piec.cashregister;

/**
   A coin with a monetary value.
*/
public enum Coin
{
   PENNY(1),
   NICKEL(5),
   DIME(10),
   QUARTER(25),
   DOLLAR(100);

   private final double value;

   /**
      Constructs a coin.
      @param centsValue the monetary value of the coin
   */
   Coin(int centsValue)
   { 
      this.value = centsValue/100.0;
   }

   /**
      Gets the coin value.
      @return the value
   */
   public double getValue() 
   {
      return value;
   }



}
