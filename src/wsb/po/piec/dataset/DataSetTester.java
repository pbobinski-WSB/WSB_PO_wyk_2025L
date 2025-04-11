package wsb.po.piec.dataset;

/**
   This program computes the average and maximum of a set
   of input values.
*/
public class DataSetTester
{  
   public static void main(String[] args)
   {
      Measurer m = new BankAccountMeasurer();
      DataSet data = new DataSet(m);
      data.add(new BankAccount(100,"a"));
      data.add(new BankAccount(5.5,"a"));
      data.add(new BankAccount(20,"b"));
      data.add(new BankAccount(12.34,"b"));

      System.out.println("Average = " + data.getAverage());
      System.out.println("Maximum = " + data.getMaximum());
      //System.out.println("Maximum type = " + data.getMaximum().getType());
      System.out.println("Maximum type = " + ((BankAccount)data.getMaximum()).getType());
      System.out.println("Maximum value in currency = " + data.getMeasurer().measure(data.getMaximum()));


      m = new CoinMeasurer();

      data = new DataSet(m);
      data.add(new Coin(100,"a"));
      data.add(new Coin(5.5,"b"));
      data.add(new Coin(20,"c"));
      data.add(new Coin(12.34,"d"));

      System.out.println("Average = " + data.getAverage());
      System.out.println("Maximum = " + data.getMaximum());
      //System.out.println("Maximum name = " + data.getMaximum().getName());
      System.out.println("Maximum name = " + ((Coin)data.getMaximum()).getName());
      System.out.println("Maximum value in currency = " + data.getMeasurer().measure(data.getMaximum()));


   }
}
