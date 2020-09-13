import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

// CS&141, Winter 18, SeongRok Ha(844926202)
// Assignment14
//
// This program will open file, and calculate all people's wage except taxes

public class Assignment15
{
   public static void main(String[] args)
   {
      Scanner word = new Scanner(System.in);
      int[] sentence = 10;
      
      for ( int i = 0 ; i < 10 ; i++)
      {
         System.out.print("Please type in word #" + (i + 1) + " : ");
         sentence += word.nextLine(); 
      }
      
   }
}