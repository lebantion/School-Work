/*
 * CS 145
 *
 * Card Array Master is a generic class usefull for you to test your 
 * CardArrayList class.   At the beginning it is heavily commented out
 * but as you get more and more working, you can remove sections
 * to test various things out.
 */
import java.util.*;
import java.io.*;

public class CardArrayMaster {

	public static void main(String[] args)
   {
     PrintStream SO = System.out;  // Lazy mode  enabled;
     
     // STAGE 1
     // Can we add to a master list and print it out?
     CardArrayList masterList1 = new CardArrayList();
     masterList1.add(new Card());     
     masterList1.add(new Card(20));     
     masterList1.add(new Card(10,10));
     SO.print("Initial list   : "); 
     SO.println(masterList1);     
   
     // STAGE 2
     // Can we add a premium card? 
      masterList1.add(new PremiumCard(100));     
      SO.print("Premium Card   : "); 
      SO.println(masterList1);

     // STAGE 3
     // Can we add cars in the middle?
     
     masterList1.add(1, new Card(4,4));
     masterList1.add(1, new Card(5,5));
     SO.print("Added internal : "); 
     SO.println(masterList1);
     
     // STAGE 4
     // can we add more cards and make it expand?
     
     masterList1.add(new Card(6));
     masterList1.add(new Card(7));
     masterList1.add(new Card(8));
     masterList1.add(new Card(9));
     masterList1.add(new Card(10));
     masterList1.add(new Card(11));
     masterList1.add(new Card(12));
     SO.print("After Expand   : "); 
     SO.println(masterList1);

     // STAGE 5
     // Can we Remove the end value
     masterList1.remove();
     SO.print("After Remove   : "); 
     SO.println(masterList1);
     
     // STAGE 6
     // Does remove return the removed value?
     
     SO.print("Removed value  : "); 
     SO.println( masterList1.remove() );
     SO.print("List afterward : "); 
     SO.println(masterList1);
     
     // STAGE 7
     // Did it remove from the middle
     // And return the value removed?
     Card tmp = masterList1.remove(2);
     SO.print("Removed value  : "); 
     SO.println(tmp);
     SO.print("List afterward : "); 
     SO.println(masterList1);
     
     // STAGE 8
     // Did get work correctly?
     SO.print("Get Values     : "); 
     SO.println(masterList1.get(2) + " : " + masterList1.get(4) );
     masterList1.get(2).weaken();
     masterList1.get(4).boost();
     SO.print("Altered Values : "); 
     SO.println(masterList1.get(2) + " : " + masterList1.get(4) );    

     // STAGE 9
     // IndexOF
     
     SO.print("Found Success  : ");
     SO.println(masterList1.indexOf(new Card(110,110)));
     SO.print("Found Failed   : ");
     SO.println(masterList1.indexOf(new Card(99,99))); 
     SO.print("Found Failed   : ");
     SO.println(masterList1.indexOf(new Card(600,600)));
     
     // STAGE 10
     // Does shuffle work?
     SO.print("Before shuffle : ");
     SO.println(masterList1);
     masterList1.shuffle();
     SO.print("Post shuffle 1 : ");
     SO.println(masterList1);
     masterList1.shuffle();
     SO.print("Post shuffle 2 : ");
     SO.println(masterList1);
     
     // STAGE 11
     // Does Clear Work?
     masterList1.clear();
     SO.print("After Clear    : ");
     SO.println(masterList1);
     
     // STAGE 12
     // Create a large list
     // And check that sort works.
     
     for (int i=0; i <100; i++)
     {
       masterList1.add(new Card());
     }
     for (int i=0; i <5; i++)
     {
       masterList1.add(new PremiumCard());
     }
     
     SO.print("Before Sorted  : ");
     SO.println(masterList1);
     masterList1.sort();
     SO.print("Success Sorted : ");
     SO.println(masterList1);

     // STAGE 13
     // Can we create a second list
     // and make a copy of all NON premium cards
     
     CardArrayList masterList2 = new CardArrayList(1);
     
     for (int j = 0; j <masterList1.size(); j++)
     {
       if (!(masterList1.get(j) instanceof PremiumCard))
       {
         masterList2.add(masterList1.get(j) );
       }
     }
     
     SO.print("Success Removed: ");
     SO.println(masterList2);
   }
}