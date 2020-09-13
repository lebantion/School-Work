/*
 * This Program create Polar Bear or Bear Critter which infect other Critter.
 *
 *
 * @param polar_bear for making sure that is polar bear or not so that program put color of them.
 * @param move_count to make toString() print out / and \ when they step.
 * @author Simon Ha ( 844926202 )
 * @version October 5th 
*/

import java.awt.*;

public class Bear extends Critter
{
   private boolean polar_bear;
   private int move_count;
   
   
   public Bear (boolean polar) // get information whether its polar bear or not.
   { 
    polar_bear = polar;   
   }
   
   public Color getColor() // get color of bear or polar bear
   {
      if ( polar_bear == true)
      {
         return Color.WHITE;
      }
      else 
      {
         return Color.BLACK;
      }
   }
   
   public String toString() // to make alternative step, use move_count to verify which step do they have to.
   {
      if (move_count % 2 == 0)
      {
         move_count++;
         return "/";
      }
      else
      {
         move_count++;
         return "\\";
      }
   }
   
   public Action getMove(CritterInfo info) // make Bear act Something (Critter)
   {
       if ( info.getFront() == Neighbor.OTHER ) // act infect other critter
      {
         return Action.INFECT;
      }
      else if ( info.getFront() == Neighbor.EMPTY) // make bear go front
      {
         return Action.HOP;
      }
      else  // make baer turn left.
      {
         return Action.LEFT;
      }
   }
}