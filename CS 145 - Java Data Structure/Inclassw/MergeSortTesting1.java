import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class MergeSortTesting1
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
    System.out.println(myList);
    
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
   
   if (theList.size() != 1) 
   {
      List<Person> left = new ArrayList<Person>();

      List<Person> right = new ArrayList<Person>();
      
      int counter = 0;
     
      
      while (!theList.isEmpty()) 
      {
         if (counter % 2 == 0) 
         {
            left.add((Person) theList.remove(0));
            counter++;
         } 
         else 
         {
            right.add((Person) theList.remove(0));
            counter++;
         }
      }
     
     sortListByID(left);
     sortListByID(right);
     Merging(left,right,theList);
    }
   }
   
   private static void Merging(List<Person> left,List<Person> right,List<Person> theList)
   {
      List<Person> Merged_List = new ArrayList<>();
      
      while (!left.isEmpty() && !right.isEmpty()) 
      {
         
         if (left.get(0).getID() <= (right.get(0).getID())) 
         {
            Merged_List.add(left.remove(0));
         }
         else 
         {
            Merged_List.add(right.remove(0));
         }
      }
      theList.addAll(Merged_List);
   }
}