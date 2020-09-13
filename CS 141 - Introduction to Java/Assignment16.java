import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

// CS&141, Winter 18, SeongRok Ha(844926202)
// Assignment14
//
// This program will open file, and calculate all people's wage except taxes

public class Assignment16
{
   public static void main(String[] args)
   {
      Scanner word = new Scanner(System.in);
      String[] Array = new String[10]; // make array to put String
      
      for ( int i = 1 ; i <= 10 ; i++) // get word by for loop and put it in to array
      {
         System.out.print("Please type in word #" + i + " : ");
         String token = word.next();
         if ( i % 2 == 0 )
         {
            token = token.toUpperCase(); // if the i is even number make it uppercase
            Array[i-1] = token; 
            
         }
         else
         {
            Array[i-1] = token;
         }
      }
      
      for ( int z = 0 ; z < 10 ; z++) // output all array by for loop
      {
         System.out.print(" " + Array[z]);
      }
      System.out.print(".");
      
      System.out.println();
      System.out.println(Arrays.toString(Array)); // output array by . Arrays.toString()
      
      
   }
}