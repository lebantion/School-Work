import java.util.*;


// CS&141, Winter 18, SeongRok Ha(844926202)
// Assignment 12A
//
// This program will run Dice Game " Pig " which is the game if one user over 50 first, that user win.

public class Assignment12A
{  
  public static void main(String[] args)
  {
      playoneturn(); // call function
  }
  
  public static void playoneturn()
   {
      int total2 ,total1 , score, turn;
      
      score = 0; // initializing
      total1 = 0; // initializing player 1's score
      total2 = 0; // initializing player 2's score
      turn = 1; // initializing
      Random ran_num = new Random(); // set ran_num to call random number
      Scanner turning = new Scanner(System.in); //set turning to use for turn
      
      while (total1 < 50 && total2 < 50 ) // use while loop to make at least one user got over 50
      {
         score = 0; // reset score
         turn = 1;  // reset turn    
         System.out.println("Player : Computer1's turn"); // Computer1's turn
         
         while (turn != 0)
         {
            
            int dice = ran_num.nextInt(6) + 1; // get random number
            if ( dice == 1) // if the dice is 1, remove all score for this turn and end turn
            {
               score = 0;
               turn = 0;
               System.out.println("You got 1... Your score for this turn is turn into 0");
            }
            else // if the dice is not 1, add score and ask user to roll one more time
            {
               score += dice;
               System.out.println("You got " + dice + " ... ");
               int percentage = ran_num.nextInt(101); // get 0 ~ 100 number to get percentage
               System.out.println("Stop Percentage : " + (score * 3) + ", Continueing Percentage : " + (100 - score * 3)); //output percentage
               if ( percentage < score * 3 ) // set up if the percentage is less than score multyply by 3 stop rolling.
               {
                  turn = 0;
               }
               
            }
         }
         total1 += score; // add score to total score
 
         score = 0; // reset score
         turn = 1; // reset turn
         
         System.out.println("Player : Computer2's turn"); //Computer 2's turn
         
         while (turn != 0)
         {
            int dice = ran_num.nextInt(6) + 1; // call random number
            if ( dice == 1)  // if the dice is 1, remove all score for this turn and end turn
            {
               score = 0;
               turn = 0;
               System.out.println("You got 1... Your score for this turn is turn into 0");
            }
            else // if the dice is not 1, add score and ask user to roll one more time
            {
               score += dice;
               System.out.println("You got " + dice + " ... ");
               int percentage = ran_num.nextInt(101); // get 0 ~ 100 number to get percentage
               System.out.println("Stop Percentage : " + (score * 3) + ", Continueing Percentage : " + (100 - score * 3)); //output percentage
               if ( percentage < score * 3 )  // set up if the percentage is less than score multyply by 3 stop rolling.
               {
                  turn = 0;
               }
            }
         } 
         total2 += score; // add score to total score
         
         System.out.println("Player : Computer1 got " + total1 + " until now"); // output overall score 
         System.out.println("Player : Computer2 got " + total2 + " until now"); // output overall score
         
     }
     if ( total1 > total2 ) // output if the Player 1 win
     {
      System.out.println("Player : Computer1 Win !!!");
     }
     else if ( total2 > total1) // output if the Player 2 win
     {
      System.out.println("Player : Computer2 Win !!!");
     }
     else if ( total1 == total2 ) // output if the score is same
     {
      System.out.println("You guys draw...");
     }
   }
}