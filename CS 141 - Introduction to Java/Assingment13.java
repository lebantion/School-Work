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
   public static void main(String[] args)
   {
      Scanner normal_scan = new Scanner(System.in);
      
      System.out.print("What is input file name? : ");
      String input_file = normal_scan.nextLine();
      
      System.out.print("What is output file name? : ");
      String output_file = normal_scan.nextLine();
      
      if ( !input_file.endswith(".txt"))
      {
         input_file = input_file + ".txt";
  
      }
      if ( !output_file.endswith(".txt") )
      {
         output_file = output_file + ".txt";
      }
      
      Scanner input_scan = new Scanner(new File(input_file));
      PrintStream output = new PrintStream(new File(output_file));
      
      while ( input_scan.hasNext() )
      {
         int counter = 0;
         
         String name = input.nextLine();
         String answer = intput.nextLine().toUppercase();
         
         int[] A_array = A_Checker(answer);
         int[] B_array = B_Checker(answer);
         
         int[] percent = percentage(B_array);
         
         int[] Type = type_checker(percent);
         
         output.println( name + " : " + Arrays.toString(percent) + " = " + Type[counter]);
         
      }
   
   }
   
   public static int[] A_Checker(String answer)
   {
      int[] count = new int[4];
      
      for(int i = 0 ; i < 10 ; i++)
      {
         if ( answer.charAt(i) == 'A' )
         {
            count[0]++;
         }
      }
      for (int i = 0 ; i < 20 ; i++)
      {
         if ( answer.charAt(i) == 'A' )
         {
            count[1]++;
         }
      }
      for (int i = 0 ; i < 20 ; i++)
      {
         if ( answer.charAt(i) == 'A' )
         {
            count[2]++;
         }
      }
      for (int i = 0 ; i < 20 ; i++)
      {
         if ( answer.charAt(i) == 'A' )
         {
            count[3]++;
         }
      }
      
      return count;
   }
   
   public static int[] B_Checker(String answer)
   {
      int[] count = new int[4];
      
      for(int i = 0 ; i < 10 ; i++)
      {
         if ( answer.charAt(i) == 'B' )
         {
            count[0]++;
         }
      }
      for (int i = 0 ; i < 20 ; i++)
      {
         if ( answer.charAt(i) == 'B' )
         {
            count[1]++;
         }
      }
      for (int i = 0 ; i < 20 ; i++)
      {
         if ( answer.charAt(i) == 'B' )
         {
            count[2]++;
         }
      }
      for (int i = 0 ; i < 20 ; i++)
      {
         if ( answer.charAt(i) == 'B' )
         {
            count[3]++;
         }
      }
      
      return count;
   }

   public static int[] percentage(int[] B)
   {
      int[] percent = new int[4];
      
      for ( int i = 0 ; i < 4 ; i++)
      {
         if ( i == 0 )
         {
            percent[i] = B[i] / 10 * 100;
         }
         else 
         {
            percent[i] = B[i] / 20 * 100;
         }
      }
      
      return percent;
   }
   
   public static int[] type_checker(int[] result)
   {
      String[] type = new String[4];
      for (int i = 0 ; i < 4 ; i++ )
      {
         if ( result[i] > 50 )
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
         if ( result[i] < 50)
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
         if ( result[i] == 50 )
         {
            result[i] = "X";
         }
         
      }
      return type;
   }
}

