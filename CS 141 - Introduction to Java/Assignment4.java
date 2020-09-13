//SeongRok Ha(Simon), 844926202
//CS&141, Assignment #5, 01/19/2018, Winter 18
//
// This program will print design what user want

public class Assignment5
{
   public static void main(String[] orgs)
   {
      printdesign(6);
   }
   
   public static void printdesign(int height)
   {
      for (int h = 1 ; h <= height ; h++)
         {
            for (int i = 1 ; i <= height ; i++)
            {
               System.out.print("-");
            }
            
            int number;
            
            for (int i = 1 ; 1 <= h ; i++)
            {
               System.out.print(1);
            }
            
            for (int i = 1 ; i <= height ; i++)
            {
               System.out.print("-");
            }
            System.out.println();
         }
   }
}