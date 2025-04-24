package wsb.po.szesc.collections;

import wsb.po.piec.dataset.Measurable;

import java.util.Objects;

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



   /**/

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Coin)) return false;
      Coin coin = (Coin) o;
      return Double.compare(coin.getValue(), getValue()) == 0 && getName().equals(coin.getName());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getValue(), getName());
   }
   /**/

}
