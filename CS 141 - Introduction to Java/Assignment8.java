import java.util.*;

//SeongRok Ha(Simon), 844926202
//CS&141, Assignment #8, 01/26/2018, Winter 18
//
// This program will calculate compound of user

public class Assignment8
{
   public static void main(String[] orgs)
   {
      Scanner Money = new Scanner(System.in); // set Money to scan value
      
      System.out.print("How much would you start with? : ");
      double Start = Money.nextDouble(); // get Starting Money
      
      System.out.print("How much do you deposit each year? : ");
      double Deposit = Money.nextDouble(); // get Deposit Money for each year
      
      bank_Calculator(Start, Deposit); // call function
        
   }  
  
   public static void bank_Calculator(double start, double deposit)
   {
      double total, cal_interest;
      
      total = start; //initialize total
      
      for (int i = 1 ; i <= 25; i++) // use for loop to show each year
      {
         cal_interest = (6.5 / 100.0) * start; // calculate interest for each year
         total = cal_interest + start; // get total 
         
         String num = String.format("%.4f",cal_interest); // set interest show 4 index below point.
         
         System.out.println("Year #" + i + " Starts = " + start + " Interest = " + num + " Total = " + total); // output calculation
         
         start += (deposit + cal_interest); // add deposit and interest at the end
      }
      
      
      
   }
    
   
}