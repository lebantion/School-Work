/*
 * This Program create Giant Critter which infect other Critter.
 *
 * @param step_counter to make toString() print out 4 different step depend on how many step they did.
 * @author Simon Ha ( 844926202 )
 * @version October 5th 
*/

import java.awt.*;


public class Giant extends Critter
{
   private int step_counter;
   public Giant()
   {
   }
   
   public Color getColor() // set Giant Color Gray
   {
      return Color.GRAY;
   }
   
   public String toString()
   {  
      if ( step_counter < 6 && step_counter >= 0 ) // when the step is 0 ~ 5
      {
         step_counter++;
         return "fee";
      }
      else if ( step_counter < 12 && step_counter > 5) // when the step is 6 to 11
      {
         step_counter++;
         return "fie";
      }
      else if ( step_counter < 18 && step_counter > 11 ) // when the step is 12 to 17
      {
         step_counter++;
         return "foe";
      }
      else if ( step_counter < 24 && step_counter > 17 ) // when the step is 18 to 23
      {
         step_counter++;
         return "fum";
      }
      else // else step_counter is default or 24 reset the counter to 0.
      {
         step_counter = 0;
         return "fee";
      }
   
   }
   
   public Action getMove(CritterInfo info)
   {
      if ( info.getFront() == Neighbor.OTHER ) // infect other critter
      {
         return Action.INFECT;
      }
      else if ( info.getFront() == Neighbor.EMPTY ) // go front if front side is empty.
      {
         return Action.HOP;
      }
      else // otherwise turn right.
      {
         return Action.RIGHT;
      }
   }
}