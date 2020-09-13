import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

// CS&141, Winter 18, SeongRok Ha(844926202)
// Assignment17
//
// This program will count vowel if the user input word or sentence.

public class Assignment17
{
   public static void main(String[] args)
   {
      Scanner word = new Scanner(System.in); // make scanner
      String x = ""; // initialize x to stop counting vowel
      int[] result = new int[5];
      while ( !x.equals("STOP") ) // use while loop to stop counting if user want
      {  
         System.out.print("Type sentence that you want to cound vowel : "); // input sentence what user want to cound vowel
         String sentence = word.nextLine();
      
         result = vowelcount(sentence); // get result from function
         
         System.out.println(Arrays.toString(result)); // print result
         
         System.out.print("If you want to stop, type STOP(capital). If it is not, type anything : "); // ask if user want to stop it
         x = word.nextLine();
      }
            
   }
   
   public static int[] vowelcount(String x)
   {
      int [] Array = new int[5]; // make array to put String
   
    
      for ( int i = 0; i < x.length(); i++) // use for loop to count vowel
      {
          if ( x.charAt(i) == 'a' || x.charAt(i) == 'A' ) // if the i th alphabet is a or A add 1 on Array[0]
          {
              Array[0] += 1;
          }
          else if ( x.charAt(i) == 'e' || x.charAt(i) == 'E' )// if the i th alphabet is e or E add 1 on Array[1]
          {
              Array[1] += 1;
          }
          else if ( x.charAt(i) == 'i' || x.charAt(i) == 'I' ) // if the i th alphabet is i or I add 1 on Array[2]

          {
              Array[2] += 1;
          }
          else if ( x.charAt(i) == 'o' || x.charAt(i) == 'O' ) // if the i th alphabet is o or O add 1 on Array[3]
          {
              Array[3] += 1;
          }
          else if ( x.charAt(i) == 'u' || x.charAt(i) == 'U' ) // if the i th alphabet is u or U add 1 on Array[4]
          {
              Array[4] += 1;
          }
      }
    
    
       
      return Array; // return Array
   }
}