package wsb.po.piec.cashregister;

/**
   A coin with a monetary value.
*/
public class Coin
{
   private double value;
   private String name;

   /**
      Constructs a coin.
      @param value the monetary value of the coin
      @param name the name of the coin
   */
   public Coin(double value, String name)
   { 
      this.value = value;
      this.name = name;
   }

   /**
      Gets the coin value.
      @return the value
   */
   public double getValue() 
   {
      return value;
   }

   /**
      Gets the coin name.
      @return the name
   */
   public String getName() 
   {
      return name;
   }


}
