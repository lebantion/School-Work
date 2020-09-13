/*
 * This Class is implement of Animal to use Cat to save date in array.
 *
 * @param name name for the animal
 * @version 1.0 (October 2 2018)
 * @author Simon Ha ( SeongRok Ha )
*/

public class Cat implements Animal
{
   private String name;
   
   public Cat(String x) // define Cat function to define name
   {
      name = x;
      getname();
   }
   
   public String getname() // make getname function to printout name
   {
      return name;
   }
   
   public String makeSound() // make makeSound function to print out the sound how they howl.
   {
      return "Purr";
   }
}