/* This Program sort by word or form and get the possible anagram of the word.
 * 
 * @param word_list word lists in the Word Class.
 * @param Anagram_Map Map for add original word with Canonical word
 * @param Random_num Random Parameter for Matching
 * @version November 14 2018
 * @author SeongRok Ha(844926202)
*/

import java.util.*;

public class AnagramManager
{
   private Word[] word_list;
   private Map<String, Set<String>> Anagram_Map;
   Random Random_num;
   
   public AnagramManager(List<String> list_Word)
   {
      if (list_Word == null || list_Word.size() < 1) // if the list is empty and size is lower than 1 throw IllegalArgumentException.
      {
         throw new IllegalArgumentException();
      }
      
      // initialize everything
      
      Random_num = new Random(); 
      word_list = new Word[list_Word.size()];
      Anagram_Map = new TreeMap<String,Set<String>>();
      
      // use for loop to put word to the Array.
      int i = 0;
      
      for(String x : list_Word)
      {
          word_list[i] = new Word(x);
          i++;
      }
      
      // use for loop to put canonical word and original word to the Map of Anagram.
      for(Word x : word_list)
      {
          String canon = x.getForm();
          String original = x.getWord();
                    
          if( !Anagram_Map.containsKey(canon) )
          {      
              Set<String> set = new TreeSet<String>();
              set.add(original);
              Anagram_Map.put(canon, set);
          }
          else
          {      
              Anagram_Map.get(canon).add(original);
          }
      }   
   }
   
   public void sortByWord() // sort Array by original word form
   {
      for ( Word x : word_list )
      {
         x.Ori_form();
      }
      Arrays.sort(word_list);
   }
   
   public void sortByForm() // sort Array by Canonical word form
   {
      for ( Word x : word_list )
      {
         x.Canon_form();
      }
      Arrays.sort(word_list);
   }
   
   public String getAnagram(String x) 
   {
      if( x == null || x.length() < 1 ) // throw IllegalArgumentException if the word is null and length is lower than 1
      {
         throw new IllegalArgumentException();
      }
      
      char[] a = x.toCharArray(); // make char Array to break down Word
      Arrays.sort(a); // sort char Array
      
      String canon_word = new String(a); // set Canon_word as sorted char String
   
      if(Anagram_Map.containsKey(canon_word)) //if the map has canon_word key return String Array of Matched Word.
      {
         Set<String> temp = Anagram_Map.get(canon_word);
         String[] Matching = temp.toArray(new String[temp.size()]);
         
         return Matching[Random_num.nextInt(Matching.length)];
      }
      else // if it is not return blank
      {
         return " ";
      }
   }
   
   public Set<String> getAnagrams(String x)  
   {
      if( x == null || x.length() < 1 ) // if word is null or length is lower than 1 throw IllegalArgumentException
      {
         throw new IllegalArgumentException();
      }
      
      char[] a = x.toCharArray(); // break down word to make char Array
      Arrays.sort(a); // sort char Array
      
      String canon_word = new String(a); // set cannon word as String of charArray.
      
      boolean Anagram_ornot = Anagram_Map.containsKey(canon_word); //set Anagram_ornot to check Map has key which is cannonical word or not
      
      Set<String> temp = (Anagram_ornot)? Anagram_Map.get(canon_word) : new TreeSet<String>(); // if it has the key get set and put it to temp set to return temp set.
      
      return temp;
   }
   
   public String toString()
   {
      String Word_Print = ""; // initialize output word
      int word_length = word_list.length; // set length same with WordArray's length
      
      if(word_length < 1) // if Array is lower than 1 print out blank
      {
         Word_Print = "[ ]";
      }
      else
      {
         int x = (word_length < 5)? word_length : 5; // else, use for loop to add Word to Word_Print to print out.
         
         for (int i = 0 ; i < x; i++) // put first word elements
         {
            Word_Print += word_list[i];
         }
         
         Word_Print += "[...]"; 
         
         for ( int i = word_length - x ; i < word_length ; i++ ) // put last 5 word elements
         {
            Word_Print += word_list[i];
         }
      }
      
      return Word_Print;
   }
}