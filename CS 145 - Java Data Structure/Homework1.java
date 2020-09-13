public class Homework1
{
   public static void main(String[] args)
   {
      Animal[] Ani_Array = new Animal[5];
      
      Ani_Array[0] = new Animal( "Cat", 2, 1, 2);
      Ani_Array[1] = new Animal( "Dog", 3, 3, 2);
      Ani_Array[2] = new Animal( "Sloth", 4, -4, -2); 
      Ani_Array[3] = new Animal( "Mice", 5 , -5, -6);
      Ani_Array[4] = new Animal( "Chicken",3 , 0, -1);

      int fight_counter;
      int round_counter;
      
      fight_counter = 0;
      round_counter = 0;
      
      for ( int i = 0 ; i < 5 ; i++)
      {
         System.out.println(Ani_Array[i].toString()); 
      }
      
      while( fight_counter < 6 )
      {
         
         System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
         
         for ( int i = 0; i < 5 ; i++)
         {
            Ani_Array[i].move();
         }
         
         for ( int i = 1 ; i < 5; i++)
         {
            if ( Ani_Array[0].touching(Ani_Array[i]) )
            {
               fight_counter++;
               System.out.println( Ani_Array[0].getname() + " is the same place with " + Ani_Array[i].getname() );
            }
         }
         
         for ( int i = 2 ; i < 5; i++)
         {
            if ( Ani_Array[1].touching(Ani_Array[i]) )
            {
               fight_counter++;
               System.out.println( Ani_Array[1].getname() + " is the same place with " + Ani_Array[i].getname() );
            }
         }
         
         for (  int i = 3 ; i < 5; i++)
         {
            if ( Ani_Array[2].touching(Ani_Array[i]))
            {
               fight_counter++;
               System.out.println( Ani_Array[1].getname() + " is the same place with " + Ani_Array[i].getname() );
            }
         }
         
         if ( Ani_Array[3].touching(Ani_Array[4]))
         {
            fight_counter++;
            System.out.println( Ani_Array[3].getname() + " is the same place with " + Ani_Array[4].getname() );
         }
         
         for ( int i = 0 ; i < 5 ; i++)
         {
            System.out.println(Ani_Array[i].toString()); 
         }
         round_counter++;
      }
      
      System.out.println();
      
      System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
      
      System.out.println();
   
      System.out.println(" The Total Number of fight is " + fight_counter + " and the Total Number of round is " + round_counter);
      System.out.println();
      
      System.out.println(" The final locations of animals are these");
      System.out.println();
      for ( int i = 0 ; i < 5 ; i++)
      {
         System.out.println(Ani_Array[i].toString()); 
      }
  }
}