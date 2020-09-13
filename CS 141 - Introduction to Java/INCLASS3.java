import java.util.*;
import java.io.*;


// CS&141, Winter 18, SeongRok Ha(844926202)
// In Class Assignment Week 7
//
// This program will open file, making new file and copy with making uppercase.

public class INCLASS3
{  
  public static void main(String[] args) throws FileNotFoundException
  {
      File inclass = new File("CS141 Data File W7ICA1.txt"); // open File
      Scanner Console = new Scanner(inclass); // make scanner to scan File
      
      PrintStream NewFileName = new PrintStream(new File("CS141 Data UPPER.txt")); // use printstream to output in the file
      while (Console.hasNextLine())
      {
         String line = Console.nextLine(); // scan File and input token in line
         
         NewFileName.println(line.toUpperCase()); // make output with uppercase in new File
         
         
      }
  }
}
      