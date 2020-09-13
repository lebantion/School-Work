import java.util.*;
import java.io.*;


// CS&141, Winter 18, SeongRok Ha(844926202)
// Assignment #15
//
// This program will ask user 4 question to get random number and make file to input the number.
public class Assignment15
{  
  public static void main(String[] args) throws FileNotFoundException
  {
      Scanner Console = new Scanner(System.in); // make scanner to input 
      
      String FileName;
      int smallnum, largenum, num_random;
      
      Random randomer = new Random(); // set randomer to call random number
      
      System.out.print("What do you want to use name for file? : "); // ask user for filename
      FileName = Console.nextLine();
       
      if ( !FileName.endsWith(".txt")) // if the filename doesn't have .txt. add .txt to make file
      {
         FileName = FileName + ".txt";
      } 
      
      System.out.print("How many Random number do you want to make? : "); // ask user how many user want
      num_random = Console.nextInt();
      
      System.out.print("What is minimum number of random number ? : "); // ask user to get minimum number of random number
      smallnum = Console.nextInt();
      
      System.out.print("What is maximum number of random number ? : "); // ask user to get maximum number of random number
      largenum = Console.nextInt();
      
      PrintStream NewFileName = new PrintStream(new File(FileName)); // use printstream to output in the file
      for ( int i = 1 ; i <= num_random ; i++ ) // use for loop to output number in the file
      {
         
         int n = randomer.nextInt(largenum - smallnum + 1) + smallnum; // set n to get range of random number
         
         NewFileName.print(n + ","); // output in the file
         
         if ( ( i % 5 ) == 0 ) // make line if number outputed 5 times. (make a row)
         {
           NewFileName.println("");
         }
      }
      
  }
}
      