/*
 * This Program create Gator Critter which infect other Critter.
 *
 * @author Simon Ha ( 844926202 )
 * @version October 5th 
*/


import java.awt.*;
import java.util.*;

public class Gator extends Critter
{
   Random rand = new Random();
   
   public Gator()
   {
   }
   
   public Color getColor() // get Color Yellow
   {
      int x = rand.nextInt(5);
      if ( x == 0 )
      {
         return Color.RED;
      }
      else if ( x == 1 )
      {
         return Color.YELLOW;
      }
      else if ( x == 2 )
      {
         return Color.BLACK;
      }
      else if ( x == 3 )
      {
         return Color.GREEN;
      }
      else
      {
         return Color.BLUE;
      }
   }
   
   public String toString() // get String *>*
   {
      return "*>*";
   }
   
   public Action getMove(CritterInfo info) 
   {
      if ( info.getFront() == Neighbor.OTHER && info.getFrontDirection() == Direction.NORTH) // Infect other if the other critter is in front of Gator and facing North.
      { 
         return Action.INFECT;
      }
      else if ( info.getFront() == Neighbor.WALL || info.getFront() == Neighbor.SAME ) // if there is wall or Same Critter, turn left.
      {
         return Action.LEFT;
      }
      else if ( info.getBack() == Negibor.SAME )
      {
         return Action.RIGHT;
      }
      else // otherwise go front.
      {
         return Action.HOP;
      }
   }
}
