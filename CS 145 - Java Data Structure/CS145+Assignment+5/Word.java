/* This class help to run AnagramManager Program. 
 * Initialized word and comparing form to compare the word form.
 * 
 * @param Ori_word Original word 
 * @param canonical Canonical Word 
 * @param compareform form to compare the word.
 * @version November 12th 2018
 * @author SeongRok Ha(844926202)
*/

import java.util.*;

public class Word implements Comparable<Word>
{
   private String ori_word;
   private String canonical;
   private String compareform;
   
   public Word(String x)
   {
      if( x == null || x.length() < 1 ) // if word is null or length is lower than 1 throw IllegalArgumentException.
      {
         throw new IllegalArgumentException();
      }
      
      String Up_Word = x.toUpperCase(); // make word uppercase to compare 
      ori_word = Up_Word; // initialize original word
      
      char[] a = x.toCharArray(); // make char array a to break down word x.
      Arrays.sort(a); // sort list array a
      
      canonical = new String(a); // set canonical sorted array a.
   
   }
   
   public String getWord() // get original word
   {
      return ori_word; 
   }
   
   public String getForm() // get canonical word
   {
      return canonical;
   }
   
   public void Canon_form() // set compareform canonical
   {
      compareform = canonical;
   }
   
   public void Ori_form() // set compareform Originally
   {
      compareform = ori_word;
   }
   
   public String getCompareForm() // get compareform
   {
      return compareform;
   }
   
   public String toString() // print out original word and canonical word
   {
      return ("[ " + ori_word + " = " + canonical + " ]" );
   }
   
   public int compareTo(Word x) // compare by comparefrom with word x's compareform
   {
      return compareform.compareTo(x.getCompareForm());
   }
   
}