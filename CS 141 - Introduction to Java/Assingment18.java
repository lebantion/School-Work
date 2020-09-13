import java.util.*;
import java.io.*;


// CS&141, Winter 18, SeongRok Ha(844926202)
// Assignment 18
//
/* This program processes a file of answers to the
Keirsey Temperament Sorter.  It converts the
various A and B answers for each person into
a sequence of B-percentages and then into a
four-letter personality type.*/

public class Assingment18
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner normal_scan = new Scanner(System.in);
      
      System.out.print("What is input file name? : "); // get input file name
      String input_file = normal_scan.nextLine();
      
      System.out.print("What is output file name? : "); // get output file name
      String output_file = normal_scan.nextLine();
      
      if ( !input_file.endsWith(".txt")) // check .txt 
      {
         input_file = input_file + ".txt";
  
      }
      if ( !output_file.endsWith(".txt") ) // check .txt
      {
         output_file = output_file + ".txt";
      }
      
      Scanner input_scan = new Scanner(new File(input_file)); // make scanner to scan input file
      PrintStream output = new PrintStream(new File(output_file)); // make printstream to output in the outputfile
         
      while ( input_scan.hasNext() ) // use while loop to get all people's data from input file
      {  
         String name = input_scan.nextLine(); // get name
         String answer = input_scan.nextLine().toUpperCase(); // get user's all answer
         
         int[] A_array = A_Checker(answer); // count A
         int[] B_array = B_Checker(answer); // count B
         
         int[] percent = percentage(B_array); // get percentage of each 4 part
         
         String[] Type = type_checker(percent); // get type of user
         
         output.println( name + " : " + Arrays.toString(percent) + " = " + Type[0] + Type[1] + Type[2] + Type[3]); // output result and name
         
      }
   
   }
   
   public static int[] A_Checker(String answer) // function for counting A
   {
      int[] count = new int[4];
      for ( int i = 0 ; i < answer.length(); i++) // use for loop to put data in Array
      {
         if (answer.charAt(i) == 'A')
         {
            if (i % 7 == 0) // group up the 10 question by 7 and count A
            {
               count[0]++;
            }   
        
            if (i % 7 == 1 || i % 7 == 2) // group up 20 question by 7 and count A
            {  
               count[1]++;  
            }  
   
            if (i % 7 == 3 || i % 7 == 4) // group up 20 question by 7 and count A
            {  
               count[2]++;  
            }  
            if (i % 7 == 5 || i % 7 == 6) // group up 20 question by 7 and count A
            {  
               count[3]++;
            }
         }
      }
      return count; // return Array
   }
   
   public static int[] B_Checker(String answer) // Counting B
   {
      int[] count = new int[4];
      
      for ( int i = 0 ; i < answer.length(); i++) // use for loop to put data in array
      {
         if (answer.charAt(i) == 'B')
         {
            if (i % 7 == 0) // group up the 10 question by 7 and count B
            {
               count[0]++;
            }   
        
            if (i % 7 == 1 || i % 7 == 2) // group up the 20 question by 7 and count B
            {  
               count[1]++;  
            }  
   
            if (i % 7 == 3 || i % 7 == 4) // group up the 20 question by 7 and count B
            {  
               count[2]++;  
            }  
            if (i % 7 == 5 || i % 7 == 6) // group up the 20 question by 7 and count B
            {  
               count[3]++;
            }
         }
      }
     return count;
   }

   public static int[] percentage(int[] B) // get percentage of each section
   {
      int[] percent = new int[4];
      
      for ( int i = 0 ; i < 4 ; i++) // use for loop to get 4 parts' percentage
      {
         if ( i == 0 )
         {
            percent[i] = 100 * B[i] / 10; // first one is 10 question. so divide by 10
         }
         else 
         {
            percent[i] = 100 * B[i] / 20; // else one is 20 question. so divide by 20
         }
      }
      
      return percent;
   }
   
   public static String[] type_checker(int[] result) // get user's type based on B answer
   {
      String[] type = new String[4];
      for (int i = 0 ; i < 4 ; i++ )
      {
         if ( result[i] > 50 ) // If percentage is larger than 50, get right side type
         {
            if ( i == 0 )
            {
               type[i] = "I";
            }
            else if ( i == 1 )
            {
               type[i] = "N";
            }
            else if ( i == 2 )
            {
               type[i] = "F";
            }
            else
            {
               type[i] = "P";
            }
         }
         if ( result[i] < 50) // If percentage is smaller then 50, get left side type
         { 
          if ( i == 0 )
            {
               type[i] = "E";
            }
            else if ( i == 1 )
            {
               type[i] = "S";
            }
            else if ( i == 2 )
            {
               type[i] = "T";
            }
            else
            {
               type[i] = "J";
            }
         }
         if ( result[i] == 50 ) // If percentage is equal to 50, get X type
         {
            type[i] = "X";
         }
         
      }
      return type;
   }
}

