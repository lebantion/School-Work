import java.util.*;

//SeongRok Ha(Simon), 844926202
//CS&141, Assignment #7, 01/25/2018, Winter 18
//
// This program will print the parameter with stars

public class Assignment7
{
   public static void main(String[] orgs)
   {
      Scanner pad = new Scanner(System.in); // set pad to scan value
      
      System.out.print("Enter the Word : "); 
      String Word = pad.nextLine(); // Get word
      
      System.out.print("Enter the Number : ");
      int star = pad.nextInt(); // Get number of index
      
      PadString(Word, star); // call function
        
   }  
   public static void PadString(String word,int number)
   {
      int number_star = number - word.length(); // set number_star to add star
      for ( int i = 0 ; i < number_star ; i++) // use for loop to add star to word
      {
         word += '*';
      }
      
      System.out.print(word); // printout padstring
   } 
   
}