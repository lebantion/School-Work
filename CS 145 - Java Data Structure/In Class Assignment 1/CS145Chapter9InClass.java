/*
 * This program will printout how do animals howl.
 *
 *
 *
 *
 
 * @version 1.0 IN CLASS ( October 2 2018 )
 * @author Simon Ha ( SeongRok Ha )
*/


public class CS145Chapter9InClass
{
   public static void main(String[] args)
   {
      Animal[] pets = new Animal[6];
      pets[0] = new Dog("Fred"); // put data of Dog in pets
      pets[1] = new Dog("Ben"); // put data of Dog in pets
      pets[2] = new Cat("Sue"); // put data of Cat in pets
      pets[3] = new Cat("Julie"); // put data of Cat in pets
      pets[4] = new Kitten("Maria"); // put data of Kitten in pets
      pets[5] = new Puppy("Lee"); // put data of Puppy in pets
 
      for(int i = 0; i < pets.length; i++)
      {
         System.out.print(pets[i].getname()); // print out name
         System.out.println(" says " + pets[i].makeSound() ); // print out how they howl
      }
   }
}