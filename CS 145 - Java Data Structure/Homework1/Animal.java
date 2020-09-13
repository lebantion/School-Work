/**
 * This class get information about Animal and move that animal to random direction
 * with random number.
 * @param name name is for animal's name
 * @param Max_speed this parameter save maximum speed that the animal could move
 * @param X_Coordinate this is animal's x coordinate
 * @param Y_Coordiante this is animal's y coordinate 
 * @author SeongRok Ha
 * @version 1.0 (Sep 28 2018)
*/

import java.util.*;

public class Animal
{
   Random ran_num = new Random();
   
   private String name;
   private int Max_speed;
   private int X_Coordinate;
   private int Y_Coordinate;
   
   public Animal(String ani_name, int speed, int x, int y) // get name, speed, x and y.
   {
      name = ani_name;
      Max_speed = speed;
      if ( x > 10 || x < -10 )
      {
         X_Coordinate = ran_num.nextInt(20) - 10;
      }
      else
      {
         X_Coordinate = x;
      }
      if ( y > 10 || y < -10 )
      {
         Y_Coordinate = ran_num.nextInt(20) - 10;
      }
      else
      {
         Y_Coordinate = y;
      }
   }
   
   public Animal() // default contruction
   {
      name = "Unknown";
      Max_speed = 2;
      X_Coordinate = 0;
      Y_Coordinate = 0;
   }
   
   public int getX() // get X
   {
      return X_Coordinate;
   }
   public int getY() // get Y
   {
      return Y_Coordinate;
   }
   
   public String getname() // get name
   {
      return name;
   }
   
   public String toString() // show X Coordinate, Y Coordinate and Name.
   {
      return "X Coordinate is : " + getX() + ", Y Coordinate is : " + getY() + " and the animal's name is : " + getname();
   }
   
   public boolean touching(Animal x) // show 2 animal is in the same place or not
   {
    if ( X_Coordinate == x.getX() && Y_Coordinate == x.getY() )
    {
      return true;
    }
    else
    {
      return false;
    }
   }
   
   public void move() // move animal to the one direction with random speed.
   {
      int direction = ran_num.nextInt(4);
      int random_move = ran_num.nextInt( Max_speed ) + 1;
      if ( direction == 0 )
      {
         X_Coordinate += random_move;
      }
      else if ( direction == 1 )
      {
         X_Coordinate -= random_move;
      }
      else if ( direction == 2 )
      {
         Y_Coordinate += random_move;
      }
      else if ( direction == 3 )
      {
         Y_Coordinate -= random_move;
      }
      
      if ( X_Coordinate > 10 || X_Coordinate < -10 ) //reset coordinate if it is over 10 and less than - 10
      {
         X_Coordinate = ran_num.nextInt(20) - 10;
      }
      
      if ( Y_Coordinate > 10 || Y_Coordinate < -10 ) //reset coordinate if it is over 10 and less than - 10
      {
         Y_Coordinate = ran_num.nextInt(20) - 10;
      }
   }
   
}