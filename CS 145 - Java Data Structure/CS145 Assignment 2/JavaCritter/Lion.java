/*
 * This Program create Lion Critter which infect other Critter.
 *
 *
 * @param Color_Counter this is Counter for color to change color when the counter is 3.
 * @param rand get random number to select color of lion
 * @param lion_Color set Color for lion
 * @author Simon Ha ( 844926202 )
 * @version October 5th 
*/

import java.util.*;
import java.awt.*;

public class Lion extends Critter
{
   private int Color_Counter = 0;
   Random rand = new Random();
   private Color lion_Color;
   public Lion()
   {
   }
   
   public Color getColor() // get color and change it when the color has been same for 3 times.
   {
      if ( Color_Counter % 3 == 0 )
      {
         int x = rand.nextInt(3); // get random number to set color
         
         if ( x == 0 )
         {
            lion_Color = Color.RED;
            Color_Counter++;
         }
         else if ( x == 1 )
         {
            lion_Color = Color.GREEN;
            Color_Counter++;
         }
         else if ( x == 2 )
         {
            lion_Color = Color.BLUE;
            Color_Counter++;
         }
      }
      return lion_Color;
   }
   
   public String toString() // set Lion String L
   {
      return "L";
   }
   
   public Action getMove(CritterInfo info)
   {
      if ( info.getFront() == Neighbor.OTHER ) // Infect other if there is other critter infront of Lion
      {
         return Action.INFECT;
      }
      else if ( info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL ) // turn left if there is Wall in front of Lion or Wall on the right of Lion
      {
         return Action.LEFT;
      }
      else if ( info.getFront() == Neighbor.SAME ) // turn Right if there is Lion in front of Critter.
      {
         return Action.RIGHT;
      }
      else // otherwise go front.
      {
         return Action.HOP;
      }
   }
}