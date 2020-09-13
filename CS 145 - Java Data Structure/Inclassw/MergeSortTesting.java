import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class MergeSortTesting
{
  private List<Person> myList= new ArrayList<Person>();
  public static void main(String[] args) 
  {
     MergeSortTesting obj = new MergeSortTesting();
     obj.run();
  }
  
  public void run()
  {
    //MAKE SURE TO UNCOMMENT ONE OF THE LINES BELOW
    File f = new File("DataFileInClass5.txt");
    //File f = new File("DataFileInClass5ver2.txt");
    
    Scanner scan = null;
    try
    {
      scan = new Scanner(f);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File Not found");
      System.exit(0);
    }
     
    while(scan.hasNext())
    {
      int i = scan.nextInt();
      String a = scan.next();
      String b = scan.next();
      Person temp = new Person(i,a,b);
      myList.add(temp);
      
      //System.out.println(temp);
    }
    
    //System.out.println(myList);
    long startTime = System.currentTimeMillis();
    Collections.sort(myList); 
    long endTime = System.currentTimeMillis();
    sortListByID(myList); 
    long endTime2 = System.currentTimeMillis();
    System.out.println("Checking the order");
    for (int i=0;i<5;i++) System.out.println(myList.get(i));
    
    System.out.println();    
    System.out.printf("The computer sort took %d (ms) to run.%n" , endTime-startTime);
    System.out.printf("          My sort took %d (ms) to run.%n" , endTime2-endTime);
    
  }
 
  private class Person implements Comparable<Person>
  {
    private String fName;
    private String lName;
    private int ID;
    
    public int getID()
    {return ID;}
    
    public String getName()
    {return fName + " " + lName;}
    
    Person(int a, String b, String c)
    {
      fName = b;
      lName = c;
      ID = a;
    } 
    public String toString()
    {return "["+lName +", " + fName + " #" + ID+"]";}
    public int compareTo(Person o)
    {
      if (lName.compareTo(o.lName)==0) return fName.compareTo(o.fName);
      else return lName.compareTo(o.lName);
    }
  }
  
  private static void sortListByID (List<Person> theList)
  {
   
   if (theList.size() != 1) // if the List size is not 1 run the loop
   {
      List<Person> left = new ArrayList<Person>(); // make left list for dividing

      List<Person> right = new ArrayList<Person>(); // mkae right list for dividing
      
      int counter = 0; // make counter to divide String
     
      
      while (!theList.isEmpty()) // while List is not Empty run loop
      {
         if (counter % 2 == 0) 
         {
            left.add((Person) theList.remove(0)); // add ID to the left ArrayLists to compare ID
            counter++;
         } 
         else 
         {
            right.add((Person) theList.remove(0)); // add ID to the right ArrayLists to compare ID
            counter++;
         }
      }
     
     sortListByID(left); // use recursion to divide for making list's size 1 to compare ID
     sortListByID(right); // use recursion to divide for making list's size 1 to compare ID
     
     theList.addAll(Merging(left,right)); // add sorted list to the list.
    }
   }
   
   private static List<Person> Merging(List<Person> left,List<Person> right) // make Merging function to compare left and right arraylists
   {
      List<Person> Merged_List = new ArrayList<>(); // make Merged_List to put sorted number
      
      while (!left.isEmpty() && !right.isEmpty()) 
      {
         
         if (left.get(0).getID() <= (right.get(0).getID())) // if left's ID is lower than right put left ID first
         {
            Merged_List.add(left.remove(0));
         }
         else  // if right's ID is lower than left put right ID first
         {
            Merged_List.add(right.remove(0));
         }
      }
      
      Merged_List.addAll(left); // put all the sorted left arraylist
      Merged_List.addAll(right);// put all the sorted right arraylist
      
      return Merged_List; // return Sorted List to add all into the list
   }
}