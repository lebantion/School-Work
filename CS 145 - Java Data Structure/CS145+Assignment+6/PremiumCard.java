/* This program extends Cards
 * This premiumCard program help to make PremiumCard among the cards
 *
 * @param power Card's power
 * @param toughness Card's toughness
 * @author SeongRok Ha(844926202)
 * @version November 21st (2018)
*/

import java.util.*;

public class PremiumCard extends Card 
{

   private int power;

   private int toughness;

   public PremiumCard() // no parameter fuction and input random number 0 ~ 999 to power and toughness
   {

      super();

      power = new Random().nextInt(1000);

      toughness = new Random().nextInt(1000);

   }

   public PremiumCard(int x) // put x value to the power and toughness
   {
      super(x);
   
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


   public PremiumCard(int x, int y) // put x value to power and y value to toughness
   {

      super(x, y);

      if ((x <= 1 && y >= 1000) || (x <= 1 && y >= 1000))
      {
         throw new IllegalArgumentException();
      } 
      else 
      {
         power = x;
         toughness = y;
      }
   }
}