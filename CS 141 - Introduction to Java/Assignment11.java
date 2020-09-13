import java.util.*;


// CS&141, Winter 18, SeongRok Ha(844926202)
// Assignment #11
//
// This program will print out formula of the number which is factor of 2

public class Assignment11
{  
   public static void main(String[] orgs)
   {
      Scanner num = new Scanner(System.in); // call Scanner
      
      System.out.println("What number do you want to see the factors of 2? : "); // get number for getting number
      int x = num.nextInt();
      
      ShowTwos(x); // call function
      
   }
   
   public static void ShowTwos(int x)
   {
      String formula;
      int number, first_num;
      first_num = x; // set up first_number to print out later
      number = 0; // initializing to use
      formula = ""; // initializing to use
      while ( x % 2 == 0 ) // use while loop to get how many times the number divides and get the number which cannot be divided by 2
      {
         number += 1;  // count times
         x = x / 2; // divide number by 2
      }
      
      for ( int i = 0 ; i < number ; i++)
      {
         formula += "2"; // put 2 and * in formula.
         formula += " *";
      }
      formula += x; // and add the number which is lefted
      System.out.println(first_num + " = " + formula); // output result
   }
}
