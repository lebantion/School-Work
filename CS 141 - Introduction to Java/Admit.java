import java.util.*;

//SeongRok Ha(Simon), 844926202
//CS&141, Assignment #10, 01/31/2018, Winter 18
//
// This program will compare two applicants to determine which one seems like stronger applicant.

public class Admit
{
   public static void main(String[] orgs)
   {
      Scanner score = new Scanner(System.in);
      double first, second; // define first application score, second application score
      first = 0;  // initialize first and second
      second = 0;
      for (int i = 0 ; i < 2 ; i++) // use for loop to make 2 application
      {
         System.out.println("Information for applicant #" + (i + 1));
         
         System.out.print("Do you have 1.SAT Scores or 2. ACT Scores? : ");
         int menu = score.nextInt(); // ask user to choose SAT or ACT
         
         if ( menu == 1)
         {
            System.out.print("SAT math score ? : ");
            int SATmath = score.nextInt(); // get SAT math Score
            
            while ( SATmath < 200 || SATmath > 800)
            {
               System.out.print("Please enter right number of test");
               SATmath = score.nextInt(); // if the score is not between 200 to 800, ask user to put right value
            }

            
            System.out.print("SAT critical reading score ? : ");
            int SATreading = score.nextInt(); // get SAT reading Score
            
            while ( SATreading < 200 || SATreading > 800)
            {
               System.out.print("Please enter right number of test");
               SATreading = score.nextInt(); // if the score is not between 200 to 800, ask user to put right value
            }
            
            System.out.print("SAT writing ? : ");
            int SATwriting = score.nextInt(); // get SAT writing Score
            
            while ( SATwriting < 200 || SATwriting > 800)
            {
               System.out.print("Please enter right number of test");
               SATwriting = score.nextInt(); // if the score is not between 200 to 800, ask user to put right value
            }
            
            double exam_score = (2 * SATmath + SATreading + SATwriting) / 32; // Calculate SAT exam score
            
            System.out.print("Overall GPA ? : ");
            double GPA = score.nextDouble(); // get GPA
            System.out.print("max GPA ? : ");
            double MAXGPA = score.nextDouble(); // get Maximum GPA
            System.out.print("Transcript multiplier ? : ");
            double Transcript = score.nextDouble(); // get mulitplier
            
            while ( Transcript < 0.8 || Transcript > 1.0 )
            {
               System.out.print("Please Enter the right value of transcript multiplier");
               Transcript = score.nextDouble(); //  // if the multiplier is not between 0.8 to 1.0, ask user to put right value
               
            }
            
            double GPA_Score = (GPA / MAXGPA) * 100 * Transcript; // calculate GPA Score
            
            double total_SAT = exam_score + GPA_Score; // get total point
            
            if ( i == 0)
               first = total_SAT; // if it's first application put value in first
            else if ( i == 1 )
               second = total_SAT; // if it's second application put value in second
         }
         else if ( menu == 2)
         {
            System.out.print("ACT English score ? : ");
            int ACTEnglish = score.nextInt();  // get ACT English Score
            
            while ( ACTEnglish < 1 || ACTEnglish > 36)
            {
               System.out.print("Please enter right number of test"); // if the score is not between 1 to 36, ask user to put right value
               ACTEnglish = score.nextInt();
            }
            
            System.out.print("ACT math score ? : ");
            int ACTmath = score.nextInt(); // get ACT math Score
            
            while ( ACTmath < 1 || ACTmath > 36)
            {
               System.out.print("Please enter right number of test");
               ACTmath = score.nextInt(); // if the score is not between 1 to 36, ask user to put right value

            }
            
            System.out.print("ACT reading score ? : ");
            int ACTreading = score.nextInt(); // get ACT reading Score
            
            while ( ACTreading < 1 || ACTreading > 36)
            {
               System.out.print("Please enter right number of test");
               ACTreading = score.nextInt(); // if the score is not between 1 to 36, ask user to put right value

            }

            System.out.print("ACT science ? : ");
            int ACTscience = score.nextInt(); // get ACT Science Score
            
            while ( ACTscience < 1 || ACTscience > 36)
            {
               System.out.print("Please enter right number of test");
               ACTscience = score.nextInt(); // if the score is not between 1 to 36, ask user to put right value

            }

            double exam_score =  (ACTEnglish + 2 * ACTmath + ACTreading + ACTscience) / (1.8); // get exam Score of ACT
            
            System.out.print("Overall GPA ? : ");
            double GPA = score.nextDouble(); // get GPA
            System.out.print("max GPA ? : ");
            double MAXGPA = score.nextDouble(); // get MAXIMUM GPA
            System.out.print("Transcript multiplier ? : ");
            double Transcript = score.nextDouble(); // get transcript multiplier
            
            while ( Transcript < 0.8 || Transcript > 1.0 )
            {
               System.out.print("Please Enter the right value of transcript multiplier"); // if the multiplier is not between 0.8 to 1.0, ask user to put right value

               Transcript = score.nextDouble();
               
            }
            
            double GPA_Score = (GPA / MAXGPA) * 100 * Transcript; // get GPA Score
            
            double total_ACT = GPA_Score + exam_score; // get total score of ACT
            
            if ( i == 0)
               first = total_ACT; // if it's first applicant, put value on first
            else if ( i == 1 )
               second = total_ACT; // if it's second applicant, put value on second
         } 
      }
      
      System.out.println("Your First applicant overall score is : " + first ); // output first applicant score
      System.out.println("your Second applicant overall score is : " + second ); // output second applicant score
      
      if ( first > second ) // compare score and if the first is bigger output first is better
      {
         System.out.println("First applicant seems to be better");
      }
      else if ( second > first ) // compare score and if the second is bigger output second is better
      {
         System.out.println("Second applicant seems to be better");
      }
      else if ( second == first) // compare score and if the first and second is same, output both score is same overall
      {
         System.out.println("Both applicant is same overall");
      }
   
   }
   
}

