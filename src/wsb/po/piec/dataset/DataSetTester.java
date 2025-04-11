package wsb.po.piec.dataset;

import java.util.Scanner;

/**
   This program computes the average and maximum of a set
   of input values.
*/
public class DataSetTester
{  
   public static void main(String[] args)
   {  
      DataSet data = new DataSet();
      data.add(new BankAccount(100));
      data.add(new BankAccount(5.5));
      data.add(new BankAccount(20));
      data.add(new BankAccount(12.34));

      System.out.println("Average = " + data.getAverage());
      System.out.println("Maximum = " + data.getMaximum());
   }
}
