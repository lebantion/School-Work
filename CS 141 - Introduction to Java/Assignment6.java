import java.util.*;

//SeongRok Ha(Simon), 844926202
//CS&141, Assignment #7, 01/25/2018, Winter 18
//
// This program will print the parameter with stars

public class Assignment7
{
   public static void main(String[] orgs)
   {
      Scanner pad = new Scanner(System.in);
      
      System.out.print("Enter the Word : ");
      String Word = pad.nextString();
      
      System.out.print("Enter the Number which you want to add star : ");
      int star = pad.nextInt();
      
      PadString(Word, star);
        
   }  
   public static void PadString(String word,int number)
   {
      for ( int i = 0 ; i <= number ; i++)
      {
         word += '*';
      }
      
      System.out.print(word);
   } 
   
}