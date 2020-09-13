/* CS145
 * Class AnagramMain is the driver program for the Anagram program.  It reads a
 * dictionary of words to be used during the game and then asks the user to create a
 * data structure to sort through them.
 */
 
 
import java.util.*;
import java.io.*;

public class AnagramMain {
	public static final String DICTIONARY_FILE = "dictionary.txt";
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Welcome to the CS145 Anagram Practice");
		System.out.println();

		// open the dictionary file and read dictionary into an ArrayList
		Scanner input = new Scanner(new File(DICTIONARY_FILE));
      Scanner keyboard = new Scanner(System.in);
		List<String> dictionary = new ArrayList<String>();
		while (input.hasNext()) {
			dictionary.add(input.next().toLowerCase());
		}
      
		// set up the AnagramManager
		List<String> dictionary2 = Collections.unmodifiableList(dictionary);
		AnagramManager catalog = new AnagramManager(dictionary2);
      
      // Start the program asking for run style
      System.out.println("Press enter to start, or any other input for debug mode");
      String DEBUG = keyboard.nextLine();

      // If in DEBUG mode
      if (!DEBUG.equals("") )
      {
        System.out.println("** The first and last five sorted by word elements are **");
        catalog.sortByWord();
        System.out.println(catalog);
        System.out.println("** The first and last five sorted by form elements are **");
        catalog.sortByForm();
        System.out.println(catalog);
        System.out.println("\n\n\n");
      }

      // Start the Loop
      getAnagram(keyboard, catalog);

	}

	// Executes the primary anagram loop
	public static void getAnagram(Scanner console, AnagramManager theCatalog) 
   {
      String input;
      System.out.println("Please type in a word to anagram or QUIT to quit :");
      input = console.nextLine();

      while (!input.toUpperCase().equals("QUIT") && !input.equals("") ) 
      {
        String result = theCatalog.getAnagram(input);
        if (!result.equals("") )
        {
         System.out.print("One possible anagram of your word " + input );
         System.out.println(" is " +result);
        }
        else
        {
          System.out.println("Your word was not found in the list");
        }

        System.out.print("In fact the list of anagrams for your word are : ");
        System.out.println(theCatalog.getAnagrams(input));

        System.out.println("Please type in a word to anagram or QUIT to quit :");
        input = console.nextLine();
      }
	}
}
