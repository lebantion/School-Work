import java.util.*;

//SeongRok Ha(Simon), 844926202
//CS&141, Assignment #10, 01/31/2018, Winter 18
//
// This program will compare two applicants to determine which one seems like stronger applicant.

{
   public static void main(String[] orgs)
   {
      Scanner score = new Scanner(System.in);
      double first, second;
      for(int i = 0 ; i < 2 ; i++)
      {
         System.out.println("Information for applicant #" + (i + 1));
         
         System.out.print("Do you have 1.SAT Scores or 2. ACT Scores? : ");
         int menu = score.nextInt();
         
         if ( menu == 1)
         {
            System.out.print("SAT math score ? : ");
            int SATmath = score.nextInt();
            System.out.print("SAT critical reading score ? : ");
            int SATreading = score.nextInt();
            System.out.print("SAT writing ? : ");
            int SATwriting = score.nextInt();
            
            double exam_score = (2 * SATmath + SATreading + SATwriting) / 32;
            
            System.out.print("Overall GPA ? : ");
            double GPA = score.nextDouble();
            System.out.print("max GPA ? : ");
            double MAXGPA = score.nextDouble();
            System.out.print("Transcript multiplier ? : ");
            double Transcript = score.nextDouble();
            
            double GPA_Score = (GPA / MAXGPA) / 100 * Transcript;   
                     
            double total_SAT = exam_score + GPA_Score;
            
            if ( i == 0)
               first = total_SAT;
            else if ( i == 1 )
               second = total_SAT;
         }
         else if ( menu == 2)
         {
            System.out.print("ACT English score ? : ");
            int ACTEnglish = score.nextInt();  
            System.out.print("ACT math score ? : ");
            int ACTmath = score.nextInt();
            System.out.print("ACT reading score ? : ");
            int ACTreading = score.nextInt();
            System.out.print("ACT science ? : ");
            int ACTscience = score.nextInt();
            
            double exam_score =  (ACTEnglish + 2 * ACTmath + ACTreading + ACTscience) / (1.8);
            
            System.out.print("Overall GPA ? : ");
            double GPA = score.nextDouble();
            System.out.print("max GPA ? : ");
            double MAXGPA = score.nextDouble();
            System.out.print("Transcript multiplier ? : ");
            double Transcript = score.nextDouble();
            
            double GPA_Score = (GPA / MAXGPA) / 100 * Transcript;
            
            double total_ACT = GPA_Score + exam_score;
            
            if ( i == 0)
               first = total_ACT;
            else if ( i == 1 )
               second = total_ACT;
         } 
      }
      
      System.out.println("Your First applicant overall score is : " + first );
      System.out.println("your Second applicant overall score is : " + second );
      
      if ( first > second )
      {
         System.out.println("First applicant seems to be better");
      }
      else if ( second > first )
      {
         System.out.println("Second applicant seems to be better");
      }
      else if ( second = first)
      {
         System.out.println("Both applicant is same overall");
      }
   
   }
   
}

