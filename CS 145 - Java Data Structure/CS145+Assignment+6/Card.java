/* This Card class help to run CardArrayLists to save information about card. (Making Array)
 * Also, do all the calculation about card's power and toughness.
 *
 * @param power for Card's power
 * @param toughness for Card's toughness
 * @author SeongRok Ha(844926202)
 * @version November 21st (2018)
*/


import java.util.*;

public class Card
{
   private int power;

   private int toughness;

   public Card() // set power and toughness random number 0 ~ 999
   {
      power = new Random().nextInt(1000);
      toughness = new Random().nextInt(1000);
   }
   
   public Card(int x) // set power and toughness x value.
   {

      if (x <= 1 && x >= 1000)
      {
         throw new IllegalArgumentException();
      } 
      else 
      {
         power = x;
         toughness = x;
      }
  }
   
   public Card(int p, int t) // set power x p value and toughness t value
   {
  
      if ((p <= 1 && p >= 1000) || (t <= 1 && t >= 1000)) 
      {
         throw new IllegalArgumentException();
      }   
      else 
      {
         power = p;
         toughness = t;      
      }
  }
  
   public int getPower() // get power of the card
   {
      return power;
   }
  
   public int getToughness() // get toughness of the card
   {
      return toughness;
   }
   
   public int getCost() // get Cost for the card
   {
      return (int) Math.sqrt((1.5*power) + (0.9*toughness));
   }
   
   public String toString() // make string to out put
   {
      return "[" + power + "/" + toughness + "]";
   }
   
   public void weaken() // make card weaker
   {
      power = (int) (power - power * 0.1);

      toughness = (int) (toughness - toughness * 0.1);
   }
   
   public void boost() // make card boosting 
   {
      power = (int) (power + power * 0.1);
      toughness = (int) (toughness + toughness * 0.1);
   }
}