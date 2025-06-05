package wsb.po.dziewiec.invoice;

/**
   Describes a quantity of an article to purchase.
*/
public class LineItem
{  
   private int quantity;
   private Product theProduct;

   /**
      Constructs an item from the product and quantity.
      @param product the product
      @param quantity the item quantity
   */
   public LineItem(Product product, int quantity)
   {  
      theProduct = product;
      this.quantity = quantity;
   }
   
   /**
      Computes the total cost of this line item.
      @return the total price
   */
   public double getTotalPrice()
   {

      return theProduct.getPrice() * quantity;
   }
   
   /**
      Formats this item.
      @return a formatted string of this item
   */
   public String format()
   {
      return String.format("%-30s%8.2f%5d%8.2f",
              theProduct.getDescription(), theProduct.getPrice(),
              quantity, getTotalPrice());
   }
}
