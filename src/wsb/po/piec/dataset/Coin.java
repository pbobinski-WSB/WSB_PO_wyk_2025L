package wsb.po.piec.dataset;

/**
   A coin with a monetary value.
*/
public class Coin implements Measurable
{
   private double value;
   private String name;

   /**
      Constructs a coin.
      @param aValue the monetary value of the coin
      @param aName the name of the coin
   */
   public Coin(double aValue, String aName) 
   { 
      value = aValue; 
      name = aName;
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

   @Override
   public String toString() {
      return "Coin{" +
              "value=" + value +
              ", name='" + name + '\'' +
              '}';
   }

   @Override
   public double getMeasure() {
      return getValue();
   }
}
