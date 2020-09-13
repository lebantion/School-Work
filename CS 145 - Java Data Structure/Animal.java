import java.util.*;

public class Animal
{
   Random ran_num = new Random();
   
   private String name;
   private int Max_speed;
   private int X_Coordinate;
   private int Y_Coordinate;
   
   public Animal(String ani_name, int speed, int x, int y)
   {
      name = ani_name;
      Max_speed = speed;
      X_Coordinate = x;
      Y_Coordinate = y;
   }
   
   public Animal()
   {
      name = "Unknown";
      Max_speed = 2;
      X_Coordinate = 0;
      Y_Coordinate = 0;
   }
   
   public int getX()
   {
      return X_Coordinate;
   }
   public int getY()
   {
      return Y_Coordinate;
   }
   
   public String getname()
   {
      return name;
   }
   
   public String toString()
   {
      return "X Coordinate is : " + X_Coordinate + ", Y Coordinate is : " + Y_Coordinate + " and the animal's name is : " + name;
   }
   
   public boolean touching(Animal x)
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
   
   public void move()
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
      
      if ( X_Coordinate > 10 || X_Coordinate < -10 )
      {
         X_Coordinate = ran_num.nextInt(20) - 10;
      }
      
      if ( Y_Coordinate > 10 || Y_Coordinate < -10 )
      {
         Y_Coordinate = ran_num.nextInt(20) - 10;
      }
   }
   
}