package wsb.po.dziewiec.invoice;

/**
   Describes a mailing address.
*/
public class Address
{  
   private String name;
   private String street;
   private String city;
   private String state;
   private String zip;

   /**
      Constructs a mailing address. 
      @param name the recipient name
      @param street the street
      @param city the city
      @param state the two-letter state code
      @param zip the ZIP postal code
   */
   public Address(String name, String street,
         String city, String state, String zip)
   {  
      this.name = name;
      this.street = street;
      this.city = city;
      this.state = state;
      this.zip = zip;
   }   

   /**
      Formats the address.
      @return the address as a string with three lines
   */
   public String format()
   {
      return name + "\n" + street + "\n"
              + city + ", " + state + " " + zip;
   }
}

