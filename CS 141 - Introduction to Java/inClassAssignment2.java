import java.util.*;


// CS&141, Winter 18, SeongRok Ha(844926202)
// Assignment 12A
//
// This program will run Dice Game " Pig "

public class inClassAssignment2
{  
  public static void main(String[] args)
  {
   
   Scanner console = new Scanner(System.in);
   
   System.out.print(" What is the Player 1's name ? : ");
   String Player1 = console.nextLine();
   
   System.out.print(" What is the Player 2's name ? : ");
   String Player2 = console.nextLine();
   
   playoneturn(Player1,Player2);
   
   
      
  }
  public static void playoneturn(String x, String y)
  {
      int total2 ,total1 , score1, score2, turn;
      
      score1 = 0;
      score2 = 0;
      turn = 1;
      Random ran_num = new Random();
      
      while (score1 < 50 || score2 < 50)
      {
         System.out.println("Player : " + x + "'s turn");
         
         while (turn != 0)
         {
            int dice = ran_num.nextInt(6) + 1;
            if ( dice == 1)
            {
               score = 0;
               turn = 0;
               System.out.println("You got 1... Your score for this turn is turn into 0");
            }
            else
            {
               score += dice;
               System.out.println("You got " + dice + " ... ");
               System.out.print("If you want to do one more put 1, if you want to stop your turn put 0 : ");
               turn = console.nextInt();
            }
         }
         total1 += score;
 
         score = 0;
         
         System.out.println("Player : " + y + "'s turn");
         
         while (turn != 0)
         {
            int dice = ran_num.nextInt(6) + 1;
            if ( dice == 1)
            {
               score = 0;
               turn = 0;
               System.out.println("You got 1... Your score for this turn is turn into 0");
            }
            else
            {
               score += dice;
               System.out.println("You got " + dice + " ... ");
               System.out.print("If you want to do one more put 1, if you want to stop your turn put 0 : ");
               turn = console.nextInt();
            }
         } 
         total2 += score;
   }
 }
