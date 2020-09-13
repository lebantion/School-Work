/* 
 * This class will calculate how many attempt is it left and update pattern for user's guess so that
 * Hangmangame(HangmanMain) could work.
 *
 * @author SeongRok Ha ( 844926202)
 * @version 2.0 February 5, 2019
 * @param num_guess this parameter show how many trial user have.
 * @param Current_word this set contains sets of words that is being considered.
 * @param char_guessed this set contains sets of character that user typed for guess.
 * @param blank this is current pattern of word.
 */
 
import java.util.*;

public class HangmanManager
{
   private int num_guess; // possilbe guess number left
   private TreeSet<String> Current_word; // set of words being considered by hangman manager.
   private TreeSet<Character> char_guessed; // set that user input letter to guess word.
   private String blank; // pattern of word.
   
   /* This function define all the parameter and for the blank put the "-" same as word's length
    *
    * @throw IllegalArgumentException if the word's length is less than 1 and number of possible guess is less than 0 throw IllegalArugumentException. 
    *
   */
   public HangmanManager(List<String> word_list, int word_length, int max_trial)
   {
      if(word_length < 1 || max_trial < 0)
      {
         throw new IllegalArgumentException();
      }
      
      Current_word= new TreeSet<String>(); 
      char_guessed = new TreeSet<Character>(); 
      num_guess = max_trial;
      
      for(String x : word_list) 
      { 
         if(x.length() == word_length) 
         {
            Current_word.add(x);
         }
      }
     
      blank = "";
      
      for(int i = 0; i < word_length; i++)       
      {
         blank += "-";
      }
   }
   
   // this function return set of word being considered.
   public Set<String> words()
   {
      return Current_word;
   }
   
   // this function print out how many guesses left.
   public int guessesLeft()
   {
      return num_guess;
   }
   
   // this function print out what user print in to guess word.
   public Set<Character> guesses() 
   {
      return char_guessed;
   }
   
   /* 
    * this function print out current pattern of guessing word.
    *@throw IllegalStateException if the set is empty, throw an IllegalStateException
   */
   public String pattern() 
   {
      if(Current_word.isEmpty())
      {
         throw new IllegalStateException();
      }
      return blank;
   }
   
   /* This record fuction put the guessed char to the set and record all the works for the hangmanMain
    *
    * @param guess_counter this is counter for how many guesses left for player.
    * @param Max_String it is parameter for get largest size of String among keyset of char_map
    * @param Max_Blank
    * @throw IllegalStateException if the set of word being considered is empty or left number of guesses is less than 1  
    * @throw IllegalArgumentException if the user's input of letter to guess is guessed previously
   */
   public int record(char guess) 
   {
      if(Current_word.isEmpty() || num_guess < 1)
      {
         throw new IllegalStateException();
      }  
      if(char_guessed.contains(guess))
      {
         throw new IllegalArgumentException();
      }     
      
      char_guessed.add(guess); // if none of above is false, add guess to guessed char.  
      
      int guess_counter = 0;
      int Max_String= 0; 
      String Max_Blank= blank; 
      
      int length = blank.length();
      
      String blank = "";
      
      Map<String, TreeSet<String>> char_map = new TreeMap<String, TreeSet<String>>(); // make letter map to put
      
      for(String x : Current_word) // get word from being considered words.
      {  
         for (int i = 0; i < length; i++) // use for loop so that finding whether letter is in the word or not.
         {
 
            if (char_guessed.contains( x.charAt(i)))
            {
               blank += x.charAt(i);
            }
            else if (x.charAt(i) == guess) 
            {
               blank  += guess;
            } 
            else 
            {
               blank  += "-";
            }
         }
         
         if(!char_map.containsKey(blank)) // if the char_map doesn't contain pattern, put pattern and new treeset.
         {
            char_map.put(blank, new TreeSet<String>());
         }
         else
         {
            char_map.get(blank).add(x); // else get the set and put word which is from Current_word to char_map.
         }
      }
   
      for(String y : char_map.keySet()) // get keyset (pattern ) from char_map and get biggest size of String with pattern by for loop.
      {
         TreeSet<String> temp = char_map.get(y); // make new set of value(char_map) to compare value
        
         if(temp.size() > Max_String)
         {
            Max_String = temp.size();
            Max_Blank = y;      
         }
      }
      
      Current_word = char_map.get(Max_Blank);
      
      blank = Max_Blank;
  
      
      for( int i = 0 ; i < Max_Blank.length(); i++) 
      {
         if(Max_Blank.charAt(i) == guess) // if pattern of word has guess, add 1 of guess counter.
         {
            guess_counter++;
         }
      }
      
      if( guess_counter == 0 ) // if guess_counter is 0, minus number of guess.
      {
          num_guess--;
      }
      
      return guess_counter; // return calculated guess counter.
   }
}