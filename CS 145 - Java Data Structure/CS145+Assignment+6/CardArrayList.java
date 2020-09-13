/* This program help running CardArrayMaster Program
 * Sort the Array of Card, Making Array of Card so on.
 *
 * @param cards Array of Card[];
 * @param main List for the merging
 * @author SeongRok Ha(844926202)
 * @version November 21st (2018)
 *
 *
*/

import java.util.*;

public class CardArrayList
{
   private List<Card> main;
   private Card[] cards;



   public CardArrayList() // make basic card list which can have 10 cards
   {
      cards = new Card[10];
   }


   public CardArrayList(int x)  // make card list which can have x cards
   {

      if (x < 0) 
      {
         System.out.println("Error");
      } 
      else
      {
         cards = new Card[x];
      }
   }

   public String toString() // priht out all the card's information
   {

      String return_str = "";

      return_str += "[0";

      int length = cards.length;

      for (int i = 0; i < size(); i++)
      {

         if (cards[i] != null) 
         {

            return_str += cards[i].toString();
            if( i < size() - 1)
            {
               return_str += ", " ;
            }
         }
      }
      
      return_str += " ] : " + length;

      return return_str;
   }


   public int size() // return how many cards in the array(Deck)
   {

      int length = cards.length;

      int filled = 0;

      for (int i = 0; i < length; i++) 
      {

         if (cards[i] != null) 
         {
            filled = filled + 1;
         }

      }

      return filled;
   }
  

   public void add(Card x)  // add Card x to the array, if the array is full expand double.
   {
      if ( isRoom() == false)
      {
         expand();
      }
      
      int length = cards.length;

      for (int i = 0; i < length; i++) 
      {
         if (cards[i] == null) 
         {
            cards[i] = x;
            break;
         }
      }
   }


   public Card remove() // remove card which is at the end of array and return the removed card.
   {
      Card temp = cards[size()-1];
      
      cards[size() - 1] = null;     
         
      return temp;
   }


   public Card get(int x) // get card's information.
   {
      if ( x <= size())
      {
         return cards[x];
      }
      
      return null;
   }


   public int indexOf(Card x) // get index if the array has Card x.
   {
      for (int i = 0; i < size(); i++) 
      {
         if (x.toString() == cards[i].toString()) 
         {
            return i;
         }
      }
      return -1;
   }


   public void add(int y, Card x) // add Card x to y location. if array is full expand it double.
   {
      if ( isRoom() == false )
      {
         expand();
      }

      for (int i = 0; i < size(); i++) 
      {
         if (i == y) 
         {
            for (int j =  size(); j > i; j-- ) 
            {
               cards[j] = cards[j-1];
            }
            cards[y] = x;
         }
      }
   
   }

   public Card remove(int j) // remove j location card and return removed card.
   {

      Card card = null;

      for (int i = 0; i < size(); i++)
      {
         if (i == j - 1) 
         {
            card = cards[i];
            
            for (int k = i; k < size() - 1 ; k++)
            {
               cards[k] = cards[k + 1];
               
            }
         }          
      }
      return card;
   }



   public void sort() //
   {
      List<Card> main = Arrays.asList(cards);
      
      sortList(main);
      
      for (int i = 0 ; i < size(); i++)
      {
         cards[i] = main.get(i);
      }
   }
   
  private static void sortList (List<Card> x) // seperate all the list of Card by half
  {
   
   if (x.size() != 1) 
   {
      List<Card> left = new ArrayList<>();

      List<Card> right = new ArrayList<>();
      
      
      left.addAll(x.subList(0, x.size() / 2)); // separate half
      right.addAll(x.subList(x.size() / 2, x.size())); // separate half
     
      sortList(left); // recursion to seperate until list has only one value
      sortList(right); // recursion to seperate until list has only one value
      Merging(left,right,x); // merge list main
   }
 }
 
 private static void Merging(List<Card> left,List<Card> right,List<Card> x) // merging card by costs
 {
    List<Card> temp = new ArrayList<>(); // make temp list to sort card.
      
    while (!left.isEmpty() && !right.isEmpty()) // sort by cost of the card
    {
       
       if ( left.get(0).getCost() <= right.get(0).getCost() ) 
       {
          temp.add(left.remove(0));
       }
       else 
       {
          temp.add(right.remove(0));
       }
    }
    x.addAll(temp); // add it to main list.
 }


   
   
   public void shuffle() // shuffle the array of card.
   {
      List<Card> list = Arrays.asList(cards);
      Collections.shuffle(list);
   }


   private boolean isRoom() // if the array is full return false if not true
   {
      if (size() == cards.length) 
      {
         return false;
      }
      return true;
   }


   private void expand() // expand array double.
   {
     cards = Arrays.copyOf(cards, cards.length * 2);
   }



   private void swap(int a, int b)
   {
      Card temp = null;
      temp = cards[a];

      cards[a] = cards[b];

      cards[b] = temp;
   }

   public void clear() 
   {
      cards = new Card[10];
   }
}